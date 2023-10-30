package telran.java48.book.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.java48.book.model.Book;
import telran.java48.book.model.Publisher;

public interface BookRepository extends JpaRepository<Book, String> {
	Stream<Book> findByAuthorsName(String name);
	Stream<Book> findByPublisherPublisherName(String publisherName);
	@Query("select distinct b.publisher from Book b " +
	           "join b.authors a " +
	           "where a.name=?1")
	Stream<Publisher> findPublishersByAuthorName(String authorName);
}
