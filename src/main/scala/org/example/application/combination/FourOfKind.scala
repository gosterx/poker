package org.example.application
package combination

import domain.{Board, Card, Hand}

import org.example.application.comparing.ComparingStatus

final case class FourOfKind private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 8
}

object FourOfKindTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = {
    val cards: List[Card] = board.cards ++ hand.cards

    cards.groupBy(_.rank).values.find(_.size == 4).map { combination =>
      val kicker = cards.diff(combination).maxBy(_.rank.value)

      FourOfKind(combination, List(kicker))
    }
  }

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = {
    if (c1.cards.head.rank.value > c2.cards.head.rank.value) ComparingStatus.Stronger
    else if (c1.cards.head.rank.value < c2.cards.head.rank.value) ComparingStatus.Weaker
    else if (c1.kickers.head.rank.value > c2.kickers.head.rank.value) ComparingStatus.Stronger
    else if (c1.kickers.head.rank.value < c2.kickers.head.rank.value) ComparingStatus.Weaker
    else ComparingStatus.Equal
  }
}

object FourOfKindOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
