package com.dajs3010.csv_handler.numeric

import com.dajs3010.csv_handler.CsvHandler
import org.scalatest.FunSpec

/**
  * Created by David on 17/03/2018.
  */
class NumericHandlerTest extends FunSpec {

  CsvHandler.setFile("src\\test\\scala\\resources\\test.csv")

  describe("test numeric") {
    it("countRows") {
      assert(NumericHandler.countRows == 2)
    }

    it("countColumns") {
      assert(NumericHandler.countColumns == 3)
    }

    it("countEmpties by column") {
      assert(NumericHandler.countEmptiesByColumn("first") == 0)
    }

    it("countEmpties") {
      assert(NumericHandler.countEmpties() == 0)
    }

    it("countNonEmpties by column") {
      assert(NumericHandler.countNonEmptiesByColumn("first") == 2)
    }

    it("countNonEmpties") {
      assert(NumericHandler.countNonEmpties() == 6)
    }

    it("countAll by column") {
      assert(NumericHandler.countAllByColumn("first") == 2)
    }

    it("countAll") {
      assert(NumericHandler.countAll() == 6)
    }

    it("sumByColumn") {
      assert(NumericHandler.sumByColumn("third") == 333.0)
    }

    it("sumByColumn no numeric") {
      assert(NumericHandler.sumByColumn("first") == 0)
    }

    it("avgByColumn") {
      assert(NumericHandler.avgByColumn("third") == 166.5)
    }

    it("avgByColumn no numeric") {
      assert(NumericHandler.avgByColumn("first") == 0)
    }

    it("countAllByRow") {
      assert(NumericHandler.countAllByRow(0) == 3)
    }

    it("countEmptiesByRow") {
      assert(NumericHandler.countEmptiesByRow(0) == 0)
    }

    it("countNonEmptiesByRow") {
      assert(NumericHandler.countNonEmptiesByRow(0) == 3)
    }
  }

}
