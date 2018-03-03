package tv.codely.scala_intro_examples.lesson_08_collections.exercise_solutions.daniel_albarral

final class WordAggregator {

  def aggregateWords(text: String): Map[String, Int] = text match {
    case "" => Map()
    case _ =>
      val arrayWords = (text split "\\W+") map (_.toLowerCase)
      val mapWords = arrayWords groupBy (x => x)
      mapWords mapValues(_.length)
  }

}
