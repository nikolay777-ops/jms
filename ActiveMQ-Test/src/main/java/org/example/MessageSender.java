package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender {

    public static void sendMessage(String msg) throws JMSException {
    // создаем фабрику подключений
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

    // создаем соединение и сессию
    Connection connection = connectionFactory.createConnection();
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

    // создаем топик
    Topic topic = session.createTopic("myTopic");
    // создаем отправителя сообщений
    MessageProducer producer = session.createProducer(topic);

    // создаем сообщения и отправляем их
    for (int i = 0; i < 10; i++) {
        TextMessage message = session.createTextMessage("Message " + i);
        producer.send(message);
    }

    // закрываем соединение
    connection.close();

    }

    public static void main(String[] args) throws JMSException
    {
        MessageSender.sendMessage("hello");
    }
}
