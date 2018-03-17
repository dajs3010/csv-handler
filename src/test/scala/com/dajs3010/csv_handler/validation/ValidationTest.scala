package com.dajs3010.csv_handler.validation

import com.dajs3010.csv_handler.CsvHandler
import org.scalatest.FunSpec

/**
  * Created by David on 17/03/2018.
  */
class ValidationTest extends FunSpec {

  CsvHandler.setFile("src\\test\\scala\\resources\\test.csv")

  describe("test validation") {

    it("isEmptyColumn") {
      assert(!ValidationHandler.isEmptyColumn("first"))
    }

    it("isNonEmptyColumn") {
      assert(ValidationHandler.isNonEmptyColumn("first"))
    }

    it("isEmptyRow") {
      assert(!ValidationHandler.isEmptyRow(1))
    }

    it("isNonEmptyRow") {
      assert(ValidationHandler.isNonEmptyRow(1))
    }

  }

}
