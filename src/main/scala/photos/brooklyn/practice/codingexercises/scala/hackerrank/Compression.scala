package photos.brooklyn.practice.codingexercises.scala.hackerrank

import scala.annotation.tailrec
import scala.io.Source

object Compression {
  def buildString(i: Int, c: Char): String = {
    val sb = StringBuilder.newBuilder
    (1 to Math.pow(10, i).toInt).foreach(_ => sb.append(c))
    return sb.toString()
  }

  def runPrefixCompression(A: String, B: String): Unit ={
    //val (prefix, aTail, bTail) = compressFold(A, B)

    val (prefix, aTail, bTail) = compress(A, B, 0)

    println(s"${prefix.length} ${prefix}")
    println(s"${aTail.length} ${aTail}")
    println(s"${bTail.length} ${bTail}")
  }

  @tailrec
  def compress(a: String, b: String, index: Int): (String, String, String) = index==Math.min(a.length, b.length) || a.charAt(index) !=b.charAt(index) match {
    case false => compress(a, b, index+1)
    case true => (a.substring(0, index), if(a.length>index) a.substring(index) else "", if(b.length>index) b.substring(index) else "")
  }

  def compressFold(a: String, b: String) = a.zipAll(b, "", "").foldLeft(("", "", ""))((res, zipped) => {
    val (aChar, bChar) = zipped
    val (prefix, aTail, bTail) = res
    if(aTail.length==0 && bTail.length==0 && aChar==bChar)
      (prefix+aChar, aTail, bTail)
    else (prefix, aTail + aChar, bTail + bChar)
  })

  def main(args: Array[String]): Unit = {

    val filename = "/Users/gzhong/lines.txt"
    val lines = Source.fromFile(filename).getLines().toArray
    runPrefixCompression(lines(0), lines(1))
    //  HackerRank.runPrefixCompression("abcd", "abcd")
  }

}
