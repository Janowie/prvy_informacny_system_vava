package client;

import entity.Akcia;
import entity.Clen;
import entity.UcastNaAkcii;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import test.FacadeBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
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

    }

}
