package com.it355.metcourses.messaging;

import javax.jms.JMSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Component
public class MessageReceiver {

    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers = message.getHeaders();
        LOG.info("Application : headers received : {}", headers);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
