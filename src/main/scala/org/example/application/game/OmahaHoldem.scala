package org.example.application
package game

import domain.{Board, Hand}

object OmahaHoldem extends Game {
  override def process(board: Board, hands: List[Hand]): List[Hand] = ???
}
