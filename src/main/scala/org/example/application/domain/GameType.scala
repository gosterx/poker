package org.example.application
package domain

import enumeratum.{EnumEntry, Enum}

sealed trait GameType extends EnumEntry

object GameType extends Enum[GameType] {
  override def values: IndexedSeq[GameType] = findValues

  case object TexasHoldem extends GameType
  case object OmahaHoldem extends GameType
  case object FiveCardDraw extends GameType
}
