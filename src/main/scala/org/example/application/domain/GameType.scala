package org.example.application
package domain

import enumeratum.{EnumEntry, Enum}

sealed abstract class GameType(override val entryName: String) extends EnumEntry

object GameType extends Enum[GameType] {
  override def values: IndexedSeq[GameType] = findValues

  case object TexasHoldem extends GameType("texas-holdem")
  case object OmahaHoldem extends GameType("omaha-holdem")
  case object FiveCardDraw extends GameType("five-card-draw")
}
