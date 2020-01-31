package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.collection.mutable

/**
  * https://leetcode.com/contest/weekly-contest-104/problems/x-of-a-kind-in-a-deck-of-cards/
  */
object XOfAKindDeckOfCards {

  def hasCommonFactor(min: Int, values: Iterable[Int], testedNum: Int = 2): Boolean =
    if(min<2 || testedNum>min) false
    else values.forall(x=>x%testedNum==0) || hasCommonFactor(min, values, testedNum + 1)

  def hasGroupsSizeX(deck: Array[Int]): Boolean = {
    if(deck.length==1) return false
    val c = deck.foldLeft(mutable.Map[Int, Int]())((m, x)=> {
      m.put(x, m.getOrElse(x, 0) + 1)
      m
    })
    return hasCommonFactor(c.values.min, c.values)
  }
}
