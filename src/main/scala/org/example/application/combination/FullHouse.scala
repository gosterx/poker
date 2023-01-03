package org.example.application
package combination

import domain.{Board, Card, Hand}

import cats.implicits.{catsSyntaxOptionId, none}
import org.example.application.comparing.ComparingStatus

final case class FullHouse private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 7
}

object FullHouseTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = {
    val cards: List[Card] = board.cards ++ hand.cards

    for {
      three <- cards.groupBy(_.rank).values.filter(_.size == 3).toList match {
        case Nil => none
        case threes =>
          threes.reduceLeft { (first, second) =>
            if (first.head.rank.value > second.head.rank.value) first
            else second
          }.some
      }
      two <- cards.diff(three).groupBy(_.rank).values.filter(_.size == 2).toList match {
        case Nil => none
        case twos =>
          twos.reduceLeft { (first, second) =>
            if (first.head.rank.value > second.head.rank.value) first
            else second
          }.some
      }
    } yield FullHouse(three ++ two, List.empty)
  }

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = {
    if (c1.cards.head.rank.value > c2.cards.head.rank.value) ComparingStatus.Stronger
    else if (c1.cards.head.rank.value < c2.cards.head.rank.value) ComparingStatus.Weaker
    else if (c1.cards.last.rank.value > c2.cards.last.rank.value) ComparingStatus.Stronger
    else if (c1.cards.last.rank.value < c2.cards.last.rank.value) ComparingStatus.Weaker
    else ComparingStatus.Equal
  }

}

object FullHouseOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
