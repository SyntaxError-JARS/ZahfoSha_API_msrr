package com.revature.zahfosha.util;


import com.revature.zahfosha.menu.MenuModel;
import com.revature.zahfosha.orders.OrdersModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() throws IOException {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
//            Properties props = new Properties();
//            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            props.load(loader.getResourceAsStream("hibernate.properties"));

//            configuration.setProperties(props);

            String url = System.getenv("SQLAZURECONNSTR_zahfosha");
            String username = System.getenv("DBUSER");
            String password = System.getenv("DBPASS");

            configuration.setProperty("hibernate.connection.url", url);
            configuration.setProperty("hibernate.connection.username", username);
            configuration.setProperty("hibernate.connection.password", password);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");


            // TODO setup config with proper classes
            configuration.addAnnotatedClass(MenuModel.class);
            configuration.addAnnotatedClass(OrdersModel.class);
//            configuration.addAnnotatedClass(ElementType.class);
//            configuration.addAnnotatedClass(Ability.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        if(session == null) {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void closeSession() {
        session.close();
        session = null;

    }
}