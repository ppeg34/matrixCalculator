import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.ppegelow"

lazy val root = (project in file("."))
  .settings(
    name := "Matrix Calculator",

    //Only included to make your testing life easier, to deserialize json-formatted, two-dimensional array structure to
    //a scala-native type
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8",
    libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8",

    libraryDependencies += scalaTest % Test
  )
