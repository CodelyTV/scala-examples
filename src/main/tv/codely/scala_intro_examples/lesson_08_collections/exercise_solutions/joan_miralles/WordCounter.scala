package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.joan_miralles

final class WordCounter {
  def countWords(text: String): Int = {
    if (text.isEmpty)
      0
    else {
      val words = text.trim.split(" ")
      words.length
    }
  }
}
