package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.daniel_albarral

final class WordCounter {

  def countWords(text: String): Int = text match {
    case "" => 0
    case _ => text split "\\W+" length
  }

}
