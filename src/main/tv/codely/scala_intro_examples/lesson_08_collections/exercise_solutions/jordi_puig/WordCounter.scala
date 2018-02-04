package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.jordi_puig

class WordCounter {
  def countWords(text: String): Int =
    if (text.length > 0) text.split("\\s+").length else 0
}
