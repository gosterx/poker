package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class HighCard private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 1
}

object HighCardTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object HighCardOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}