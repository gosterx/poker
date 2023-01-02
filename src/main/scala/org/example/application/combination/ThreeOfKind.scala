package org.example.application
package combination

import domain.{Board, Card, Hand}

import org.example.application.comparing.ComparingStatus

final case class ThreeOfKind private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 4
}

object ThreeOfKindTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}

object ThreeOfKindOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
