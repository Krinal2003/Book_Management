package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.Entity.Book;
import com.book.Repository.BookRepository;

@Service
public class Bookservice{
	@Autowired
		private BookRepository bookRepository;
		public Bookservice(BookRepository bookRepository) {
			this.bookRepository = bookRepository;
		}	
		public List<Book> getAllBooks(){
			return bookRepository.findAll();
		}
		public Book addBook(Book book){
			return bookRepository.save(book);
		}
		public void deleteBook(long id) {
			bookRepository.deleteById(id);
		}
		public Book findById(Long id) {
		    return bookRepository.findById(id).orElse(null);
		}
		public List<String> getAllFormats(){
			return bookRepository.findDistinctFormats();
		}

}
