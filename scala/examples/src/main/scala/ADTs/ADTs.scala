package ADTs

import TreeOperations.TreeOp.TreeOps
object ADTs extends App {
  trait Tree[+A]

  case object Nill extends Tree[Nothing]
  case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

  val tree = Node("1",
    Node("2",
      Node("3", Nill, Nill),
      Nill),
    Node("4",
      Node("5", Nill, Nill),
      Nill))

  tree.prettyPrinter()
}
