package org.example.application
package combination

import domain.{Board, Card, Hand}

import org.example.application.comparing.ComparingStatus

final case class FourOfKind private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 8
}

object FourOfKindTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}

object FourOfKindOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
