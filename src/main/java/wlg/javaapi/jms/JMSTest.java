package wlg.javaapi.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSTest {
  public static void main(String[] args) throws JMSException {
    new Thread(()->{
      try {
        consumerTopicMsg();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } 
    }).start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
    }
    new Thread(()->{
      try {
        productTopicMsg();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } 
    }).start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e1) {
    }
  }

  private static void consumerTopicMsg() throws JMSException {
    String jmsProviderAddress = "tcp://10.200.78.236:61616";// 地址 
    
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( 
            jmsProviderAddress);// 连接器 

    Connection connection = connectionFactory.createConnection();// 创建连接 

    Session session = connection.createSession(false, 
            Session.AUTO_ACKNOWLEDGE);// 打开会话 

    String destinationName = "demoTopic"; 

    Destination dest = session.createTopic(destinationName);// 消息目的地 

    MessageConsumer consumer = session.createConsumer(dest); 

    connection.start(); 

    Message message = consumer.receive(); 

    TextMessage textMessage = (TextMessage) message; 

    String text = textMessage.getText(); 

    System.out.println("从ActiveMQ取回一条消息: " + text); 

    consumer.close(); 
    session.close(); 
    connection.close();
  }

  private static void productTopicMsg() throws JMSException {
    String jmsProviderAddress = "tcp://10.200.78.236:61616";// 地址 
    
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( 
            jmsProviderAddress);// 连接器 

    Connection connection = connectionFactory.createConnection();// 创建连接 

    Session session = connection.createSession(false, 
            Session.AUTO_ACKNOWLEDGE);// 打开会话 

    Destination dest = session.createTopic("demoTopic");
    MessageProducer producer = session.createProducer(dest);// 消息发送者 

    Message message = session.createTextMessage("hello world");// 消息 

    producer.send(message);// 发送 

    producer.close();// 关闭 
    session.close(); 
    connection.close();
  }
}
