package org.example.application
package boot

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    AppRunner.run[IO]().as(ExitCode.Success)
}
