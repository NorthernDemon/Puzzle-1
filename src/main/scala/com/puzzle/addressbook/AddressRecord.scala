package com.puzzle.addressbook

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

case class AddressBook(records: Seq[AddressRecord])

case class AddressRecord(firstName: String,
                         lastName: String,
                         gender: Gender,
                         birthDay: DateTime)

object AddressRecord {

  private val dateTimeFormat = DateTimeFormat.forPattern("dd/MM/YY")

  def fromString(record: String): Option[AddressRecord] = {
    try {
      val items = record.replace(",", "").split(" ").map(_.trim).toSeq
      Some(
        AddressRecord(
          firstName = items(0),
          lastName = items(1),
          gender = Gender(items(2)),
          birthDay = dateTimeFormat.parseDateTime(items(3))
        )
      )
    } catch {
      case error: Throwable =>
        error.printStackTrace()
        None
    }
  }
}
