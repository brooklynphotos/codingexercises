package photos.brooklyn.practice.codingexercises.scala.hackerrank

/**
  * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
  */
object MakingAnagrams {

  def countChars(a: String) = a.foldLeft(Map[Char, Int]())((m, c)=>m + (c->(m.getOrElse(c, 0)+1)))

  def countRemoval(a: String, b: String): Int = {
    val charMapA = countChars(a)
    val charMapB = countChars(b)
    val allChars = charMapA.keySet ++ charMapB.keySet
    // go through each key on A and see if there's a difference on the other side
    countFromMap(allChars, charMapA, charMapB).values.sum
  }

  def countFromMap(pool: Set[Char], charMapA: Map[Char, Int], charMapB: Map[Char, Int]): Map[Char, Int] =
    pool.foldLeft(Map[Char, Int]())((m, c)=>{
      val aCount = charMapA.getOrElse(c, 0)
      val bCount = charMapB.getOrElse(c, 0)
      m + (c -> Math.abs(aCount-bCount))
    })

  def main(args: Array[String]) {
    val a = args(0)
    val b = args(1)
    println(countRemoval(a,b))
  }
}
