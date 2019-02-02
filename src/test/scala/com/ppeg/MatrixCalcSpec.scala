package com.ppeg

import org.scalatest._

//Only included to make your testing life easier, to deserialize json-formatted, two-dimensional array structure to
//a scala-native type
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

class MatrixCalcSpec extends FlatSpec with Matchers {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)

  //change this to the file you'd like to test
  //val testArray = scala.io.Source.fromFile("testfile.txt").mkString
  val testArray =
    """
      |[ [ 0, 0, 0, 0, 0 ],
      |  [ 0, 0, 0, 1, 0 ],
      |  [ 0, 0, 0, 1, 0 ] ]
    """.stripMargin

  val arrayify = (json: String) => mapper.readValue[Vector[Vector[Int]]](json)
  val array2D = arrayify(testArray)

  "The distance calculator" should "calculate matrix distance" in {
    assert(MatrixCalc.distance(1, array2D) == 7)
    assert(MatrixCalc.distance(2, array2D) == 11)
    assert(MatrixCalc.distance(88, array2D) == 15)
  }
}
