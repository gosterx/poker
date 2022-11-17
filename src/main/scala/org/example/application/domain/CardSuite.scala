package org.example.application
package domain

import enumeratum.{EnumEntry, Enum}

sealed trait CardSuite extends EnumEntry

object CardSuite extends Enum[CardSuite] {
  override def values: IndexedSeq[CardSuite] = findValues

  case object Spades extends CardSuite
  case object Clubs extends CardSuite
  case object Hearts extends CardSuite
  case object Diamonds extends CardSuite
}
