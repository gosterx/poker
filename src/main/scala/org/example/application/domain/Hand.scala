package org.example.application
package domain

import cats.Show
import cats.implicits.toShow

final case class Hand(cards: List[Card])

object Hand {
  implicit val show: Show[Hand] = Show.show { hand =>
    hand.cards.map(_.show).mkString("")
  }

  implicit val listShow: Show[List[Hand]] = Show.show { hands =>
    hands.map(_.show).mkString(" ")
  }
}

