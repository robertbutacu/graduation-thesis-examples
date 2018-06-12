package ADTs

import scala.language.higherKinds
import ADTs._

trait TreeOps[T[_]] {
  def commonAncestor[A](t: T[A], el1: A, el2: A): Option[A]

  def DFS[A](t: T[A], el: A): Option[List[A]]
}

object TreeOps {

  object ops {
    implicit class TreeOperations[A](t: Tree[A]) {
      def DFS(el: A): Option[List[A]] =
        TreeOps[Tree].DFS(t, el)

      def commonAncestor(el1: A, el2: A): Option[A] = {
        TreeOps[Tree].commonAncestor(t, el1, el2)
      }
    }
  }

  def apply[A[_]](implicit sh: TreeOps[A]): TreeOps[A] = sh

  implicit val treeOps: TreeOps[Tree] = new TreeOps[Tree] {
    override def DFS[A](t: Tree[A], el: A): Option[List[A]] = {
      def go(curr: Tree[A], road: List[A]): Option[List[A]] = {
        curr match {
          case Nill => None
          case Node(v, l, r) =>
            if (v == el)
              Some(road :+ v)
            else {
              val left = go(l, road :+ v)
              val right = go(r, road :+ v)

              left orElse right
            }
        }
      }

      go(t, List.empty)
    }

    override def commonAncestor[A](t: Tree[A], el1: A, el2: A): Option[A] = {
      for {
        firstDFS <- this.DFS(t, el1)
        secondDFS <- this.DFS(t, el2)
      } yield firstDFS.zip(secondDFS)
        .takeWhile(e => e._1 == e._2)
        .last
        ._1
    }
  }
}
