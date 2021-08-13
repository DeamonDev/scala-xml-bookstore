package book

object BookFactory {
	def apply(title: String, author: String, isbn: Int, price: Double) =
		Book(title, author, isbn, price)
}