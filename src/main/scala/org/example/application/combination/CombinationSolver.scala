package org.example.application
package combination

import domain.{Board, Hand}

trait CombinationSolver {
  def of(board: Board, hand: Hand): Option[Combination]
}

object CombinationSolver {
  final val all: List[CombinationSolver] =
    List(StraightFlush, FourOfKind, FullHouse, Flush, Straight, ThreeOfKind, TwoPair, Pair, HighCard)
}
