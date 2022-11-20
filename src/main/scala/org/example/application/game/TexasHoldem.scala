package org.example.application
package game

import domain.{Board, Hand}

object TexasHoldem extends Game {
  override def process(board: Board, hands: List[Hand]): List[Hand] = ???
}
