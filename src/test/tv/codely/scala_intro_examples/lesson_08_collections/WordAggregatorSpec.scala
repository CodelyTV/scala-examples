package tv.codely.scala_intro_examples.lesson_08_collections

import org.scalatest.{Matchers, WordSpec}

final class WordAggregatorSpec extends WordSpec with Matchers {
  "Word Aggregator" should {
    "return an empty map given an empty text" in {
      val aggregator = new WordAggregator
      val emptyText = ""

      aggregator.aggregateWords(emptyText) shouldBe Map.empty
    }
    // @ToDo: Here you have your exercise!
    // Change this "ignore" keyword for the "in" one and make this test pass!
    "return the number of words occurrences for each word given a non empty text" in {
      val aggregator = new WordAggregator
      val nonEmptyText = "Hi hi hi all"
      val wordsOccurrences = Map(
        "hi" -> 3,
        "all" -> 1
      )

      aggregator.aggregateWords(nonEmptyText) shouldBe wordsOccurrences

    }
  }
}
