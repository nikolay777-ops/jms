package org.example;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * This class is used to send a text message to the queue.
 */
public class Main
{

    /*
     * URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
     *
     * default broker URL is : tcp://localhost:61616"
     */
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    /*
     * Queue Name.You can create any/many queue names as per your requirement.
     */
    private static String queueName = "MESSAGE_QUEUE";

    public static void main(String[] args) throws JMSException
    {
        MessageReciever.recieveMessage();
        MessageSender.sendMessage("hello");


    }
}
