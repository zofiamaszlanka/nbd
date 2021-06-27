package nbd

import scala.annotation.tailrec

object nbd1 {

  val week_days = List[String]("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela")
  val alphabet= Map("a" -> "first letter",
                    "b" -> "second letter",
                    "c" -> "third letter")
  val zad8: List[Int] = List(1, 2, 0, 3, 4, 5, 6, 0, 0, 0, 7, 0)//losowe numery
  val zad9 = List(1, 2, 3, 4, 5)
  val zad10 = List(-6, -5, -1, 0, 1, 12, 13)

  def main(args: Array[String]) {}

//1.	Stwórz 7 elementową listę zawierającą nazwy dni tygodnia. Napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
  // a.	Pętli for

  def zad_1a(): String = {

    var z_1a: String = ""
    for (day <- this.week_days) {
      z_1a = z_1a+day+", "
    }
    return z_1a
  }

  print("\n zad 1a \n")
  print(zad_1a())

  //b.	Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”

  def zad_1b(): String = {

    var z_1b: String = ""
    for (day <- week_days if day.startsWith("p")) {
      z_1b = z_1b+day+", "
    }
    return z_1b
  }

  print("\n zad 1B \n")
  print(zad_1b())

  // c.	Pętli while
  def zad_1c(): String = {

    var i = 0
    var z_1c: String = ""
    while (i < week_days.length) {
      z_1c = z_1c+(week_days(i))+", "
      i = i+1
    }
    return z_1c
  }

  print("\n zad 1C \n")
  print(zad_1c())

//2.	Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
  // a.	Funkcji rekurencyjnej

  def zad_2a(week_days: List[String]): String = {

    var z_2a: String = ""
    if (week_days.tail.isEmpty) {
      return week_days.head
    }
    z_2a = week_days.head+", "+zad_2a(week_days.tail)
    return z_2a
  }

  print("\n zad 2A \n")
  print(zad_2a(week_days))

  //b.	Funkcji rekurencyjnej wypisując elementy listy od końca

  def zad_2b(week_days: List[String]): String = {

    var z_2b: String = ""
    if (week_days.tail.isEmpty) {
      return week_days.head
    }
    z_2b = zad_2b(week_days.tail)+", "+week_days.head
    return z_2b
  }

  print("\n zad 2B \n")
  print(zad_2b(week_days))

//3. Stwórz funkcję korzystającą z rekurencji ogonowej do zwrócenia oddzielonego przecinkami stringa zawierającego elementy listy z ćwiczenia 1

  @tailrec
  def zad_3(week_days: List[String], results: String): String = {

    if (week_days.tail.nonEmpty) {
      zad_3(week_days.tail, results+week_days.head+", ")
    } else {
      return results+week_days.head
    }
  }

  print("\n zad 3 \n")
  print(zad_3(week_days, ""))

//4.	Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
  //a.	Metody foldl

  def zad_4a(): String = {

    var z_4a: String = ""
    z_4a = week_days.foldLeft("")((a, b) => a+b+", ")
    return z_4a
  }

  print("\n zad 4A \n")
  print(zad_4a())

  //b.	Metody foldr

  def zad_4b(): String = {

    var z_4b: String = ""
    z_4b = week_days.foldRight("")((a, b) => a+", "+b)
    return z_4b
  }

  print("\n zad 4B \n")
  print(zad_4b())

  //c.	Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”

  def zad_4c(): String = {

    var z_4c: String = ""
    z_4c = week_days.foldLeft("")((a, b) => if (b.startsWith("p")) a+b+", " else a)
    return z_4c
  }

  print("\n zad 4C \n")
  print(zad_4c())

//5.	Stwórz mapę z nazwami produktów i cenami. Na jej podstawie wygeneruj drugą, z 10% obniżką cen. Wykorzystaj mechanizm mapowania kolekcji.

  def zad_5() {

    val products = Map("Shoes" -> 199.99, "T-shirt" -> 59.99, "Jacket" -> 399.99)
    val discount = 1-0.1
    val sale_products = products.map { case (a, b) => (a, b * discount) }

    print(sale_products)
  }

  print("\n zad 5 \n")
  print(zad_5())

//6.	Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je

  def zad_6(a: String, b: Int, c: Double) = {println(a, b, c)}

  print("\n zad 6 \n")
  zad_6("a", 1, 9.9)


//7.	Zaprezentuj działanie Option na dowolnym przykładzie (np. mapy, w której wyszukujemy wartości po kluczu)

  def zad_7(z: Option[String]) = z match {

    case Some(x) => (x)
    case None => ("not found")
  }

  print("\n zad 7 \n")
  print(zad_7(alphabet.get("a")))

//8.	Napisz funkcję usuwającą zera z listy wartości całkowitych (tzn. zwracającą listę elementów mających wartości różne od 0).  Wykorzystaj rekurencję.



  def zad_8(list: List[Int], value: Int): List[Int] = {

    val head = list.head
    val tail = list.tail
    var results = List[Int]()
    if(head != 0) {
      results = results.appended(head)
    }
    if(tail.nonEmpty){
      zad_8(tail, value) ::: results
    } else {
      results
    }
  }

  print("\n zad 8 \n")
  println(zad_8(zad8, 0))


//9.	Zdefiniuj funkcję, przyjmującą listę liczb całkowitych i zwracającą wygenerowaną na jej podstawie listę, w której wszystkie liczby zostały zwiększone o 1. Wykorzystaj mechanizm mapowania kolekcji.

  def zad_9(elements: List[Int]): List[Int] = {
    return elements.map(element => element+1)
  }

  print("\n zad 9 \n")
  print(zad_9(zad9))

//10. 10.	Stwórz funkcję przyjmującą listę liczb rzeczywistych i zwracającą stworzoną na jej podstawie listę zawierającą wartości bezwzględne elementów z oryginalnej listy należących do przedziału <-5,12>. Wykorzystaj filtrowanie.

  def zad_10(elements: List[Int]): List[Int] = {
    return elements.filter(_ <= 12).filter(_ >= -5).map(element => element.abs)
  }

  print("\n zad 10 \n")
  print(zad_10(zad10))
}
