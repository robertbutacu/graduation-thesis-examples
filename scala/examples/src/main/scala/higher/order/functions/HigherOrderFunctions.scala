package higher.order.functions

object HigherOrderFunctions extends App {

  //abstract definition
  trait List[A] {
    def map[B](f: A => B): List[B]
  }

  //a list is either represented by an element and another List tail
  case class Head[A](value: A, tail: List[A]) extends List[A] {
    override def map[B](f: A => B): List[B] = Head(f(value), tail.map(f))
  }

  //or it could be an empty list
  case class Empty[A]() extends List[A] {
    override def map[B](f: A => B): List[B] = Empty[B]()
  }

  val example = Head(1, Head(2, Head(3, Empty())))

  println(example)
  println(example.map(_ + 10))
}
