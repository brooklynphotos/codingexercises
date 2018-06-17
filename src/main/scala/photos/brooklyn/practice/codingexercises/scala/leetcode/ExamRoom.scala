package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

/**
  * https://leetcode.com/contest/weekly-contest-89/problems/exam-room/
  * @param _N
  */
class ExamRoom(val _N: Int) {
  private val occupied = scala.collection.mutable.SortedSet[Int]()

  def seat(): Int = {
    val foundSeat = findSeat()
    occupied += foundSeat
    return foundSeat
  }

  def leave(p: Int) {
    occupied.remove(p)
  }

  @tailrec
  final def findBiggestMiddleDistance(seatList: List[Int], currentMax: (Int, Int)=(0,0)): (Int, Int) = (currentMax, seatList) match {
    case (_,Nil) | (_, _::Nil) => currentMax // no pairs in the middle
    case ((currentMaxStart, currentMaxEnd), a::b::tail) =>
      if((currentMaxEnd-currentMaxStart)/2 < (b-a)/2) findBiggestMiddleDistance(b::tail, (a, b))
      else findBiggestMiddleDistance(b::tail, (currentMaxStart, currentMaxEnd))
  }

  private def findSeat(): Int = {
    val head = if(occupied.size>0) occupied.head else _N-1
    var res = (0, head)
    val (middleStart, middleEnd) = findBiggestMiddleDistance(occupied.toList)
    val middleMax = (middleEnd - middleStart) / 2
    if(middleMax>res._2) res = ((middleEnd+middleStart)/2, middleMax)
    val tail = if(occupied.size>0) (_N-1-occupied.last) else _N-1
    if(tail>res._2) res = (_N-1, tail)

    res._1
  }


}