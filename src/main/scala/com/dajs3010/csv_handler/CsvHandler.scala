package com.dajs3010.csv_handler

import scala.io.BufferedSource

/**
  * Created by David on 12/03/2018.
  */
object CsvHandler {

  private final val COMA = ","

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
      println("calculating map")
      val headers = getHeaders
      val values = getValues
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
  def getHeaders = splitLine(lines.head)

  /**
    *
    * @return
    */
  def getValues = lines.tail.map(splitLine)

  /**
    *
    * @return
    */
  def countRows = csvMap.toList.tail.size

  /**
    *
    * @return
    */
  def countColumns = csvMap.size

  /**
    *
    * @param header
    */
  def getColumnsByHeaderName(header: String) = {
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
  def getColumnsByHeaderIndex(index: Int, csvMapParameter: Map[String, List[String]] = Map()) = {
    try {
      if(csvMapParameter.nonEmpty) {
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

  private def closeFile = file.close


  /**
    *
    * @param line
    * @return
    */
  private def splitLine(line: String) = line.split(COMA).toList


}