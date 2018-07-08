package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

/**
  * based on solution here: https://leetcode.com/problems/prime-palindrome/discuss/146798/Search-Palindrome-with-Even-Digits
  */
object PrimePalindrom {

  /**
    * creates a palindrom number of odd digits; all even digit palindoms are divisible by 11 so only 11 is prime
    * @param palindromIndex
    * @return
    */
  def makeOddDigitPalindrom(palindromIndex: Int): Int = palindromIndex.toString+palindromIndex.toString.reverse.substring(1) toInt

  @tailrec
  def isPrime(x: Int, tester: Int=3): Boolean =
    if(x<2 || x%2==0) x==2
    else if(tester*tester > x) true
    else if(x%tester==0) false
    else isPrime(x, tester+2)

  @tailrec
  def findPrimePalindrome(n: Int, palindromIndex: Int): Int = makeOddDigitPalindrom(palindromIndex) match {
    case x if x>=n && isPrime(x) => x
    case _ => findPrimePalindrome(n, palindromIndex+1)
  }

  def primePalindrome(N: Int): Int = if(8<=N && N<=11) 11 else findPrimePalindrome(N, 1)

}
