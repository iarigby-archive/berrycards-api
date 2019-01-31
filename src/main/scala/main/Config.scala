package main

import com.typesafe.config.ConfigFactory

/** Responsible for lazy loading values from application.conf
  *
  */trait Config {

  private lazy val config = ConfigFactory.load()

  lazy val serverHost = config.getString("server.host")
  lazy val serverPort = config.getInt("server.port")
}
