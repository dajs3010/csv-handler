package com.dajs3010.csv_handler.search

import com.dajs3010.csv_handler.CsvHandler

/**
  * Created by David on 17/03/2018.
  */
object SearchHandler {

  /**
    *
    * @param text
    * @return
    */
  def searchTextInCsv(text: String): Seq[SearchResult] = {
    val rows = CsvHandler.getRowsAsLists
    val results = rows.filter(_.indexOf(text) >= 0).map(row => {
      val rowNumber = rows.indexOf(row)
      val header = CsvHandler.getHeaders(row.indexOf(text))
      SearchResult(header, rowNumber)
    })
    results
  }

}

case class SearchResult(column: String, row: Int)