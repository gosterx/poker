package org.example.application
package comparing

import combination._

sealed trait CombinationsComparator {
  def compare(c1: Combination, c2: Combination): ComparingStatus
}

object TexasHoldemCombinationsComparator extends CombinationsComparator {
  def compare(c1: Combination, c2: Combination): ComparingStatus = {
    if (c1.power > c2.power) ComparingStatus.Stronger
    else if (c1.power < c2.power) ComparingStatus.Weaker
    else
      c1 match {
        case _: StraightFlush => StraightFlushTexasHoldem.compareSameCombinations(c1, c2)
        case _: Flush => FlushTexasHoldem.compareSameCombinations(c1, c2)
      }
  }
}

object OmahaHoldemCombinationsComparator extends  CombinationsComparator {
  override def compare(c1: Combination, c2: Combination): ComparingStatus = ???
}