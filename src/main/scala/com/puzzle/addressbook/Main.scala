package com.puzzle.addressbook

import com.github.nscala_time.time.OrderingImplicits._
import org.joda.time.Interval

object Main {

  val records = Resource("AddressBook").flatMap(AddressRecord.fromString)

  def main(args: Array[String]): Unit = {
    println("Run: sbt test")
  }

  def findByGender(gender: Gender): Int = {
    records.count(_.gender == gender)
  }

  def findByAge(age: Age): AddressRecord = {
    age match {
      case Oldest => records.minBy(_.birthday)
      case Youngest => records.maxBy(_.birthday)
    }
  }

  def getDaysDifference(firstName1: String, firstName2: String): Option[Long] = {
    for {
      first <- records.find(_.firstName == firstName1)
      second <- records.find(_.firstName == firstName2)
    } yield {
      new Interval(first.birthday, second.birthday).toDuration.getStandardDays
    }
  }

}
