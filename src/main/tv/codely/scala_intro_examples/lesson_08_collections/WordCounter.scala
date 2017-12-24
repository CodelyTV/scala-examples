package tv.codely.scala_intro_examples.lesson_08_collections

final class WordCounter {
  def countWords(text: String): Int = {
    if (text.isEmpty)
      return 0
    val words = text.trim.split(" ")
    words.length
  }
}
