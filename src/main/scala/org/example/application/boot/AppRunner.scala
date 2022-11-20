package org.example.application
package boot

import cats.syntax.all._
import cats.effect.std.Console
import util.Parser

import cats.effect.kernel.Sync
import error.ApplicationError

import domain.GameType
import game._

object AppRunner {
  def run[F[_]: Console: Sync](): F[Unit] =
    (for {
      _     <- Console[F].println("Input:")
      input <- Console[F].readLine
      parser = Parser[F]()
      data  <- parser.parse(input)
      result <- (data.gameType match {
        case GameType.TexasHoldem  => TexasHoldem.process(data.board, data.hands)
        case GameType.OmahaHoldem  => OmahaHoldem.process(data.board, data.hands)
        case GameType.FiveCardDraw => FiveCardDraw.process(data.board, data.hands)
      }).pure[F]
    } yield ()).recoverWith {
      case error: ApplicationError => Console[F].println(error.show)
    }
}
