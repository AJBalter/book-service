package telran.java48.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.java48.book.model.Publisher;
@Repository
public class PublisherRepositoryImpl implements PublisherRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public Stream<Publisher> findDistinctByBooksAuthorsName(String authorName) {
		String jpql = "select p from Book b join b.authors a join b.publisher p where a.name = :authorName group by p";
	    return em.createQuery(jpql, Publisher.class).setParameter("authorName", authorName).getResultStream();
	}

	@Override
	public Optional<Publisher> findById(String publisher) {
		return Optional.ofNullable(em.find(Publisher.class, publisher));
	}

	@Override
	public Publisher save(Publisher publisher) {
		em.persist(publisher);
	//	em.merge(publisher);
		return publisher;
	}

}
