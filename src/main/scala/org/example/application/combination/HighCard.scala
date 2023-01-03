package org.example.application
package combination

import domain.{Board, Card, Hand}

import cats.implicits.catsSyntaxOptionId
import org.example.application.comparing.ComparingStatus

final case class HighCard private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 1
}

object HighCardTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = {
    val cards: List[Card] = board.cards ++ hand.cards

    HighCard(cards.sortBy(_.rank.value).reverse.take(5), List.empty).some
  }

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = {
    val first: List[Int] = c1.cards.map(_.rank.value)
    val second: List[Int] = c2.cards.map(_.rank.value)

    (for {
      index <- List.range(0, first.length)
    } yield {
      if (first(index) > second(index)) ComparingStatus.Stronger
      else if (first(index) < second(index)) ComparingStatus.Weaker
      else ComparingStatus.Equal
    }).find(_ != ComparingStatus.Equal).getOrElse(ComparingStatus.Equal)
  }

}

object HighCardOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
