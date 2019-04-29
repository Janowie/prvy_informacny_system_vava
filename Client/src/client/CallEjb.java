package client;

import entity.Akcia;
import logika.DatabazaUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.*;

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

        List<Akcia> akcie = DatabazaUtil.vratVsetkyAkcie();
        for(Akcia akcia:akcie){
            System.out.println(akcia.getNazov() + " " + akcia.getDatumAkcie());
        }

        akcie = DatabazaUtil.vratIbaAktivneAkcie();
        System.out.println(akcie.size());
        for(Akcia akcia:akcie){
            System.out.println(akcia.getNazov() + " " + akcia.getDatumAkcie());
        }
//        FileHandler fh = new FileHandler("C:/Users/peter/Documents/Škola/VAVA/VAVA - Projekt/logy/vololo.log");
//        skusobnyLogger.addHandler(fh);
//        SimpleFormatter formatter = new SimpleFormatter();
//        fh.setFormatter(formatter);

        skusobnyLogger.warning("pokus o nejaky log");

//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction t = session.beginTransaction();
//        Clen clen = new Clen();
//        clen.setMeno("kazisvet");
//        LocalDate date = LocalDate.of(2005, 06, 24);
//        clen.setDatumNarodenia(date);
//        clen.setEmail("petik@gmail.com");
//        session.persist(clen);
//        t.commit();
//        session.close();

//        List<Clen> clenovia = DatabazaUtil.vratPrihlasenychNaAkciu(akcia);
//
//        System.out.println(clenovia.size());
//        for(Clen clen:clenovia){
//            System.out.println(clen);
//        }
//
//        clenovia = DatabazaUtil.vratUcastnikovAkcie(akcia);
//        System.out.println(clenovia.size());
//        for(Clen clen:clenovia){
//            System.out.println(clen);
//        }

    }

    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger skusobnyLogger = Logger.getLogger("skusobnyLogger");


    static{

        try {
            logManager.readConfiguration(new FileInputStream("Server/src/resources/logger.properties"));
        } catch (IOException exception) {
            skusobnyLogger.log(Level.SEVERE, "Error in loading configuration",exception);
        }
    }

}
