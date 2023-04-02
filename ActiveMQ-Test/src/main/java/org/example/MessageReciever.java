package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageReciever {

    public static void recieveMessage() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // создаем соединение и сессию
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // создаем топик
        Topic topic = session.createTopic("myTopic");

        // создаем получателя сообщений
        MessageConsumer consumer = session.createConsumer(topic);

        connection.start();

        // получаем сообщения
        while (true) {
            Message message = consumer.receive();
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Received message: " + textMessage.getText());
                // проверяем, нужно ли закрыть соединение
                if ("Message 5".equals(textMessage.getText())) {
                    connection.close();
                    break;
                }
            }
        }

        // закрываем соединение
        connection.close();
    }

    public static void main(String[] args) throws JMSException
    {
        MessageReciever.recieveMessage();
    }
}
