package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Todo;

/**
 * Test pripojenia k DB cez ORM Hibernate, ulozenie jedneho zaznamu (Todo) do DB
 * @author Jaroslav Jakubik
 */
public class ORMTest {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Todo todo = new Todo();
		todo.setNotificationDate(new Date());
		todo.setText("Vstavaj do prace");
		
		session.persist(todo);
		
		t.commit();
	}

}
