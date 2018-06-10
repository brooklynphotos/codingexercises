package photos.brooklyn.practice.codingexercises.scala.leetcode

object MaxDistanceToClosestPerson {


  def getClosestDistance(emptyPosition: Int, occupieds: Seq[Int]): Int = occupieds.foldLeft(Int.MaxValue)((currentMin, occupiedPosition)=>Math.min(currentMin, Math.abs(occupiedPosition-emptyPosition)))

  private def maxDist(empties: Seq[Int], occupieds: Seq[Int], i: Int=0, currentMax: Int=0): Int = empties.foldLeft(0)((currentMax, emptyPosition)=>Math.max(currentMax, getClosestDistance(emptyPosition, occupieds)))

  def maxDistToClosest(seats: Array[Int]): Int = maxDist(for(i <- 0 until seats.length if seats(i)==0) yield i, for(i <- 0 until seats.length if seats(i)==1) yield i)
}
