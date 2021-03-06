package hadeslee.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * Project: HibernateTutorial
 * FileName: HibernateUtil
 * Date: 2015-05-20
 * Time: 오후 2:55
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */

/**
 * @author Deepak Kumar * Web: http://www.roseindia.net
 *  Update by arahansa@naver.com
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static String configFile = "hibernate.cfg.xml";

    static {
        try {
            Configuration cfg = new Configuration().configure(configFile);
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        sessionFactory.close();
    }
}