package com.book.Controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.book.Entity.Book;
import com.book.service.Bookservice;

@Controller
//@RestController use json
@RequestMapping("/books")
public class BookController{

	private final Bookservice bookService;
	
	public BookController(Bookservice bookService) {
		this.bookService = bookService;
	}
	
	  @GetMapping("/form")
	    public String showBookForm() {
	        return "book-form";  
	    }
	  @PostMapping("/books")
	  public String addBook(@ModelAttribute Book book) {
	      bookService.addBook(book); // Save the book to the database
	      return "redirect:/books/books"; // Redirect to the book list
	  }
	    // Show book list
		@GetMapping("/books")
		public String getAllBooks(Model model) {
			List<Book> books = bookService.getAllBooks(); // Fetch all books
			model.addAttribute("books", books); // Add books to the model
			return "books"; 
		}
	    // Delete book
	    @PostMapping("/{id}")
	    public String deleteBook(@PathVariable Long id) {
	        bookService.deleteBook(id);
	        return "redirect:/books";
	    }
}

//--------- All JSon code complitly run----------//
//	@GetMapping("/")
//	public List<Book> getAllBooks(){
//		return bookService.getAllBooks();
//	}
//	@PostMapping("/")
//	public String addBook(@RequestBody Book book) {
//	    bookService.addBook(book); // Ensure this line is present
//	    return "Book '" + book.getTitle() + "' added successfully!";
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteBook(@PathVariable(name = "id") Long id) { 
//	    bookService.deleteBook(id);
//	    return ResponseEntity.ok("Book deleted successfully");
//	}
	
	 
	 //@PostMapping("/books")
		//public String addBook(@RequestBody Book book) {
//			 return "Book '" + book.getTitle() + "' added successfully!";
		//} this code not add a book in database 
		//	

//			@PostMapping("/books")
//			public String addBook(@RequestParam("title") String title,
//			                      @RequestParam("author") String author,
//			                      @RequestParam("price") double price) {
//			    Book book = new Book();
//			    book.setTitle(title);
//			    book.setAuthor(author);
//			    book.setPrice(price);
		//
//			    bookService.addBook(book);
		//
//			    return "Book '" + title + "' added successfully!";
//			}  use a @Requestparam, it is use to a define a parameter in postman = "form-data"

//		@DeleteMapping("/{id}")
//		public ResponseEntity<String> deleteBook(@PathVariable Long id) {
//		    Book book = bookService.findById(id);
//		    if (book == null) {
//		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
//		    }
	//
//		    bookService.deleteBook(id);
//		    return ResponseEntity.ok("Book deleted successfully");
//}
//}
//----------------------------------------------------//	

