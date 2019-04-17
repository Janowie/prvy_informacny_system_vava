package client;
import javax.naming.Context;
import javax.naming.InitialContext;

import test.FacadeBeanRemote;

/**
 * Jednoduchy priklad volania stateless session beany (z klient na aplikacny server)
 * na zaklade JNDI
 * 
 * @author Jaroslav Jakubik
 */
public class CallEjb {

	private static final String JNDI = "ejb:04EA/04//FacadeBean!test.FacadeBeanRemote";
	
	public static void main(String[] args) throws Exception {
		Context ctx = new InitialContext();
		FacadeBeanRemote calcFacade = (FacadeBeanRemote) ctx.lookup(JNDI);
		
		System.out.println(calcFacade.doPlus(5, 11, -2));
	}

}
