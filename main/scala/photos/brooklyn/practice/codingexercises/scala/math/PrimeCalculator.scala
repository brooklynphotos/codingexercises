package photos.brooklyn.practice.codingexercises.scala.math

import scala.annotation.tailrec

object PrimeCalculator {
  def discoverPrimes(maxNumber: Int): List[Int] = nextPrime(3, List(2), maxNumber)

  @tailrec
  private def nextPrime(possiblePrime: Int, primes: List[Int], upperlimit: Int): List[Int] = if(upperlimit<possiblePrime) primes
    else nextPrime(possiblePrime+1, if(isAPrime(possiblePrime, primes)) possiblePrime::primes else primes, upperlimit)

  def isAPrime(possiblePrime: Int, primes: List[Int]): Boolean = primes match {
    case p::others => if(possiblePrime % p == 0) false else isAPrime(possiblePrime, others)
    case _ => true
  }

  def isPrime(possiblePrime: Int): Boolean = if(possiblePrime == 2) true else isPrime(2,Math.sqrt(possiblePrime).toInt, possiblePrime)

  @tailrec
  private def isPrime(test: Int, upperLimit: Int, possiblePrime: Int): Boolean = (possiblePrime % test) match {
    case 0 => false
    case _ => if(test>upperLimit) true else isPrime(test+1, upperLimit, possiblePrime)
  }
}
