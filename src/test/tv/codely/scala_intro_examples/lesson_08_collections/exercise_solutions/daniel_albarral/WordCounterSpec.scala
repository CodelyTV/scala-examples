package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.daniel_albarral

import org.scalatest.{Matchers, WordSpec}

final class WordCounterSpec extends WordSpec with Matchers {
  "Word Counter" should {
    "return 0 given an empty text" in {
      val counter = new WordCounter
      val emptyText = ""

      counter.countWords(emptyText) shouldBe 0
    }

    "return the number of words given a non empty text" in {
      val counter = new WordCounter
      val nonEmptyText = "Hi all"
      val wordsNumber = 2

      counter.countWords(nonEmptyText) shouldBe wordsNumber
    }
  }
}
