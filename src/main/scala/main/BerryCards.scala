package main

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.RouteResult
import akka.stream.ActorMaterializer
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Akka Http server
  */
object BerryCards extends App with CorsSupport {
  implicit val system: ActorSystem = ActorSystem("berrycards")
  implicit val dispatcher: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val config: Config = new Config{}

  implicit val logger: Logger = LoggerFactory.getLogger(classOf[App])

  val berryCardsApi = new BerryCardsApi
  val adminApiBindingFuture: Future[ServerBinding] = Http()
    .bindAndHandle(RouteResult.route2HandlerFlow(corsHandler(berryCardsApi.routes)), config.serverHost, config.serverPort)
    .map(binding => {
      logger.info(s"Server started on ${config.serverHost}:${config.serverPort}")
      binding
    })
}
