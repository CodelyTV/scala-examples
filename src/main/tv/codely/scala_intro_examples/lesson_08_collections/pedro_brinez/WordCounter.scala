package tv.codely.scala_intro_examples.lesson_08_collections.pedro_brinez

final class WordCounter {
  // @ToDo: Here you have your exercise!
  // @see tv.codely.scala_intro_examples.lesson_08_collections.WordCounterSpec
  def countWords(text: String): Int = {
    if (text.isEmpty)  0 else text.split(" ").length
  }
}
