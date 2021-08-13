package example

import book.Book
import book.BookFactory
import book.BookStore

object Hello {

  def main(args: Array[String]): Unit = {

    val myBookStore: BookStore = new BookStore("Theravada Library", "theravada.xml")
    myBookStore.addBook("Rekin Biznesu", "Zbigniew Holdys", 29330, 119.99)
    myBookStore.save()
  }

}

