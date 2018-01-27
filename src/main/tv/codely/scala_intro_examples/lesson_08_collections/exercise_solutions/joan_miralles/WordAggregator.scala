package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.joan_miralles

final class WordAggregator {
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.isEmpty)
      Map.empty
    else
      text.trim.split(" ").transform(_.toLowerCase)
        .groupBy(identity)
        .mapValues(_.length)
  }
}
