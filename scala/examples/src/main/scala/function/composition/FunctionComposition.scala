package function.composition

object FunctionComposition extends App {
  def f(i: String): String = "f(" + i + ")"

  def g(i: String): String = "g(" + i + ")"

  val composition = f _ compose g
  val andThen = f _ andThen g

  println(composition("test"))
  println(andThen("test"))
}
