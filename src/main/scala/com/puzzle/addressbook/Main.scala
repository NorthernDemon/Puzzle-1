package com.puzzle.addressbook

import com.github.nscala_time.time.OrderingImplicits._
import org.joda.time.Interval

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

  def getDaysDifference(firstName1: String, firstName2: String): Option[Long] = {
    for {
      first <- records.find(_.get.firstName == firstName1).flatten
      second <- records.find(_.get.firstName == firstName2).flatten
    } yield {
      new Interval(first.birthDay, second.birthDay).toDuration.getStandardDays
    }
  }

}
