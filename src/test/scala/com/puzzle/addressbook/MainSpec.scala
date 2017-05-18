package com.puzzle.addressbook

import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

  "findByGender(Male)" should "list count only male records" in {
    Main.findByGender(Male) shouldBe 3
  }

  "findByGender(Female)" should "list count only female records" in {
    Main.findByGender(Female) shouldBe 2
  }
}
