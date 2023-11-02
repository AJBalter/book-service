	package telran.java48.book.dao;

import java.util.Optional;

import telran.java48.book.model.Author;

public interface AuthorRepository {
	Optional<Author> findById(String nameString);
	Author save(Author author);
	void delete(String authorName);

}
