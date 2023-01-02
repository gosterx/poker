package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class Pair private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 2
}

object PairTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object PairOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
