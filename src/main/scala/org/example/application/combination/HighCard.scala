package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class HighCard private (cards: List[Card]) extends Combination {
  override def power: Int = 1
}

object HighCard extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}