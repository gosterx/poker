package org.example.application
package domain

import enumeratum.{EnumEntry, Enum}

sealed trait CardRank extends EnumEntry

object CardRank extends Enum[CardRank] {
  override def values: IndexedSeq[CardRank] = findValues

  case object Two extends CardRank
  case object Three extends CardRank
  case object Four extends CardRank
  case object Five extends CardRank
  case object Six extends CardRank
  case object Seven extends CardRank
  case object Eight extends CardRank
  case object Nine extends CardRank
  case object Ten extends CardRank
  case object Jack extends CardRank
  case object Queen extends CardRank
  case object King extends CardRank
  case object Ace extends CardRank
}
