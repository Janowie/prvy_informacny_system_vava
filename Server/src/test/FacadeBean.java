package test;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Facade beana, ktora prevola executivnu beanu pre vykonanie konkretnej logiky
 * Na facade je implementovane remote rozhranie aby vybrane metody (v tomto pripade
 * iba doPlus) boli k dispozicii pre ostatnych klientov.
 * 
 * @author Jaroslav Jakubik
 *
 */
@Stateless
public class FacadeBean implements FacadeBeanRemote {

	@EJB
	private ExecutiveBean exe;
	
    public int doPlus(int a, int b, int c) {
    	//log
    	int result = exe.doPlus(exe.doPlus(a, b), c);
    	//log result
    	return result;
    }

}
