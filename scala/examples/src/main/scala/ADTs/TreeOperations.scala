package ADTs
import ADTs._

object TreeOperations {
  trait TreeOp[+A] {
    def prettyPrinter(): Unit
  }

  object TreeOp {
    implicit class TreeOps[+A](t: Tree[A]) extends TreeOp[A] {
      override def prettyPrinter(): Unit = {
        def go(curr: Tree[A], depth: Int = 0): Unit = {
          curr match {
            case Node(v, l, r) =>
              println("\t" * depth + "Value: " + v)
              go(l, depth + 1)
              go(r, depth + 1)
            case Nill => println("\t" * depth + "Empty Node")
          }
        }

        go(t)
      }
    }
  }
}
