package me.asdfa.postmortem.l1

import scala.annotation.tailrec

enum List[+A]:
  case Nil
  case Cons(now: A, other: List[A])

//  @tailrec
//  def allIndexes(xs: List[A], a: A): List[Int] =
//    case List.Nil
//    => new List[Int]
//    case List.Cons(f, tl)
//    => xs match

//
//  def allIndexesWhere(xs: List[A], pred: A => Boolean): List[Int] =

////
//@tailrec
//def zip3[A, B, C](xs: List[A], ys: List[B], zs: List[C]): List[(A, B, C)] =
//  //чесно кажучи це якась дупа
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



//def unzip3(xs: List[(A, B, C)]): (List[A], List[B], List[C]) =



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



