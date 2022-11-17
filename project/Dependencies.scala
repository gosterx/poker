import sbt._

object Dependencies {
  object Cats {
    final val core   = "org.typelevel" %% "cats-core"   % "2.9.0"
    final val effect = "org.typelevel" %% "cats-effect" % "3.4.0"
  }

  object Refined {
    final val refined     = "eu.timepit" %% "refined"      % "0.10.1"
    final val refinedCats = "eu.timepit" %% "refined-cats" % "0.10.1"
  }

  object Enumeratum {
    final val enumeratum = "com.beachape" %% "enumeratum" % "1.7.0"
  }

  final val newtype = "io.estatico" %% "newtype" % "0.4.4"
}
