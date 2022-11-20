package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class ThreeOfKind private (cards: List[Card]) extends Combination {
  override def power: Int = 4
}

object ThreeOfKind extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
