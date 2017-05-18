package com.puzzle.addressbook

sealed trait Age
case object Oldest extends Age
case object Youngest extends Age
