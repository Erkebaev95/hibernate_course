package org.erkebaev;

import org.erkebaev.model.Item;
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
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            /*Person person = session.get(Person.class, 5);
            System.out.println(person);

            List<Item> items = person.getItems();
            System.out.println(items);*/

            Item item = session.get(Item.class, 1);
            System.out.println(item);

            Person person1 = item.getOwner();
            System.out.println(person1);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
