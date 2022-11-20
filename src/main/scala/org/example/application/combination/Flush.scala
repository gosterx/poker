package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class Flush private (cards: List[Card]) extends Combination {
  override def power: Int = 6
}

object Flush extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
