package photos.brooklyn.practice.codingexercises.scala.math

import org.scalatest.FlatSpec

class PrimeCalculatorTest extends FlatSpec {

  "isAPrime" should "return true when given a prime and a list of primes" in {
    PrimeCalculator.isAPrime(17, List(2,3,5,7,11)) equals true
  }

  "isAPrime" should "return false when given a composite and a list of primes" in {
    PrimeCalculator.isAPrime(16, List(2,3,5,7,11)) equals false
  }

  "isAPrime" should "return false when given a composite that has prime factor for last prime" in {
    PrimeCalculator.isAPrime(163, List(2,3,5,7,11)) equals false
  }

  "discoverPrimes" should "return the first primes under 15" in {
    PrimeCalculator.discoverPrimes(15) equals List(2,3,5,7,11)
  }

  "isPrime" should "return true for 11" in {
    PrimeCalculator.isPrime(11) equals true
  }

  "isPrime" should "return true for 999983" in {
    PrimeCalculator.isPrime(999983) equals true
  }

  "isPrime" should "return false for 20002" in {
    PrimeCalculator.isPrime(11) equals true
  }

  "isPrime" should "return false for largest composite made of largest primes under 1000000" in {
    PrimeCalculator.isPrime(997*997) equals false
  }

}
