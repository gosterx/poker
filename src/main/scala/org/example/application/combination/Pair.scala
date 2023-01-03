package org.example.application
package combination

import domain.{Board, Card, Hand}

import org.example.application.comparing.ComparingStatus

final case class Pair private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 2
}

object PairTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = {
    val cards: List[Card] = board.cards ++ hand.cards

    cards.groupBy(_.rank).values.find(_.size == 2).map { combination =>
      val kickers = cards.diff(combination).sortBy(_.rank.value).reverse.take(3)

      Pair(combination, kickers)
    }
  }

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = {
    if (c1.cards.head.rank.value > c2.cards.head.rank.value) ComparingStatus.Stronger
    else if (c1.cards.head.rank.value < c2.cards.head.rank.value) ComparingStatus.Weaker
    else {
      val first: List[Int]  = c1.kickers.map(_.rank.value)
      val second: List[Int] = c2.kickers.map(_.rank.value)

      (for {
        index <- List.range(0, first.length)
      } yield {
        if (first(index) > second(index)) ComparingStatus.Stronger
        else if (first(index) < second(index)) ComparingStatus.Weaker
        else ComparingStatus.Equal
      }).find(_ != ComparingStatus.Equal).getOrElse(ComparingStatus.Equal)
    }
  }
}

object PairOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
