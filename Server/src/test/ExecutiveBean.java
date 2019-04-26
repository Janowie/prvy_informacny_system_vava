package test;


import entity.blah;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ExecutiveBean {

    public int doPlus(int a, int b) {

        blah meh = new blah("petrik");
        System.out.println("VOLOLO");

        return a + b;
    }
}
