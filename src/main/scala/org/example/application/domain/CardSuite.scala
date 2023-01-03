package org.example.application
package domain

import cats.Show
import enumeratum.{Enum, EnumEntry}

sealed abstract class CardSuite(override val entryName: String) extends EnumEntry

object CardSuite extends Enum[CardSuite] {
  override def values: IndexedSeq[CardSuite] = findValues

  case object Spades extends CardSuite("s")
  case object Clubs extends CardSuite("c")
  case object Hearts extends CardSuite("h")
  case object Diamonds extends CardSuite("d")

  implicit val show: Show[CardSuite] = Show.show(_.entryName)
}
