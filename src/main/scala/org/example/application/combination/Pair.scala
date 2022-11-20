package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class Pair private (cards: List[Card]) extends Combination {
  override def power: Int = 2
}

object Pair extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
