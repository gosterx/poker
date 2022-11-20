package org.example.application
package boot

import cats.syntax.all._
import cats.effect.std.Console
import util.Parser

import cats.effect.kernel.Sync
import error.ApplicationError

object AppRunner {
  def run[F[_]: Console: Sync](): F[Unit] =
    (for {
      _     <- Console[F].println("Input:")
      input <- Console[F].readLine
      parser = Parser[F]()
      data  <- parser.parse(input)
      _     <- Console[F].println(data)
    } yield ()).recoverWith {
      case error: ApplicationError => Console[F].println(s"Error: ${error.message}")
    }
}
