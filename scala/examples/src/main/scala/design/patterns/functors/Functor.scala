package design.patterns.functors

import scala.language.higherKinds

trait Functor[F[_]] {
  def map[A, B](f: A => B, data: F[A]): F[B]
}
