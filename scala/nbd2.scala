package nbd

object nbd2 {
  def main(args: Array[String]): Unit = {}


//1.	Wykorzystaj Pattern Matching w funkcji przyjmującej parametr typu String. Dla stringów odpowiadających nazwom dni tygodnia funkcja ma zwrócić „Praca” i „Weekend” (odpowiednio dla dni roboczych i wolnych), dla pozostałych napisów „Nie ma takiego dnia”.

  def zad1(day: String) {
    day match {
      case "poniedziałek" => println("Praca")
      case "wtorek" => println("Praca")
      case "środa" => println("Praca")
      case "czwartek" => println("Praca")
      case "piątek" => println("Praca")
      case "sobota" => println("Weekend")
      case "niedziela" => println("Weekend")
      case _ => println("Nie ma takiego dnia")
    }
  }
  print("\n zad 1 \n")
  zad1("czwartek")
  zad1("niedziela")
  zad1("but")


//2.	Zdefiniuj klasę KontoBankowe z metodami wplata i wyplata oraz własnością stanKonta - własność ma być tylko do odczytu. Klasa powinna udostępniać konstruktor przyjmujący początkowy stan konta oraz drugi, ustawiający początkowy stan konta na 0.
  class KontoBankowe(var stanKonta: Double = 0) {
    def KontoBankowe {}

    def KontoBankowe(stan: Double) {stanKonta = stan;}

    def wplata(kwota: Double) {this.stanKonta += kwota}

    def wyplata(kwota: Double) {this.stanKonta -= kwota}
  }

  print("\n zad 2 \n")
  val konto = new KontoBankowe(400)
  println("stan = 400: "+konto.stanKonta)
  konto.wplata(100)
  println("plus 100: "+konto.stanKonta)
  konto.wyplata(50)
  println("minus 50: "+konto.stanKonta)


//3.	Zdefiniuj klasę Osoba z własnościami imie i nazwisko. Stwórz kilka instancji tej klasy. Zdefiniuj funkcję, która przyjmuje obiekt klasy osoba i przy pomocy Pattern Matching wybiera i zwraca napis zawierający przywitanie danej osoby. Zdefiniuj 2-3 różne przywitania dla konkretnych osób (z określonym imionami lub nazwiskami) oraz jedno domyślne.


  class Osoba(var Imie: String, var Nazwisko: String) {
    def przywitanie() {
      (Imie, Nazwisko) match {
        case ("Anna", "Kowalska") => println("Hej "+Imie+" "+Nazwisko)
        case ("Krzysztof", _) => println("Dzień dobry "+Imie+" "+Nazwisko)
        case (_, "Smith") => println("Hello "+Imie+" "+Nazwisko)
        case _ => println("Witaj "+Imie+" "+Nazwisko)
      }
    }

  }
  print("\n zad 3 \n")
  val osoba1 = new Osoba("Anna", "Kowalska")
  val osoba2 = new Osoba("Krzysztof", "W")
  val osoba3 = new Osoba("John", "Smith")
  val osoba4 = new Osoba("Rafał", "Brzozowski")

  osoba1.przywitanie()
  osoba2.przywitanie()
  osoba3.przywitanie()
  osoba4.przywitanie()




//4.	Zdefiniuj funkcję przyjmującą dwa parametry - wartość całkowitą i funkcję operującą na wartości całkowitej. Zastosuj przekazaną jako parametr funkcję trzykrotnie do wartości całkowitej i zwróć wynik.


  def zad4(integer: Int, function: (Int) => Int): Int = {
    return function(function(function(integer)))
  }
  print("\n zad 4 \n")
  print(zad4(5, (x) => (x - 3)))

//5.	Zdefiniuj klasę Osoba i trzy traity: Student, Nauczyciel, Pracownik. Osoba powinna mieć własności read only: imie, nazwisko, tax. Pracownik powinien mieć własność salary (z getterem i seterem). Student i Pracownik powinni przesłaniać własność tax – dla Studenta zwracamy 0, dla Pracownika 20% pensji. Nauczyciel powinien dziedziczyć z Pracownika, dla niego tax zwraca 10% pensji. Stwórz obiekty z każdym z traitów, pokaż jak tax działa dla każdego z nich. Stwórz obiekty z traitami Student i Pracownik, pokaż jak tax zadziała w zależności od kolejności w jakiej te traity zostały dodane przy tworzeniu obiektu.

  class Osoba2(val Imie: String, val Nazwisko: String, val tax: Double) {}

  trait Student extends Osoba2 {
    override val tax: Double = 0
  }

  trait Pracownik extends Osoba2 {
    var salary: Double = 3000000
    override val tax: Double = 0.2 * salary: Double
  }

  trait Nauczyciel extends Pracownik {
    override val tax: Double = 0.1 * salary: Double
  }

  print("\n zad 5 \n")

  val student = new Osoba2("Aleksandra", "Kowalska", 0.23) with Student
  val pracownik = new Osoba2("Piotr", "Nowak", 0.5) with Pracownik
  val nauczyciel = new Osoba2("Wojciech", "Górny", 0.7) with Nauczyciel
  val studentPracownik = new Osoba2("Eliza", "X", 0.01) with Student with Pracownik
  val pracownikStudent = new Osoba2("Klaudia", "Y", 0.18) with Pracownik with Student

  println("student: "+student.tax)
  println("pracownik: "+pracownik.tax)
  println("nauczyciel: "+nauczyciel.tax)
  println("student-pracownik: "+studentPracownik.tax)
  println("pracownik-student: "+pracownikStudent.tax)
}
