package book

import example.XMLLoader.addNewEntry

import scala.collection.mutable.ListBuffer
import scala.xml.XML

class BookStore(name: String, fileName: String) {

	private var bookListXML: ListBuffer[Book] = new ListBuffer[Book]()
	private var bookListTemp: ListBuffer[Book] = new ListBuffer[Book]()

	val storedBooksXML = xml.XML.loadFile(fileName)

	storedBooksXML match {
		case <BookStore>{content @ _*}</BookStore> =>
			for (b @ <book>{_*}</book> <- content) {
				val bTitle = (b \ "title").toString
				val bAuthor = (b \ "author").toString
				val bISBN = (b \ "ISBN").text.toInt
				val bPrice = (b \ "price").text.toDouble
				bookListXML += BookFactory(bTitle, bAuthor, bISBN, bPrice)
			}
	}


	def addBook(title: String, author: String, isbn: Int, price: Double) = 
		bookListTemp += BookFactory(title, author, isbn, price)

	//should be invoked at the very end of the session
	def save() = {
		for (temp <- bookListTemp) {
			val addedNode = addNewEntry(storedBooksXML, temp.getTitle(), temp.getAuthor(), temp.getISBN(), temp.getPrice())
			scala.xml.XML.save(fileName, addedNode)
		}
		bookListTemp.clear()
	}


	def toXml =
		<BookStore>
			{ bookListTemp.map(_.toXml) }
		</BookStore>
}