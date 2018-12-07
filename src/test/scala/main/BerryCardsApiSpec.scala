package main

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpecLike}

class BerryCardsApiSpec extends WordSpecLike with Matchers with ScalatestRouteTest {
  val api = new BerryCardsApi
  val routes: Route = api.routes

  "healthCheck Endpoint" should {
    "return ok" in {
      Get("/healthCheck") ~> routes ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "OK"
      }
    }
  }
}