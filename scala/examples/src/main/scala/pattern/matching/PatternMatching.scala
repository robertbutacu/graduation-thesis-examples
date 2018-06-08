package pattern.matching

object PatternMatching extends App {
  def skipOne[G](l: List[G]): List[G] = {
    l match {
      case Nil => List()
      case h::Nil => List(h)
      case h::_::t => List(h) ::: skipOne(t)
    }
  }

  def factorial(n: Int): Option[Int] = {
    n match {
      case badInput if n < 0 => None
      case one if n == 1 || n == 0 => Some(1)
      case x => factorial(n - 1).map(result => result * x)
    }
  }

  trait X

  case class A(x: Int) extends X
  case class B(x: Int, y: Int) extends X
  case class C(x: Int, y: Int, z: Int) extends X
  case object D extends X

  def process(input: X): Unit = {
    input match {
      case A(x)       => println(s"""A: $x""")
      case B(x, y)    => println(s"""B: $x, $y""")
      case C(x, y, z) => println(s"""C: $x, $y, $z""")
      case D          => println("D")
    }
  }

  def processGeneric[G](input: G): Unit = {
    input match {
      case _: String => println("It's a string!")
      case _: Int => println("It's an int!")
      case x: X => process(x)
    }
  }

  print(processGeneric(0.0))
}
