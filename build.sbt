name := "berrycards-api"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= {
  val akkaHttpVersion = "10.1.3"
  val scalaTestVersion = "3.0.4"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
    "com.typesafe.akka" %% "akka-testkit" % "2.5.12" % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
  )
}
