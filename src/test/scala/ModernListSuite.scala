package me.asdfa.postmortem.l1

import munit.FunSuite

class ModernListSuite extends FunSuite {
  test("allIndexes of 1 on [1,2,3,4,1,5,6]") {
    val expected = List.Cons(0, List.Cons(4, List.Nil))
    val actual = allIndexes(List.Cons(1, List.Cons(2, List.Cons(3, List.Cons(4, List.Cons(1, List.Cons(5, List.Cons(6, List.Nil))))))), 1)
    assertEquals(actual, expected)
  }
  test("allIndexesWhere of >5 on [1,2,3,4,1,5,6]") {
    val notexpected = List.Cons(5, List.Nil)
    val expected = List.Cons(6, List.Nil)
    val actual = allIndexesWhere(List.Cons(1, List.Cons(2, List.Cons(3, List.Cons(4, List.Cons(1, List.Cons(5, List.Cons(6, List.Nil))))))), x => x > 5)
    assertNotEquals(actual, notexpected)
    assertEquals(actual, allIndexesWhere(List.Cons(1, List.Cons(2, List.Cons(3, List.Cons(4, List.Cons(1, List.Cons(5, List.Cons(6, List.Nil))))))), x => x > 5))
  }
  test("zip3 on [1,2,3] and [4,5,6] and [7,8,9]") {
    val expected = List.Cons((1, 4, 7), List.Cons((2, 5, 8), List.Cons((3, 6, 9), List.Nil)))
    val actual = zip3(List.Cons(1, List.Cons(2, List.Cons(3, List.Nil))), List.Cons(4, List.Cons(5, List.Cons(6, List.Nil))), List.Cons(7, List.Cons(8, List.Cons(9, List.Nil))))
    assertEquals(actual, expected)
  }
  test("unzip3 on [(1,4,7), (2,5,8), (3, 6, 9)]") {
    val expected = (List.Cons(1, List.Cons(2, List.Cons(3, List.Nil))), List.Cons(4, List.Cons(5, List.Cons(6, List.Nil))), List.Cons(7, List.Cons(8, List.Cons(9, List.Nil))))
    val actual = unzip3(List.Cons((1, 4, 7), List.Cons((2, 5, 8), List.Cons((3, 6, 9), List.Nil))))
    assertEquals(actual, expected)
  }
  test("toString on [a,2,;]") {
    val expected = "a2;"
    val actual = me.asdfa.postmortem.l1.toString(List.Cons('a', List.Cons('2', List.Cons(';', List.Nil))))
    assertEquals(actual, expected)
  }
  test("join on [\"1a\", \"vg\", \";eo\"], separator = \"0\"") {
    val expected = "1a0vg0;eo0"
    val actual = join(List.Cons("1a", List.Cons("vg", List.Cons(";eo", List.Nil))), "0")
    assertEquals(actual, expected)
  }
}

//      join(xs: List[String], separator: String): String
