package layers

import java.io.IOException

import scala.io.Source
import scala.util.{Failure, Success, Try}


object Layers extends App {
  def count(file: String): Unit = {
    val content = Source.fromFile(file).getLines.toList

    val words = content.flatMap(line => line.split(" "))
    val groupedWords = words.groupBy(w => w).values
    val counter = groupedWords.map(w => (w.head, w.length))
    counter.foreach(word => println(s"""Word: ${word._1} Count: ${word._2}"""))
  }

  def readFromFile(file: String): Try[List[String]] = Try {
    Source.fromFile(file).getLines().toList
  }

  def getWords = (lines: List[String]) => lines.flatMap(line => line.split(" "))
  def groupWords = (words: List[String]) => words.groupBy(w => w).values.toList
  def countWords = (groupedWords: List[List[String]]) => groupedWords.map(g => (g.head, g.length))
  def prettyPrinter(wordsCount: List[(String, Int)]): Unit =
    wordsCount.foreach(word => println(s"""Word: ${word._1} Count: ${word._2}"""))

  def countFromFile(file: String): Unit = {
    def counter = getWords andThen groupWords andThen countWords andThen prettyPrinter

    readFromFile(file) match {
      case Success(lines) => counter(lines)
      case Failure(ex) => println(ex)
    }
  }

  countFromFile("resources\\test.txt")
}
