package design.patterns.monads

object MonadsExample extends App {
  def division(a: Double)(b: Double): Option[Double] = {
    if(b == 0.0)
      None
    else Some(b)
  }

  val divisionOf10 = division(10)(_)

  println(Some(10.0).flatMap(divisionOf10))
  println(Some(10.0).map(divisionOf10))
}
