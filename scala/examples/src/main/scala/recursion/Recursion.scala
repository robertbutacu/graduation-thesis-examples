package recursion

object Recursion extends App {
  def fibonacciFunctional(nthNumber: Int): Int = {
    def go(k: Int): Int = {
      k match {
        case 0 => 1
        case 1 => 1
        case _ => go(k - 1) + go(k - 2)
      }
    }

    go(nthNumber)
  }

  def fibonacci(nthNumber: Int): Int = {
    if(nthNumber < 2)
      1
    else {
      var nMinus1 = 1
      var nMinus2 = 1

      var current = nMinus1 + nMinus2

      for( _ <- 1 to nthNumber - 2) {
        nMinus1 = nMinus2
        nMinus2 = current
        current = nMinus1 + nMinus2
      }

      current
    }

  }

  println(fibonacci(5))
}
