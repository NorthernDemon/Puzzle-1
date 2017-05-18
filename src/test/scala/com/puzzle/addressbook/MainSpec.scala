package com.puzzle.addressbook

import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

    "Main method" should "reply with pong" in {
        Main.ping shouldBe "pong"
    }
}
