package com.dajs3010.csv_handler

/**
  * Created by David on 11/03/2018.
  */
object Util {

  private final val COMA = ","

  /**
    *
    * @param line
    * @return
    */
  def splitLine(line: String) = line.split(COMA).toList

}
