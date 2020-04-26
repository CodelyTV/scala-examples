package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.joel_coll

final class WordCounter {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordCounterSpec
  def countWords(text: String): Int = {
    var totalWords = 0
    if (!text.isEmpty) {
      totalWords = text.trim().split(" ").length
    }

    totalWords
  }
}
