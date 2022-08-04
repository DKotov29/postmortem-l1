package me.asdfa.postmortem.l1

import scala.annotation.tailrec

enum List[+A]:
  case Nil
  case Cons(now: A, other: List[A])


def allIndexes[A](xs: List[A], a: A): List[Int] =

  def F[A](x: List[A], b: A, buf: Int): List[Int] =
    x match
      case List.Nil => List.Nil
      case List.Cons(now, other) =>
        if (now == b)
          List.Cons(buf, F(other, b, buf + 1))
        else
          F(other, b, buf + 1)

  F(xs, a, 0)



def allIndexesWhere[A](xs: List[A], pred: A => Boolean): List[Int] =
  def F[A](x: List[A], pr: A => Boolean, buf: Int): List[Int] =
    x match
      case List.Nil => List.Nil
      case List.Cons(now, other) =>
        if (pr(now))
          List.Cons(buf, F(other, pr, buf + 1))
        else
          F(other, pr, buf + 1)

  F(xs, pred, 0)

////
//@tailrec
//def zip3[A, B, C](xs: List[A], ys: List[B], zs: List[C]): List[(A, B, C)] =
//  //честно кажучи це якась дупа
//  xs match
//    case List.Nil =>
//      ys match
//        case List.Nil =>
//          zs match
//            case List.Nil => List.Nil
//            case List.Cons(now, other) => List.Cons((List.Nil, List.Nil, now), zip3(List.Nil, List.Nil, other))
//        case List.Cons(now, other) =>
//          zs match
//            case List.Nil => List.Cons((List.Nil, now, List.Nil), zip3(List.Nil, other, List.Nil))
//            case List.Cons(now1, other1) => List.Cons((List.Nil, now, now1), zip3(List.Nil, other, other1))
//    case List.Cons(now, other) =>
//      ys match
//        case List.Nil =>
//          zs match
//            case List.Nil => List.Cons((now, List.Nil, List.Nil), zip3(other, List.Nil, List.Nil))
//            case List.Cons(now2, other2) => List.Cons((now, List.Nil, now2), zip3(other, List.Nil, other2))
//        case List.Cons(now1, other1) =>
//          zs match
//            case List.Nil => List.Cons((now, now1, List.Nil), zip3(other, other1, List.Nil))
//            case List.Cons(now2, other2) => List.Cons((now, now1, now2), zip3(other, other1, other2))

def zip3[A, B, C](xs: List[A], ys: List[B], zs: List[C]): List[(A, B, C)] =
  xs match
    case List.Nil => List.Nil
    case List.Cons(now, other) =>
      ys match
        case List.Nil => List.Nil
        case List.Cons(now1, other1) =>
          zs match
            case List.Nil => List.Nil
            case List.Cons(now2, other2) => List.Cons((now, now1, now2), zip3(other, other1, other2))


def unzip3[A, B, C](xs: List[(A, B, C)]): (List[A], List[B], List[C]) =
  xs match
    case List.Nil => (List.Nil, List.Nil, List.Nil)
    case List.Cons((a, b, c), other) =>
      val (m, n, t) = unzip3(other)
      (List.Cons(a, m), List.Cons(b, n), List.Cons(c, t))


def toString(xs: List[Char]): String =
  xs match
    case List.Nil => ""
    case List.Cons(now: Char, other: List[Char]) => "".+:(now).+(toString(other))

def join(xs: List[String], separator: String): String =
  xs match
    case List.Nil => ""
    case List.Cons(now, other) => now + separator + join(other, separator) // вже відчуваю сепаратор в самому кінці, що здаєця не треба...


// NOTE: do not use this to demo the results.
// Use unit-tests instead
@main def run() =
  println("Hello")



