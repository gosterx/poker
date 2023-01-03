package org.example.application
package domain

import cats.Show
import cats.implicits.toShow

final case class Card(rank: CardRank, suite: CardSuite)

object Card {
  implicit val show: Show[Card] = Show.show { card =>
    s"${card.rank.show}${card.suite.show}"
  }
}
