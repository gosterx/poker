package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class Straight private (cards: List[Card]) extends Combination {
  override def power: Int = 5
}

object Straight extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
