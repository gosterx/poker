package org.example.application
package error

sealed trait ParserError extends ApplicationError

object ParserError {
  final case class GameTypeParsingError(gameType: String) extends ParserError {
    override def message: String = s"No such game type as '$gameType'"
  }

  final case object InvalidInputFormat extends ParserError {
    override def message: String = "Invalid input format"
  }

  final case class CardRankParsingError(rank: String) extends ParserError {
    override def message: String = s"No such card rank as '$rank'"
  }

  final case class CardSuiteParsingError(suite: String) extends ParserError {
    override def message: String = s"No such card suite as '$suite'"
  }
}
