package com.dajs3010.csv_handler.search

import com.dajs3010.csv_handler.CsvHandler
import org.scalatest.FunSpec

/**
  * Created by David on 17/03/2018.
  */
class SearchHandlerTest extends FunSpec {

  CsvHandler.setFile("src\\test\\scala\\resources\\test.csv")

  describe("search test") {
    it("searchTextInCsv") {
      assert(SearchHandler.searchTextInCsv("222") == List(SearchResult("third", 1)))
      assert(SearchHandler.searchTextInCsv("hola") == List(SearchResult("first", 0)))
      assert(SearchHandler.searchTextInCsv("not in csv") == List())
    }
  }

}
