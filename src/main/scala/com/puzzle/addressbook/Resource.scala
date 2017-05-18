package com.puzzle.addressbook

import scala.io.Source

object Resource {
  private val currentDirectory = System.getProperty("user.dir")

  def apply(filename: String): Iterator[String] = {
    Source.fromFile(s"$currentDirectory/src/main/resources/$filename", "UTF-8").getLines()
  }
}
