package org.example.repository;

import org.example.model.Author;
import org.example.model.Book;
import org.example.util.HibernateDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAO {
    private static final SessionFactory sessionFactory = HibernateDTO.getSessionFactory();

    public void save(Book person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }
    public Book getById(Long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }
    public void update(Long id, Book newBook) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.get( Book.class,id );
        book.setTitle( newBook.getTitle() );
        book.setAuthor( newBook.getAuthor() );
        session.update(book);
        transaction.commit();
        session.close();
    }
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book person = session.get(Book.class, id);
        session.delete(person);
        System.out.println("Book with title "+person.getTitle()+" deleted✔");
        transaction.commit();
        session.close();
    }
    public List<Book> findAll() {
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("select v from Book v", Book.class);
        List<Book> personList = query.list();
        session.close();
        return personList;
    }
    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("DELETE FROM Book ");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
