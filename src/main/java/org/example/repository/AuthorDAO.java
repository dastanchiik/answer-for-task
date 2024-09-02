package org.example.repository;

import org.example.model.Author;
import org.example.util.HibernateDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDAO {

    private static final SessionFactory sessionFactory = HibernateDTO.getSessionFactory();

    public void save(Author person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }
    public Author getById(Long id) {
        Session session = sessionFactory.openSession();
        Author person = session.get(Author.class, id);
        session.close();
        return person;
    }
    public void update(Long id, Author newPerson) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author person1 = session.get( Author.class,id );
        person1.setName( newPerson.getName() );
        person1.setAge( newPerson.getAge() );
        session.update(person1);
        transaction.commit();
        session.close();
    }
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author person = session.get(Author.class, id);
        System.out.println("Author with name "+person.getName()+" deleted✔");
        session.delete(person);
        transaction.commit();
        session.close();
    }
    public List<Author> findAll() {
        Session session = sessionFactory.openSession();
        Query<Author> query = session.createQuery("select v from Author v", Author.class);
        List<Author> personList = query.list();
        session.close();
        return personList;
    }
    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("DELETE FROM Author");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}