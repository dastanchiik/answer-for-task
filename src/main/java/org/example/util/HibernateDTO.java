package org.example.util;

import org.example.model.Author;
import org.example.model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class HibernateDTO {

    private static SessionFactory ses;
    public static SessionFactory getSessionFactory(){
        if (ses == null) {
            try {
                LogManager logManager = LogManager.getLogManager();
                Logger rootLogger = logManager.getLogger("");
                rootLogger.setLevel(Level.SEVERE);

                Configuration configuration = new Configuration();
                Properties props = new Properties();
                props.put(Environment.DRIVER, "org.postgresql.Driver");
                props.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                props.put(Environment.USER, "postgres");
                props.put(Environment.PASS, "12345");
                props.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                props.put(Environment.SHOW_SQL, "false");
                props.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties( props );
                configuration.addAnnotatedClass( Author.class );
                configuration.addAnnotatedClass(Book.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                ses = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ses;
    }
}
