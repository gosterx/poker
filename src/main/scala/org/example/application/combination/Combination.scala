package org.example.application
package combination

import domain.Card

trait Combination {
  def cards: List[Card]

  def kickers: List[Card]

  def power: Int

  def compareWith(that: Combination): Boolean
}