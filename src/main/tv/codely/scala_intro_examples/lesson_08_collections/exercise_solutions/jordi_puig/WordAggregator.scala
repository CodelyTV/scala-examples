package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.jordi_puig

class WordAggregator {
  def aggregateWords(text: String): Map[String, Int] =
    if (text.length == 0) Map.empty
    else
      text.split("\\W+").foldLeft(Map.empty[String, Int]) {
        (aggregatedWords, word) =>
          aggregatedWords + (word.toLowerCase ->
            (aggregatedWords.getOrElse(word.toLowerCase, 0) + 1))
      }
}
