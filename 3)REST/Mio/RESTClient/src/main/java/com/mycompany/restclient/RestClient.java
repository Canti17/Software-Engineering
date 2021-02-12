/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclient;


import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




import javax.ws.rs.client.Client;

/**
 *
 * @author studente
 */
public class RestClient {
     
    
    public static void main(String[] args) throws Exception {
    // Create objects to start comunication with RESTServer
        Client client = ClientBuilder.newClient();
        String baseUrl = "http://localhost:8080/Bank";
        WebTarget webTarget = client.target(baseUrl);
        Invocation.Builder ib = webTarget.request("text/xml");
        Response res, res2, res3, res4, res5;
        
        
         // then print response    //POST
        BankAccount acc = new BankAccount("Mik", "Maestro");
        BankAccount acc2 = new BankAccount("Mik2", "Maestro");
        BankAccount acc3 = new BankAccount("Mik3", "Maestro");
        BankAccount acc4 = new BankAccount("Mik4", "Maestro");
        BankAccount acc5 = new BankAccount("Mik5", "Maestro");
        res=ib.post(Entity.entity(acc, MediaType.TEXT_XML));
        res2=ib.post(Entity.entity(acc2, MediaType.TEXT_XML));
        res3=ib.post(Entity.entity(acc3, MediaType.TEXT_XML));
        res4=ib.post(Entity.entity(acc4, MediaType.TEXT_XML));
        res5=ib.post(Entity.entity(acc5, MediaType.TEXT_XML));
        System.out.println(res.getStatus() +" - " + res.getStatusInfo().getReasonPhrase());
        System.out.println(res2.getStatus() +" - " + res2.getStatusInfo().getReasonPhrase());
        System.out.println(res3.getStatus() +" - " + res3.getStatusInfo().getReasonPhrase());
        System.out.println(res4.getStatus() +" - " + res4.getStatusInfo().getReasonPhrase());
        System.out.println(res5.getStatus() +" - " + res5.getStatusInfo().getReasonPhrase());
        
        
        // Obtain account entries from RESTServer  //GET
        List<Integer> listlist = new ArrayList<>();
        AccountEntries accEnt = ib.accept(MediaType.TEXT_XML).get(AccountEntries.class);
        for (AccountEntry ent : accEnt.getLista()){
            System.out.println(ent.getId());
            listlist.add(ent.getId());
        }
        

        
        
        
        
    }
    
    
    
    
}
