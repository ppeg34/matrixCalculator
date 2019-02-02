package com.ppeg

object MatrixCalc {
  def distance(distance: Int, seq2D: Seq[Seq[Int]]): Int = {

    //convert all positive values to distance that can be traveled
    val startArray = seq2D.map(_.map(a => if (a > 0) distance else -1))

    //choose max of either the previous item's decrement or this item's value
    val pick = (a: Int, b: Int) => math.max( a-1, b )
    val scanAndFlip = (a: Seq[Int]) => a.scan(0)(pick).drop(1).reverse

    val omniScan = (seq: Seq[Int]) => scanAndFlip(scanAndFlip(seq))

    startArray
      .map(omniScan)
      .transpose
      .map(omniScan)
      //.transpose //you can transpose again for original matrix form
      .map(a => a.count(_ >= 0))
      .sum
  }
}
