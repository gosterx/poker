package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class FourOfKind private (cards: List[Card]) extends Combination {
  override def power: Int = 8
}

object FourOfKind extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
