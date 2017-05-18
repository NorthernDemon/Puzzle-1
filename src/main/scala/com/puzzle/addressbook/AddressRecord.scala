package com.puzzle.addressbook

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

case class AddressRecord(firstName: String,
                         lastName: String,
                         gender: Gender,
                         birthday: DateTime)

object AddressRecord {

  private val dateTimeFormat = DateTimeFormat.forPattern("dd/MM/YY")

  def fromString(record: String): Option[AddressRecord] = {
    record.replaceAll("\\s+", " ").trim.replace(",", "").split(" ").toSeq match {
      case Seq(firstName, lastName, gender, birthday) =>
        Some(
          AddressRecord(
            firstName = firstName,
            lastName = lastName,
            gender = Gender(gender),
            birthday = dateTimeFormat.parseDateTime(birthday)
          )
        )
      case _ => None
    }
  }
}
