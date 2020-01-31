package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.FlatSpec

class GoatLatinTest extends FlatSpec {

  "testToGoatLatin" should "return the right thing in test 1" in {
    assert(GoatLatin.toGoatLatin("I speak Goat Latin") == "Imaa peaksmaaa oatGmaaaa atinLmaaaaa")
  }

  "testToGoatLatin" should "return the right thing in test 2" in {
    assert(GoatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog") == "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
  }

  "testToGoatLatin" should "return the right thing when only one word" in {
    assert(GoatLatin.toGoatLatin("dog") == "ogdmaa")
  }

  "testToGoatLatin" should "return the right thing when capital letters" in {
    assert(GoatLatin.toGoatLatin("Each Done") == "Eachmaa oneDmaaa")
  }

  "testToGoatLatin" should "return the blank when no word" in {
    assert(GoatLatin.toGoatLatin("") == "")
  }

}
