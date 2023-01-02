package org.example.application
package comparing

import combination.{Combination, StraightFlush}

import org.example.application.comparing.ComparingStatus

object CombinationsComparator {
  def compare(c1: Combination, c2: Combination): ComparingStatus = {
    if (c1.power > c2.power) ComparingStatus.Stronger
    else if (c1.power < c2.power) ComparingStatus.Weaker
    else
      c1 match {
        case _: StraightFlush => ???
      }
  }
}
