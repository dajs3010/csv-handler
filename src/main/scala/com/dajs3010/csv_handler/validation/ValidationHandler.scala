package com.dajs3010.csv_handler.validation

import com.dajs3010.csv_handler.CsvHandler.{getColumnsByHeaderName, getRow}

/**
  * Created by David on 17/03/2018.
  */
object ValidationHandler {

  /**
    *
    * @param column
    */
  def isEmptyColumn(column: String): Boolean = {
    getColumnsByHeaderName(column).isEmpty
  }

  /**
    *
    * @param column
    */
  def isNonEmptyColumn(column: String): Boolean = {
    getColumnsByHeaderName(column).nonEmpty
  }

  /**
    *
    * @param row
    */
  def isEmptyRow(row: Int): Boolean = {
    getRow(row).isEmpty
  }

  /**
    *
    * @param row
    */
  def isNonEmptyRow(row: Int): Boolean = {
    getRow(row).nonEmpty
  }

}
