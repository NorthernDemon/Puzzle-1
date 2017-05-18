package com.puzzle.addressbook

import com.github.nscala_time.time.OrderingImplicits._

object Main {

  val records = Resource("AddressBook").map(AddressRecord.fromString)

  def main(args: Array[String]): Unit = {
    println("Run: sbt test")
  }

  def findByGender(gender: Gender): Int = {
    records.count(_.exists(_.gender == gender))
  }

  def findByAge(age: Age): Option[AddressRecord] = {
    age match {
      case Oldest => records.minBy(_.map(_.birthDay))
      case Youngest => records.maxBy(_.map(_.birthDay))
    }
  }

}
