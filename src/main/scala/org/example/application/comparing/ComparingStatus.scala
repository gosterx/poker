package org.example.application
package comparing

import enumeratum.{Enum, EnumEntry}

sealed trait ComparingStatus extends EnumEntry

object ComparingStatus extends Enum[ComparingStatus] {
  override def values: IndexedSeq[ComparingStatus] = findValues

  case object Stronger extends ComparingStatus
  case object Weaker extends ComparingStatus
  case object Equal extends ComparingStatus
}
