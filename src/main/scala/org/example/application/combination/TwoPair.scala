package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class TwoPair private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 3
}

object TwoPairTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object TwoPairOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
