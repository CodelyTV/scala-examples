package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.javier_rafael

final class WordCounter {
  def countWords(text: String): Int =
    if (text.isEmpty)
      0
    else
      text.split(" ").length
}
