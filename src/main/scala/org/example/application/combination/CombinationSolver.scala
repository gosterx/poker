package org.example.application
package combination

import domain.{Board, Hand}

import org.example.application.comparing.ComparingStatus

sealed trait CombinationSolver {
  def of(board: Board, hand: Hand): Option[Combination]
}

sealed trait SameCombinationsComparator {
  def compareWith(that: Combination): ComparingStatus
}

trait TexasHoldemSolver extends CombinationSolver with SameCombinationsComparator

object TexasHoldemSolver {
  final val all: List[TexasHoldemSolver] = List(
    StraightFlushTexasHoldem,
    FourOfKindTexasHoldem,
    FullHouseTexasHoldem,
    FlushTexasHoldem,
    StraightFlushTexasHoldem,
    ThreeOfKindTexasHoldem,
    TwoPairTexasHoldem,
    PairTexasHoldem,
    HighCardTexasHoldem
  )
}

trait OmahaHoldemSolver extends CombinationSolver

object OmahaHoldemSolver {
  final val all: List[OmahaHoldemSolver] = List(
    StraightFlushOmahaHoldem,
    FourOfKindOmahaHoldem,
    FullHouseOmahaHoldem,
    FlushOmahaHoldem,
    StraightFlushOmahaHoldem,
    ThreeOfKindOmahaHoldem,
    TwoPairOmahaHoldem,
    PairOmahaHoldem,
    HighCardOmahaHoldem
  )

}
