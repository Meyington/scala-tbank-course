abstract class DiffList[A](calculate: List[A] => List[A]) {
  def prepend(s: List[A]): DiffList[A]
  def append(s: List[A]): DiffList[A]
  def result: List[A]
}

final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {

  def prepend(s: List[A]): DiffListImpl[A] =
    new DiffListImpl[A](list => s ++ listFunc(list))

  def append(s: List[A]): DiffListImpl[A] =
    new DiffListImpl[A](list => listFunc(s ++ list))

  def result: List[A] = listFunc(Nil)
}