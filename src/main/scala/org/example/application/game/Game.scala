package org.example.application
package game

import domain.{Board, Hand}

trait Game {
  def process(board: Board, hands: List[Hand]): List[Hand]
}
