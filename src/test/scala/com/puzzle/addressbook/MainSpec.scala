package com.puzzle.addressbook

import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

  "findByGender(Male)" should "count only male records" in {
    Main.findByGender(Male) shouldBe 3
  }

  "findByGender(Female)" should "count only female records" in {
    Main.findByGender(Female) shouldBe 2
  }

  "findByBirthDay(Oldest)" should "print the oldest person on the list" in {
    val oldest = AddressRecord.fromString("Wes Jackson, Male, 14/08/74")
    Main.findByAge(Oldest) shouldBe oldest
  }

  "findByBirthDay(Youngest)" should "print the youngest person on the list" in {
    val youngest = AddressRecord.fromString("Gemma Lane, Female, 20/11/91")
    Main.findByAge(Youngest) shouldBe youngest
  }
}
