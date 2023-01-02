package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class Flush private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 6
}

object FlushTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object FlushOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}