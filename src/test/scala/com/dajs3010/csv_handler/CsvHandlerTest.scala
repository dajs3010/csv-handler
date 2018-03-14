package com.dajs3010.csv_handler

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by David on 11/03/2018.
  */
class CsvHandlerTest extends FunSpec with BeforeAndAfter {

  describe("test") {

    CsvHandler.setFile("src\\test\\scala\\resources\\test.csv")

    it("getColumnsByHeaderIndex") {
      assert(CsvHandler.getColumnsByHeaderIndex(2) == List("111", "222"))
    }

    it("getColumnsByHeaderName") {
      assert(CsvHandler.getColumnsByHeaderName("first") == List("hola", "chao"))
    }

    it("csvMap") {
      assert(
        CsvHandler.csvMap ==
          Map("first" -> List("hola", "chao"),
            "second" -> List("david", "caro"),
            "third" -> List("111", "222"))
      )
    }

    it("getHeaders") {
      assert(CsvHandler.getHeaders == List("first", "second", "third"))
    }

    it("getValues") {
      assert(CsvHandler.getValues == List(List("hola", "david", "111"), List("chao", "caro", "222")))
    }

    it("countRows") {
      assert(CsvHandler.countRows == 2)
    }

    it("countColumns") {
      assert(CsvHandler.countColumns == 3)
    }

    it("countEmpties by column") {
      assert(CsvHandler.countEmpties(Some("first")) == 0)
    }

    it("countEmpties") {
      assert(CsvHandler.countEmpties() == 0)
    }

    it("countNonEmpties by column") {
      assert(CsvHandler.countNonEmpties(Some("first")) == 2)
    }

    it("countNonEmpties") {
      assert(CsvHandler.countNonEmpties() == 6)
    }

    it("countAll by column") {
      assert(CsvHandler.countAll(Some("first")) == 2)
    }

    it("countAll") {
      assert(CsvHandler.countAll() == 6)
    }

    it("") {

    }

  }


}
