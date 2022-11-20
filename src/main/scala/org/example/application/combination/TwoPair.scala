package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class TwoPair private (cards: List[Card]) extends Combination {
  override def power: Int = 3
}

object TwoPair extends CombinationSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
