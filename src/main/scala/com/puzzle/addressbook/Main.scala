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

  def getDaysDifference(olderName: String, youngerName: String): Option[Long] = {
    for {
      older <- records.find(_.firstName == olderName)
      younger <- records.find(_.firstName == youngerName)
    } yield {
      new Interval(older.birthday, younger.birthday).toDuration.getStandardDays
    }
  }

}
