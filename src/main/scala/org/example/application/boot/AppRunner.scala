package org.example.application
package boot

import cats.Monad
import cats.syntax.all._
import cats.effect.std.Console

object AppRunner {
  def run[F[_]: Console: Monad](): F[Unit] =
    for {
      _     <- Console[F].println("Input:")
      input <- Console[F].readLine
    } yield ()
}
