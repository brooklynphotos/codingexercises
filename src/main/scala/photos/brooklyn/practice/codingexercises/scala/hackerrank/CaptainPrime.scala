package photos.brooklyn.practice.codingexercises.scala.hackerrank

import photos.brooklyn.practice.codingexercises.scala.math.PrimeCalculator

/**
  * https://www.hackerrank.com/challenges/captain-prime/problem
  */
object CaptainPrime {

  def main(args: Array[String]) = {
    val count = args(0).toInt
    for(i <- 1 to count) println(determineCategory(args(i)))
  }

  def determineCategory(pStr: String): String = {
    val l = allPrimesLeft(pStr)
    val r = allPrimesRight(pStr)
    (l,r) match {
      case (true, true) => "CENTRAL"
      case (true, false) => "LEFT"
      case (false, true) => "RIGHT"
      case _ => "DEAD"
    }
  }

  def allPrimesLeft(pStr: String): Boolean = if(pStr != "" && !PrimeCalculator.isPrime(pStr.toInt)) false else pStr match {
    case a <** rest => if(a=='0') false else allPrimesLeft(rest)
    case _ => true
  }

  def allPrimesRight(pStr: String): Boolean = if(pStr != "" && !PrimeCalculator.isPrime(pStr.toInt)) false else pStr match {
    case rest **> a => if(a=='0') false else allPrimesRight(rest)
    case _ => true
  }
}

object <** {
  def unapply(str: String): Option[(Char, String)] = str match {
    case "" | null => Option.empty
    case _ => Option((str.charAt(0), str.substring(1)))
  }
}


object **> {
  def unapply(str: String): Option[(String, Char)] = str match {
    case "" | null => Option.empty
    case _ => Option((str.substring(0, str.length-1), str.charAt(str.length-1)))
  }
}