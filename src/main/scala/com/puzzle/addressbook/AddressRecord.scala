package com.puzzle.addressbook

import org.joda.time.DateTime

case class AddressBook(records: Seq[AddressRecord])

case class AddressRecord(firstName: String,
                         secondName: String,
                         gender: Gender,
                         birthDay: DateTime)
