package test;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ExecutiveBean {

    public int doPlus(int a, int b) {

        System.out.println("VOLOLO");

        return a + b;
    }
}
