package referential.transparency

object ReferentialTransparency extends App {
  def division(a: Double, b: Double): Option[Double] = {
    if(b == 0.0)
      None
    else Some(b)
  }

  def divisionNoReferentialTransparency(a: Double, b: Double): Double = {
    if( b == 0.0)
      throw new IllegalArgumentException("Division by zero")
    else {
      a / b
    }
  }
  val result = division(4.0, 0.0)

  print(result)
}
