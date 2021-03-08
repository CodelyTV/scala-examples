package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.ivanc

final class WordAggregator {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordAggregatorSpec
  def aggregateWords(text: String): Map[String, Int] = {
    if(text.size > 0)
      text.toLowerCase.split(" ").groupBy(identity).mapValues(_.size)
    else
      Map().empty
  }
}
