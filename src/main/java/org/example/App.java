package org.example;

import org.example.repository.PersonDAO;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        PersonDAO personDAO = new PersonDAO();

        personDAO.deleteAll();
    }
}
