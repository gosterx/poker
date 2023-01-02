package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class FourOfKind private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 8
}

object FourOfKindTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object FourOfKindOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
