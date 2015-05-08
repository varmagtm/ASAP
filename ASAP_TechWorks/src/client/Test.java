/**
 * 
 */
package client;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author m1012679
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	}

}
