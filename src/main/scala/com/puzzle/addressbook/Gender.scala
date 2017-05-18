package com.puzzle.addressbook

sealed trait Gender
case object Male extends Gender
case object Female extends Gender

object Gender {

  def apply(s: String): Gender = s match {
    case "Male" => Male
    case "Female" => Female
    case _ => throw new IllegalArgumentException(
      "Could not parse the gender field. Use [ Male | Female ]")
  }
}
