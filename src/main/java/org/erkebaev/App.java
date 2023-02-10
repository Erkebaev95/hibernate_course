package org.erkebaev;

import org.erkebaev.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // получаем список пользователей
            List<Person> people = session.createQuery("FROM Person where name LIKE 'A%'").getResultList();

            for (Person person : people) {
                System.out.println(person);
            }

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
