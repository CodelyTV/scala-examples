package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.juanpablo_lopez

final class WordAggregator {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordAggregatorSpec
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.length < 1) {
      return Map.empty
    }
    text.toLowerCase.split(" ").map( x=> (x,1)).groupBy(_._1).mapValues(_.map(_._2).sum)
  }
}
