package dao;

import config.HibernateConfig;
import model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDAO {

    private final SessionFactory sessionFactory;

    public CountryDAO() {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    public List<Country> getAllCountries() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Country", Country.class).list();
        }
    }

    public void addCountry(Country country) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(country);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

