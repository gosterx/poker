package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class FullHouse private (cards: List[Card]) extends Combination {
  override def power: Int = 7
}

object FullHouse extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
