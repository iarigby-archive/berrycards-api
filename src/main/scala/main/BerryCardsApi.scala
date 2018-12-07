package main

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

class BerryCardsApi {
  def routes: Route = {
    get {
      pathPrefix("healthCheck") {
        complete(StatusCodes.OK, "OK")
      }
    }
  }
}
