package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.javier_rafael

final class WordAggregator {
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.isEmpty) {
      Map.empty
    } else {
      val words = text.toLowerCase.split(" ")
      words.groupBy(identity).mapValues(values => values.length)
    }
  }
}

