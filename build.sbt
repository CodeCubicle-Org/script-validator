val scala3Version = "3.6.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "test",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "io.circe" %% "circe-parser" % "0.15.0-M1",
    libraryDependencies += "pt.kcry" %% "sha" % "2.0.2",
    libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.11.4",
    libraryDependencies += "org.rogach" %% "scallop" % "5.2.0",

    libraryDependencies += "org.scalameta" %% "munit" % "1.1.0" % Test
  )
