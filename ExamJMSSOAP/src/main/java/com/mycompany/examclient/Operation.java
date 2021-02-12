/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examclient;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;




/**
 *
 * @author studente
 */
public class Operation implements MessageListener{
    
    
    private Properties props;
    private InitialContext intCont;
    private TopicConnectionFactory cf;
    private TopicConnection connection;
    private TopicSession session;
    private Topic destination;
    private TopicSubscriber q_sub;       //order and quotation subscribers
    private String user;

    public Operation(){
        
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            intCont = new InitialContext(props);
            cf = (TopicConnectionFactory) intCont.lookup("ConnectionFactory");
            destination = (Topic) intCont.lookup("dynamicTopics/professors");
           
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            
            q_sub = session.createSubscriber(destination);
            
            q_sub.setMessageListener(this);
            
            connection.start();
        } catch (Exception ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void onMessage(Message msg) {
        TextMessage mess;
        mess = (TextMessage) msg;
        
        //Random randomeGen = new Random();
        try {
            String id = mess.getStringProperty("id");
            float ranking  = mess.getFloatProperty("rank");
            
            
            edu.uniroma1.msecs.soapserver.ExamImplService service = new edu.uniroma1.msecs.soapserver.ExamImplService();
            edu.uniroma1.msecs.soapserver.Exam port = service.getExamImplPort();
            
            edu.uniroma1.msecs.soapserver.Professor result = port.getDetails(id);
            
            
            
            System.out.println("Ricevuto id:" +id+" con ranking "+String.valueOf(ranking)+"..."+"bravo "+result.getName());
            
        } catch (JMSException ex) {
            ex.printStackTrace();
        }    }

   
    
    

}
