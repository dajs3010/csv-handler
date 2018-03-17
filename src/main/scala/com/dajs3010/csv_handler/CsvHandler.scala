package com.dajs3010.csv_handler

import scala.io.BufferedSource

/**
  * Created by David on 12/03/2018.
  */
object CsvHandler {

  var file: BufferedSource = scala.io.Source.stdin
  var lines: List[String] = List.empty[String]
  var csvMap: Map[String, List[String]] = Map.empty[String, List[String]]

  /**
    *
    * @param path
    */
  def setFile(path: String) = {
    file = scala.io.Source.fromFile(path)
    lines = file.getLines().map(_.trim.toLowerCase).toList
    csvMap = {
      val headers = getHeaders
      val values = getRowsAsLists
      val map = headers.map(header => {
        val index = headers.indexOf(header)
        header -> values.map(value => {
          value(index)
        })
      }).toMap
      closeFile
      map
    }

  }

  /**
    *
    * @return
    */
  def getHeaders: List[String] = Util.splitLine(lines.head)

  /**
    *
    * @return
    */
  def getRowsAsLists: List[List[String]] = lines.tail.map(Util.splitLine)

  /**
    *
    * @param header
    */
  def getColumnsByHeaderName(header: String): List[String] = {
    val headerLine = csvMap.keys.toList
    if (headerLine.contains(header)) {
      val index = headerLine.indexOf(header)
      getColumnsByHeaderIndex(index, csvMap)
    } else {
      throw new IllegalArgumentException("No column!!")
    }
  }

  /**
    *
    * @param index
    * @return
    */
  def getColumnsByHeaderIndex(index: Int, csvMapParameter: Map[String, List[String]] = Map()): List[String] = {
    try {
      if (csvMapParameter.nonEmpty) {
        val key = csvMapParameter.keys.toList(index)
        csvMapParameter(key)
      } else {
        val key = csvMap.keys.toList(index)
        csvMap(key)
      }

    } catch {
      case e: java.lang.IndexOutOfBoundsException =>
        throw new IllegalArgumentException("No Index!!")
    }
  }

  /**
    *
    * @param rowNumber
    * @return
    */
  def getRow(rowNumber: Int): List[String] = {
    getRowsAsLists(rowNumber)
  }


  /**
    *
    */
  private def closeFile = file.close

}
