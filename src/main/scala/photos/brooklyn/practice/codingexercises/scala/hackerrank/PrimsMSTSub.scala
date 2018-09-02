package photos.brooklyn.practice.codingexercises.scala.hackerrank

import scala.annotation.tailrec
import scala.collection.immutable.ListMap
import scala.collection.mutable

/**
  * https://www.hackerrank.com/challenges/primsmstsub/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
  */
object PrimsMSTSub {

  @tailrec
  def calculate(start: Int, graph: Map[Int, List[NeighborValue]], vertexVals: mutable.Map[Int, Int], sum: Int=0, mst: Set[Int]= Set()): Int =
    if(mst.size==graph.size) sum
    else{
      for (edge <- graph(start)) {
        if (edge.value < vertexVals.getOrElse(edge.neighbor, Int.MaxValue)) {
          vertexVals(edge.neighbor) = edge.value
        }
      }
      vertexVals.filter((t) => mst.contains(t._1))
      val min = ListMap(vertexVals.toSeq.sortBy(_._2):_*).head
      return calculate(min._1, graph, vertexVals, sum + min._2, mst + start)
    }

  def prims(n: Int, edges: Array[Array[Int]], start: Int): Int = {
    val graph = edges.foldLeft(Map[Int, List[NeighborValue]]())((m,row)=>
      m + (
        row(0)-> (NeighborValue(row(1), row(2)) :: m.getOrElse(row(0),List[NeighborValue]())),
        row(1)-> (NeighborValue(row(0), row(2)) :: m.getOrElse(row(1),List[NeighborValue]()))
      )
    )
    calculate(start, graph, mutable.Map(start -> 0))
  }

  case class NeighborValue(neighbor: Int, value: Int)

  object NeighborValueOrdering extends Ordering[NeighborValue] {
    override def compare(x: NeighborValue, y: NeighborValue): Int = y.value compareTo x.value
  }
}
