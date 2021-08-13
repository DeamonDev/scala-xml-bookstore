package example

import scala.xml.Elem

object XMLLoader{

  def toBeAddedEntry(title: String, author: String, isbn: Int, price: Double) =
    <book>
      <title>{title}</title>
      <author>{author}</author>
      <ISBN>{isbn}</ISBN>
      <price>{price}</price>
    </book>

  def addNewEntry(originalXML: Elem, title: String, author: String, isbn: Int, price: Double ) = {
    originalXML match {
      case <BookStore>{ innerProps @ _* }</BookStore> => {
        <BookStore> {
          innerProps ++ toBeAddedEntry(title, author, isbn, price)
          }</BookStore>
      }

      case other => other
    }
  }

}
