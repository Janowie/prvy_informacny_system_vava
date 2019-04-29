package logika;

import entity.Akcia;
import entity.Clen;
import entity.UcastNaAkcii;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabazaUtil {

    private static final Logger dbLogger = Logger.getLogger("dbLogger");

    public static void pridajAkciuDoDB(Akcia akcia){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(akcia.getDatumAkcie());
        try {
            session.saveOrUpdate(akcia);
            transaction.commit();
        }catch (Exception e){
            dbLogger.log(Level.SEVERE, e.toString(), e);
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

            clen.getUcastiNaAkciach().add(ucastNaAkcii);

            session.persist(ucastNaAkcii);
            session.merge(clen);
            transaction.commit();
        }catch (Exception e){
            dbLogger.log(Level.SEVERE, e.toString(), e);
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
            dbLogger.log(Level.SEVERE, e.toString(), e);
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
            dbLogger.log(Level.SEVERE, e.toString(), e);
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
            String hql = "SELECT a FROM Akcia a";
            Query query = session.createQuery(hql);
            akcie = query.list();
            transaction.commit();
            }catch (Exception e){
            dbLogger.log(Level.SEVERE, e.toString(), e);
            transaction.rollback();
        }finally {
            session.close();
        }
        return akcie;
    }

    public static List<Akcia> vratIbaAktivneAkcie(){
        List<Akcia> akcie = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "SELECT a FROM Akcia a WHERE a.datumAkcie >= CURRENT_DATE()";
            Query query = session.createQuery(hql);
            akcie = query.list();
            transaction.commit();
        }catch (Exception e){
            dbLogger.log(Level.SEVERE, e.toString(), e);
            transaction.rollback();
        }finally {
            session.close();
        }
        return akcie;
    }


    public static Clen vratClenaPodlaId(int id){
        Clen clen = new Clen();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "SELECT c FROM Clen c WHERE c.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            clen = (Clen) query.getSingleResult();
            Hibernate.initialize(clen.getUcastiNaAkciach());
            transaction.commit();
        }catch (Exception e){
            dbLogger.log(Level.SEVERE, e.toString(), e);
            transaction.rollback();
        }finally {
            session.close();
        }
        return clen;
    }

}
