package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.joel_coll

final class WordAggregator {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordAggregatorSpec
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.isEmpty) {
      Map.empty
    } else {
      val words = text.trim().split(" ").transform(_.toLowerCase)
      words.groupBy(identity).mapValues(_.length)
    }
  }
}
