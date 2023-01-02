package org.example.application
package combination

import domain.{Board, Card, Hand}

final case class FullHouse private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 7
}

object FullHouseTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}

object FullHouseOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
