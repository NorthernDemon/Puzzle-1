# Address Book Puzzle

The puzzle answers 3 questions given an address book of people records in the defined format:

````{First Name} {Last Name}, {Male | Female}, {Birthday: dd/MM/YY}````

These questions are:

* Count the number of personal records by gender
* Find the oldest / youngest personal record
* Calculate the number of days two persons have between each other's birthsdays

Each question is expressed in the from of a unit test.

Run: ```sbt test``` to find out if they are correct.

## Datasets

Datasets are located under the resources folder:

* **AddressBook** standard dataset with all records being correct
* **UnorganizedAddressBook** standard dataset where records are correct, but in unorganized format (extra spaces, multiple commas, etc.)
* **MalformedGenderAddressBook** dataset contains one record with incorrect gender
* **MalformedBirthdayAddressBook** dataset contains one record with incorrect birthday format
* **MalformedNameAddressBook** dataset contains one record without space in between of the first and last names

The records are normalized while parsing.

The records are skipped if they contain malformed data.

## Requirements

* Scala 2.12.2
* sbt 0.13.15
* [nscala-time](https://github.com/nscala-time/nscala-time)
* [scalatest](http://www.scalatest.org)
