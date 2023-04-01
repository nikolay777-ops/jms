package org.example;


import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.setProperty(Context.PROVIDER_URL, "http://localhost:9990");
        props.setProperty(Context.SECURITY_PRINCIPAL, "nicko");
        props.setProperty(Context.SECURITY_CREDENTIALS, "nicko");
        InitialContext context = new InitialContext(props);

        try{
            ConnectionFactory connectionFactory = (ConnectionFactory)context.lookup("jms/ConnectionFactory");
            // Создаем Connection
            Connection connection = connectionFactory.createConnection();
        }catch (JMSException e)
        {
            e.printStackTrace();
        }

    }
}