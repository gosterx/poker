package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class ThreeOfKind private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 4
}

object ThreeOfKindTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object ThreeOfKindOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
