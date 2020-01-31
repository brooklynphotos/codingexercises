package photos.brooklyn.practice.codingexercises.scala.leetcode.utils

import scala.io.Source

object LemonadeChangeUtils {
  def readLongQueue(propName: String): Array[Int] = Source.fromResource("lemonade_change.properties").getLines
    .filter(s=>s.startsWith(propName+"="))
    .map(s=>s.substring(propName.length+1).split(",").map(s=>s.toInt)).toList.head
}
