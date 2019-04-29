package test;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "fefEJB")
public class fefBean implements MessageListener {
    public fefBean() {
    }

    @Override
    public void onMessage(Message message) {

    }
}
