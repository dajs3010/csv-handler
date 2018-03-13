package com.dajs3010.csv_handler

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by David on 11/03/2018.
  */
class CsvHandlerTest extends FunSpec with BeforeAndAfter{

  before {
    CsvHandler.setFile("src\\test\\scala\\resources\\test.csv")
  }

  describe("getColumnsByHeaderIndex") {
    it("") {
      assert(CsvHandler.getColumnsByHeaderIndex(2) == List("111","222"))
    }
  }

  describe("getColumnsByHeaderName") {
    it("") {
      assert(CsvHandler.getColumnsByHeaderName("first") == List("hola","chao"))
    }
  }

  describe("toMap") {
    it("") {
      assert(
        CsvHandler.csvMap ==
        Map("first" -> List("hola", "chao"),
          "second" -> List("david", "caro"),
          "third" -> List("111", "222"))
      )
    }
  }

  describe("getHeaders") {
    it("") {
      assert(CsvHandler.getHeaders == List("first", "second", "third"))
    }
  }

  describe("getValues") {
    it("") {
      assert(CsvHandler.getValues == List(List("hola","david","111"), List("chao","caro","222")))
    }
  }

  describe("countRows") {
    it("") {
      assert(CsvHandler.countRows == 2)
    }
  }

  describe("countColumns"){
    it(""){
      assert(CsvHandler.countColumns == 3)
    }
  }

  describe(""){
    it(""){

    }
  }

}
