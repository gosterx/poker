package org.example.application
package util

import cats.syntax.all._
import cats.effect.kernel.Sync
import domain.{Board, Card, CardRank, CardSuite, GameType, Hand, InputData}
import domain.GameType._
import error.ParserError.{CardRankParsingError, CardSuiteParsingError, GameTypeParsingError, InvalidInputFormat}

final class Parser[F[_]: Sync] private {
  private def isInputValid(gameType: GameType, board: String, hands: List[String]): Boolean =
    gameType match {
      case TexasHoldem  => board.length == 10 && hands.nonEmpty && !hands.exists(_.length != 4)
      case OmahaHoldem  => board.length == 10 && hands.nonEmpty && !hands.exists(_.length != 8)
      case FiveCardDraw => board.length == 10 && hands.nonEmpty && !hands.exists(_.length != 10)
    }

  private def parseCard(input: String): F[Card] =
    input.grouped(1).toList match {
      case rank :: suite :: Nil =>
        for {
          rank <- CardRank.withNameOption(rank) match {
            case Some(value) => value.pure[F]
            case None        => CardRankParsingError(rank).raiseError
          }
          suite <- CardSuite.withNameOption(suite) match {
            case Some(value) => value.pure[F]
            case None        => CardSuiteParsingError(suite).raiseError
          }
        } yield Card(rank, suite)
    }

  private def parseBoard(input: String): F[Board] =
    input.grouped(2).toList.traverse(parseCard).map(Board)

  private def parseHands(input: List[String]): F[List[Hand]] =
    input.traverse(_.grouped(2).toList.traverse(parseCard).map(Hand(_)))

  def parse(input: String): F[InputData] =
    input.split(' ').toList match {
      case gameType :: board :: hands =>
        for {
          gameType <- GameType.withNameOption(gameType) match {
            case Some(value) => value.pure[F]
            case None        => GameTypeParsingError(gameType).raiseError
          }
          _ <- Sync[F].ifM(isInputValid(gameType, board, hands).pure[F])(Sync[F].unit, InvalidInputFormat.raiseError)
          board <- parseBoard(board)
          hands <- parseHands(hands)
        } yield InputData(gameType, board, hands)
      case _ => InvalidInputFormat.raiseError
    }
}

object Parser {
  def apply[F[_]: Sync](): Parser[F] = new Parser[F]
}
