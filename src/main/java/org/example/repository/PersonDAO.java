package org.example.repository;

import org.example.model.Person;
import org.example.util.HibernateDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDAO {

    private static final SessionFactory sessionFactory = HibernateDTO.getSessionFactory();

    public void save(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }
    public Person getById(Long id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }
    public void update(Long id,Person newPerson) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person1 = session.get( Person.class,id );
        person1.setName( newPerson.getName() );
        person1.setAge( newPerson.getAge() );
        session.update(person1);
        transaction.commit();
        session.close();
    }
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.delete(person);
        transaction.commit();
        session.close();
    }
    public List<Person> findAll() {
        Session session = sessionFactory.openSession();
        Query<Person> query = session.createQuery("select v from Person v", Person.class);
        List<Person> personList = query.list();
        session.close();
        return personList;
    }
    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("DELETE FROM Person");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}