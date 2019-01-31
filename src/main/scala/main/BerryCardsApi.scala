package main

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import spray.json._
import ch.megard.akka.http.cors.scaladsl.settings.CorsSettings


/** API for accessing the backend1
  */
class BerryCardsApi extends JsonSupport {

  val settings: CorsSettings = CorsSettings.defaultSettings.withAllowGenericHttpRequests(true)
  var decks = StartingData.startingDecks
  def routes: Route = {
    get {
      pathPrefix("healthCheck") {
        complete(StatusCodes.OK, "OK")
      } ~
      pathPrefix("decks") {
        complete(StatusCodes.OK, decks)
      } ~ pathPrefix("deck") {
          parameter('name) {
            name => complete(StatusCodes.OK, decks.find(_.name == name))
          }
        }
    } ~ post {
      pathPrefix("updateDeck") {
        entity(as[Deck]) { deck =>
          {
            addDeck(deck)
            complete(StatusCodes.OK, "updated")
          }
        }
      }
    }
  }

  def addDeck(deck: Deck) = {
    decks = this.decks.map(x => {
      if (x.name == deck.name) deck else x
    })
  }
}

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val typeFormat: RootJsonFormat[Type] = jsonFormat1(Type)
  implicit val cardFormat: RootJsonFormat[Card] = jsonFormat4(Card)
  implicit val deckFormat: RootJsonFormat[Deck] = jsonFormat2(Deck)
}
