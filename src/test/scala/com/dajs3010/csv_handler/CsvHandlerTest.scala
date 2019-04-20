package com.dajs3010.csv_handler

import com.dajs3010.csv_handler.validation.ValidationHandler
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

    it("getRow") {
      assert(CsvHandler.getRow(1) == List("chao", "caro", "222"))
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

    it("getRowsAsLists") {
      assert(CsvHandler.getRowsAsLists == List(List("hola", "david", "111"), List("chao", "caro", "222")))
    }




    it("") {

    }

  }


}