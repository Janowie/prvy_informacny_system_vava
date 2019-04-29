package client;

import entity.Akcia;
import entity.Clen;
import entity.UcastNaAkcii;
import logika.DatabazaUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import test.FacadeBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Jednoduchy priklad volania stateless session beany (z klient na aplikacny server)
 * na zaklade JNDI
 * 
 * @author Jaroslav Jakubik
 */
public class CallEjb {

	private static final String JNDI = "ejb:EA/Server//FacadeBean!test.FacadeBeanRemote";
	
	public static void main(String[] args) throws Exception {


//		Context ctx = new InitialContext();
//		FacadeBeanRemote calcFacade = (FacadeBeanRemote) ctx.lookup(JNDI);
//
//		System.out.println(calcFacade.doPlus(5, 11, -2));


//        Akcia akcia = new Akcia();
//        Clen clen = DatabazaUtil.vratClenaPodlaId(3);
//        akcia.setZodpovednaOsoba(clen);
//        System.out.println(akcia.getZodpovednaOsoba());
//        for (UcastNaAkcii ucastNaAkcii:clen.getUcastiNaAkciach()){
//            System.out.println(ucastNaAkcii.getAkcia().getId());
//        }

//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction t = session.beginTransaction();
//        Akcia akcia = session.get(Akcia.class, 7);
//        t.commit();
//        session.close();

//        Clen clen = DatabazaUtil.vratClenaPodlaId(3);
//        System.out.println(clen.getUcastiNaAkciach().size());
//        for (UcastNaAkcii ucastNaAkcii:clen.getUcastiNaAkciach()){
//            System.out.println(ucastNaAkcii.getAkcia().getNazov());
//      }

        //DatabazaUtil.pridajClenaNaAkciu(clen, akcia);


//        Akcia akcia = new Akcia();
//        akcia.setUcastiNaAkcii(new ArrayList<>());
//        LocalDate date = LocalDate.of(2005, 06, 24);
//        akcia.setDatumAkcie(date);
//        akcia.setNazov("efefewq");
//        akcia.setMiestoKonania("stiavnica");
//        akcia.setPopis("mega super");
//        Clen clen = DatabazaUtil.vratClenaPodlaId(4);
//        akcia.setZodpovednaOsoba(clen);
//
//        System.out.println(clen.getUcastiNaAkciach().size());
//        for (UcastNaAkcii ucastNaAkcii:clen.getUcastiNaAkciach()){
//            System.out.println(ucastNaAkcii.getAkcia().getNazov());
//      }
//
//        DatabazaUtil.pridajAkciuDoDB(akcia);
//
//
//        System.out.println(clen);

//        List<Akcia> akcie = DatabazaUtil.vratVsetkyAkcie();
//        for(Akcia akcia:akcie){
//            System.out.println(akcia.getNazov() + " " + akcia.getDatumAkcie());
//        }
//
//        akcie = DatabazaUtil.vratIbaAktivneAkcie();
//        System.out.println(akcie.size());
//        for(Akcia akcia:akcie){
//            System.out.println(akcia.getNazov() + " " + akcia.getDatumAkcie());
//        }



        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        Akcia akcia = session.get(Akcia.class, 2);
        t.commit();
        session.close();

        List<Clen> clenovia = DatabazaUtil.vratPrihlasenychNaAkciu(akcia);

        System.out.println(clenovia.size());
        for(Clen clen:clenovia){
            System.out.println(clen);
        }

        clenovia = DatabazaUtil.vratUcastnikovAkcie(akcia);
        System.out.println(clenovia.size());
        for(Clen clen:clenovia){
            System.out.println(clen);
        }

    }

}
