package com.it355.metcourses.messaging;

import com.it355.model.Asistent;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Component("messageSender")
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Asistent asistent) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws
                    JMSException {
                ObjectMessage objectMessage
                        = session.createObjectMessage(asistent);
                return objectMessage;
            }
        });
    }
}
