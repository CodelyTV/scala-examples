package tv.codely.scala_intro_examples.lesson_08_collections

final class WordCounter {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordCounterSpec
  def countWords(text: String): Int = {
    if (text.length > 0) text.split("\\s+").length else 0
  }
}
