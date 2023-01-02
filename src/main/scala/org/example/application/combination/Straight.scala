package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class Straight private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 5
}

object StraightTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object StraightOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
