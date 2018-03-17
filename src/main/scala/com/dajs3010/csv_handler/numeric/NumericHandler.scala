package com.dajs3010.csv_handler.numeric

import com.dajs3010.csv_handler.CsvHandler.{getColumnsByHeaderName, getRow, lines}
import com.dajs3010.csv_handler.Util

/**
  * Created by David on 17/03/2018.
  */
object NumericHandler {

  /**
    *
    * @return
    */
  def countRows: Int = lines.tail.size

  /**
    *
    * @return
    */
  def countColumns: Int = Util.splitLine(lines.head).size

  /**
    *
    * @return
    */
  def countEmpties(): Int = {
    lines.tail.flatMap(Util.splitLine).count(_.isEmpty)
  }

  /**
    *
    * @return
    */
  def countNonEmpties(): Int = {
    lines.tail.flatMap(Util.splitLine).count(_.nonEmpty)
  }

  /**
    *
    * @return
    */
  def countAll(): Int = {
    lines.tail.flatMap(Util.splitLine).size
  }

  /**
    *
    * @param row
    * @return
    */
  def countAllByRow(row: Int): Int = {
    getRow(row).size
  }

  /**
    *
    * @param row
    * @return
    */
  def countEmptiesByRow(row: Int): Int = {
    getRow(row).count(_.isEmpty)
  }

  /**
    *
    * @param row
    * @return
    */
  def countNonEmptiesByRow(row: Int): Int = {
    getRow(row).count(_.nonEmpty)
  }

  /**
    *
    * @param column
    * @return
    */
  def countAllByColumn(column: String): Int = {
    getColumnsByHeaderName(column).size
  }

  /**
    *
    * @param column
    * @return
    */
  def countEmptiesByColumn(column: String): Int = {
    getColumnsByHeaderName(column).count(_.isEmpty)
  }

  /**
    *
    * @param column
    * @return
    */
  def countNonEmptiesByColumn(column: String): Int = {
    getColumnsByHeaderName(column).count(_.nonEmpty)
  }

  /**
    *
    * @param column
    * @return
    */
  def sumByColumn(column: String): Double = {
    getColumnsByHeaderName(column).filter(_ forall Character.isDigit).map(_.toDouble).sum
  }

  /**
    *
    * @param column
    * @return
    */
  def avgByColumn(column: String): Double = {
    val values = getColumnsByHeaderName(column).filter(_ forall Character.isDigit).map(_.toDouble)
    if (values.isEmpty) 0.0
    else values.sum / values.size
  }


}
