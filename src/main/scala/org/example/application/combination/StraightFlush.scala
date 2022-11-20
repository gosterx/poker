package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class StraightFlush private (cards: List[Card]) extends Combination {
  override def power: Int = 9
}

object StraightFlush extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
