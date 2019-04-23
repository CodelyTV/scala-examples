package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.juanpablo_lopez

class MagazineScannerToJPEG extends DocumentScanner[Magazine,JPEG] {
  def scanner(doc:Magazine):JPEG = new JPEG()
}
