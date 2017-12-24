package tv.codely.scala_intro_examples.lesson_08_collections

final class WordAggregator {
  def aggregateWords(text: String): Map[String, Int] = {
    if (text.isEmpty)
      return Map.empty
    var occurrences = Map[String, Int]()
    val words = text.trim.split(" ")
    words.map(s => s.toLowerCase).foreach(s => {
      val numOfWordOccurrences = occurrences.get(s)
      occurrences = occurrences + ((s, numOfWordOccurrences.getOrElse(0) + 1))
    })
    occurrences
  }
}
