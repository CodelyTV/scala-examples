package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.ivanc

final class WordCounter {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordCounterSpec
  def countWords(text: String): Int = {
    if (text.size > 0)
      text.split(" ").size
    else 0
  }
}
