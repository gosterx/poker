package org.example.application
package domain

import cats.Show
import enumeratum.{Enum, EnumEntry}

sealed abstract class CardRank(override val entryName: String) extends EnumEntry {
  def value: Int
}

object CardRank extends Enum[CardRank] {
  override def values: IndexedSeq[CardRank] = findValues

  case object Two extends CardRank("2") {
    override def value: Int = 2
  }
  case object Three extends CardRank("3") {
    override def value: Int = 3
  }
  case object Four extends CardRank("4") {
    override def value: Int = 4
  }
  case object Five extends CardRank("5") {
    override def value: Int = 5
  }
  case object Six extends CardRank("6") {
    override def value: Int = 6
  }
  case object Seven extends CardRank("7") {
    override def value: Int = 7
  }
  case object Eight extends CardRank("8") {
    override def value: Int = 8
  }
  case object Nine extends CardRank("9") {
    override def value: Int = 9
  }
  case object Ten extends CardRank("T") {
    override def value: Int = 10
  }
  case object Jack extends CardRank("J") {
    override def value: Int = 11
  }
  case object Queen extends CardRank("Q") {
    override def value: Int = 12
  }
  case object King extends CardRank("K") {
    override def value: Int = 13
  }
  case object Ace extends CardRank("A") {
    override def value: Int = 14
  }

  implicit val show: Show[CardRank] = Show.show(_.entryName)
}
