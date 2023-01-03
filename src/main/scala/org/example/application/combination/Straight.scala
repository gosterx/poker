package org.example.application
package combination

import domain.{Board, Card, Hand}

import cats.implicits.none
import org.example.application.comparing.ComparingStatus

final case class Straight private (cards: List[Card], kickers: List[Card]) extends Combination {
  override def power: Int = 5
}

object StraightTexasHoldem extends TexasHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = none

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ComparingStatus.Stronger
}

object StraightOmahaHoldem extends OmahaHoldemSolver {
  override def of(board: Board, hand: Hand): Option[Combination] = ???

  override def compareSameCombinations(c1: Combination, c2: Combination): ComparingStatus = ???
}
