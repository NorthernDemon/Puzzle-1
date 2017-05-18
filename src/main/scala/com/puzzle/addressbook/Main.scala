package com.puzzle.addressbook

object Main {

  val records = Resource("AddressBook").map(AddressRecord.fromString)

  def main(args: Array[String]): Unit = {
    println("Run: sbt test")
  }

  def findByGender(gender: Gender): Int = {
    records.count(_.exists(_.gender == gender))
  }

}
