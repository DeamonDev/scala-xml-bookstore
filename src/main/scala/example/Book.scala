package book

case class Book(title: String, author: String, isbn: Int, var price: Double) {

	def getTitle(): String = this.title
	def getAuthor(): String = this.author
	def getISBN(): Int = this.isbn
	def getPrice(): Double = this.price

	def changePrice(newPrice: Double) = {
		this.price = newPrice
	}

	override def toString(): String = {
		return "Title: " + this.title + "\n" + "Author: " + this.author + "\n" + "ISBN: " + this.isbn +
				 "\n" + "Price: " + this.price
	}

	def toXml = 
		<book> 
			<title>{title}</title>
			<author>{author}</author>
			<ISBN>{isbn}</ISBN>
			<price>{price}</price>
		</book>

}
