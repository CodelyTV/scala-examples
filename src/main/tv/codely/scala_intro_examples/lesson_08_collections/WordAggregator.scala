package tv.codely.scala_intro_examples.lesson_08_collections

final class WordAggregator {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordAggregatorSpec
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.length == 0) Map.empty[String,Int]
    else
      text.split("\\W+").foldLeft(Map.empty[String, Int]) {
        (res, word) => res + (word.toLowerCase -> (res.getOrElse(word.toLowerCase, 0) +1 ))
      }
  }
}
