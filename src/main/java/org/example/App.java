package org.example;

import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.AuthorDAO;
import org.example.repository.BookDAO;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
        int a = scanner.nextInt();
        AuthorDAO dao = new AuthorDAO();
        BookDAO bDao = new BookDAO();
        for (int i = 0; a != 15; i++) {
            if (a == 1) {
                System.out.println("                              ---------- Welcome to page where you must create new Author ----------");
                System.out.print("Enter name of Author:");
                String name = scanner.next();
                System.out.print("Enter age of Author:");
                int age = scanner.nextInt();
                Author author = new Author(name, age);
                dao.save(author);
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 2) {
                System.out.println("                              ---------- Welcome to page where you must create new Book ----------");
                System.out.print("Enter title of Book:");
                String title = scanner.next();
                System.out.print("Enter id of Author for this Book:");
                scanner.nextLine();
                Long id = scanner.nextLong();
                Author author = dao.getById(id);
                Book book = new Book();
                book.setTitle(title);
                book.setAuthor(author.getName());
                bDao.save(book);
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 3) {
                System.out.println(dao.findAll());
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 4) {
                System.out.println(bDao.findAll());
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 5) {
                System.out.print("Enter Author name for searching book:");
                String authorName = scanner.next();
                for (Book book: bDao.findAll()){
                    if (Objects.equals(book.getAuthor(), authorName)){
                        System.out.println(book);
                    }
                }
                System.out.println("\n1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 6) {
                System.out.print("Enter title of Book for searching Author:");
                 String title = scanner.next();
                for (Book book: bDao.findAll()){
                    if (Objects.equals(book.getTitle(), title)){
                        for (Author author: dao.findAll()){
                            if (Objects.equals(author.getName(), book.getAuthor())){
                                System.out.println(author);
                            }
                        }
                    }
                }
                System.out.println("\n1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 7) {
                System.out.print("Enter title of Book for searching:");
                String title = scanner.next();
                 for (Book book: bDao.findAll()){
                    if (Objects.equals(book.getTitle(), title)){
                        System.out.println(book);
                    }
                }
                System.out.println("\n1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 8) {
                System.out.print("Enter Author name for searching:");
                String name = scanner.next();
                for (Author author: dao.findAll()){
                    if (Objects.equals(author.getName(), name)){
                        System.out.println(author);
                    }
                }
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 9) {
                System.out.print("Enter ID of Book for searching:");
                Long id = scanner.nextLong();
                System.out.println(bDao.getById(id));
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 10) {
                System.out.print("Enter ID of Author for searching:");
                Long id = scanner.nextLong();
                System.out.println(dao.getById(id));
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 11) {
                System.out.print("Enter ID of Author which you wanna update:");
                Long id = scanner.nextLong();
                 System.out.print("Enter new name of Author:");
                String name = scanner.next();
                 System.out.print("Enter new age of Author:");
                int age = scanner.nextInt();
                Author author =  new Author(name,age);
                author.setName(name);
                author.setAge(age);
                dao.update(id,author);
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 12) {
                System.out.println("Enter ID of Book which you wanna update:");
                Long id = scanner.nextLong();
                System.out.print("Enter new title of Book:");
                String title = scanner.next();
                System.out.print("Enter new Author ID:");
                Long authorID = scanner.nextLong();
                Author author = dao.getById(authorID);
                Book book = new Book(title, author.getName());
                bDao.update(id,book);
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 13) {
                System.out.print("Enter ID of Author which you wanna delete:");
                Long id = scanner.nextLong();
                dao.delete(id);
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            } else if (a == 14) {
                System.out.print("Enter ID of Book which you wanna delete:");
                Long id = scanner.nextLong();
                bDao.delete(id);
                System.out.println("1 --> Create new Author\n2 --> create new Book\n3 --> get All Authors\n4 --> get all Book\n5 -->  get Book by Author\n6 --> get Author by Book\n7 --> get Book by Title\n8 --> get Author by Name\n9 --> get Book by Id\n10 --> get Author by Id\n11 --> update Author\n12 --> update Book\n13 --> delete Author\n14 --> delete Book\n15 --> stop code\n");
                a = scanner.nextInt();
            }
        }

    }
}
