package com.puzzle.addressbook

sealed trait Gender
case object Male extends Gender
case object Female extends Gender

object Gender {

  def apply(gender: String): Gender = gender match {
    case "Male" => Male
    case "Female" => Female
    case unknown => throw new IllegalArgumentException(
      s"Could not parse the gender field from $unknown. Use [ Male | Female ]")
  }
}
