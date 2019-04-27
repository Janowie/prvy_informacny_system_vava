package logika;

import entity.Akcia;
import entity.Clen;
import entity.UcastNaAkcii;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DatabazaUtil {

    public static void pridajAkciuDoDB(Akcia akcia){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(akcia);
            transaction.commit();
        }catch (Exception e){
            // TODO LOG
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public static void pridajClenaNaAkciu(Clen clen, Akcia akcia){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            UcastNaAkcii ucastNaAkcii = new UcastNaAkcii();
            ucastNaAkcii.setAkcia(akcia);
            ucastNaAkcii.setClen(clen);

            session.persist(ucastNaAkcii);
            transaction.commit();
        }catch (Exception e){
            // TODO LOG
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public static List<Clen> vratUcastnikovAkcie(Akcia akcia){
        List<Clen> ucastnici = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "SELECT clen FROM Clen clen JOIN clen.ucastiNaAkciach UcastNaAkcii WHERE UcastNaAkcii.akcia = :akcia AND UcastNaAkcii.ucast = true";
            Query query = session.createQuery(hql);
            query.setParameter("akcia", akcia);
            ucastnici = query.list();
            transaction.commit();
        }catch (Exception e){
            // TODO LOG
            transaction.rollback();
        }finally {
            session.close();
        }
        return ucastnici;
    }

    public static List<Clen> vratPrihlasenychNaAkciu(Akcia akcia){
        List<Clen> prihlaseni = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "SELECT clen FROM Clen clen JOIN clen.ucastiNaAkciach UcastNaAkcii WHERE UcastNaAkcii.akcia = :akcia";
            Query query = session.createQuery(hql);
            query.setParameter("akcia", akcia);
            prihlaseni = query.list();
            transaction.commit();
        }catch (Exception e){
            // TODO LOG
            transaction.rollback();
        }finally {
            session.close();
        }
        return prihlaseni;
    }

    public static List<Akcia> vratVsetkyAkcie(){
        List<Akcia> akcie = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "FROM Akcia";
            Query query = session.createQuery(hql);
            akcie = query.list();
            transaction.commit();
        }catch (Exception e){
            // TODO LOG
            transaction.rollback();
        }finally {
            session.close();
        }
        return akcie;
    }


}
