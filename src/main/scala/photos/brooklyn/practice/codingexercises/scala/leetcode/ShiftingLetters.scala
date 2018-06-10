package photos.brooklyn.practice.codingexercises.scala.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-88/problems/shifting-letters/
 */
object ShiftingLetters {

    def shiftChar(c: Char, shiftAmount: Int): Char = (((c.toInt - 'a'.toInt + shiftAmount) % 26) + 'a'.toInt).toChar

    def shiftChars(chars: Array[Char], firstLetters: Int, shiftAmount: Int): Array[Char] = {
        for(i <- 0 to firstLetters){
            chars(i) = shiftChar(chars(i), shiftAmount)
        }
        return chars
    }

    def shiftLetters(chars: Array[Char], shifts: Array[Int], i: Int=0): String =
        if(shifts.length==i) new String(chars)
        else shiftLetters(shiftChars(chars, i, shifts(i)), shifts, i+1)

    def shiftingLetters(S: String, shifts: Array[Int]): String = shiftLetters(S.toCharArray, shifts)
}
