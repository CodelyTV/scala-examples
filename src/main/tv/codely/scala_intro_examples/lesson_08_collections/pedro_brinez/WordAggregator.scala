package tv.codely.scala_intro_examples.lesson_08_collections.pedro_brinez

final class WordAggregator {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordAggregatorSpec
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.isEmpty)
      Map.empty
    else
      text.split(" ")
        .groupBy(identity)
        .map(wordOccurrence => (wordOccurrence._1, wordOccurrence._2.length))
  }
}
