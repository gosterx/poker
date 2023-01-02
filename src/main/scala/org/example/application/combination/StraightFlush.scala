package org.example.application
package combination

import domain.{Board, Card, Hand}

import org.example.application.comparing.ComparingStatus

final case class StraightFlush private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 9

  override def compareWith(that: Combination): Boolean = ???
}

object StraightFlushTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareWith(that: Combination): ComparingStatus = ???
}

object StraightFlushOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???
}
