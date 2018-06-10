package ADTs

import ADTs._

import scala.language.higherKinds

trait PrettyPrinter[A[_]] {
  def prettyPrinter(t: A[_]): Unit
}

object PrettyPrinter {
  object ops {
    implicit class PrettyPrinterOps(t: Tree[_]) {
      def prettyPrinter(): Unit = {
        PrettyPrinter[Tree].prettyPrinter(t)
      }
    }
  }

  def apply[A[_]](implicit sh: PrettyPrinter[A]): PrettyPrinter[A] = sh

  implicit val treePrinter: PrettyPrinter[Tree] = (t: Tree[_]) => {
    def go(curr: Tree[_], depth: Int = 0): Unit = {
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
