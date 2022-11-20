import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"))
  .settings(
    name := "poker",
    idePackagePrefix := Some("org.example.application"),
    libraryDependencies ++= Seq(
      Cats.core,
      Cats.effect,
      newtype,
      Refined.refined,
      Refined.refinedCats,
      Enumeratum.enumeratum
    ),
    scalacOptions ++= Seq(
      "-Ymacro-annotations"
    )
  )


