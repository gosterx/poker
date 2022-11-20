package org.example.application
package domain

import enumeratum.{EnumEntry, Enum}

sealed abstract class CardRank(override val entryName: String) extends EnumEntry

object CardRank extends Enum[CardRank] {
  override def values: IndexedSeq[CardRank] = findValues

  case object Two extends CardRank("2")
  case object Three extends CardRank("3")
  case object Four extends CardRank("4")
  case object Five extends CardRank("5")
  case object Six extends CardRank("6")
  case object Seven extends CardRank("7")
  case object Eight extends CardRank("8")
  case object Nine extends CardRank("9")
  case object Ten extends CardRank("T")
  case object Jack extends CardRank("J")
  case object Queen extends CardRank("Q")
  case object King extends CardRank("K")
  case object Ace extends CardRank("A")
}
