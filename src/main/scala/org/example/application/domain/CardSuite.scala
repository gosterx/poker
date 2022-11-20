package org.example.application
package domain

import enumeratum.{EnumEntry, Enum}

sealed abstract class CardSuite(override val entryName: String) extends EnumEntry

object CardSuite extends Enum[CardSuite] {
  override def values: IndexedSeq[CardSuite] = findValues

  case object Spades extends CardSuite("s")
  case object Clubs extends CardSuite("c")
  case object Hearts extends CardSuite("h")
  case object Diamonds extends CardSuite("d")
}
