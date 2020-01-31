package photos.brooklyn.practice.codingexercises.scala.hackerrank

object ValidBST {

  def isValid(intCount: Int, intStr: String): Boolean = isValid(intStr.split("\\s+").map(_.toInt).toList)
  def isValid(ints: List[Int], upperRoots: List[Int] = List()): Boolean = ints match {
    case Nil => true
    case x::rest => upperRoots !=Nil && upperRoots.head>0
  }

  def main(args: Array[String]): Unit = {
    val caseCount = readInt()
    for(c <- 0 until caseCount){
      println(isValid(readInt, readLine))
    }
  }
}
