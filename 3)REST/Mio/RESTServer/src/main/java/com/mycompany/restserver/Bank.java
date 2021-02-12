/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserver;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author studente
 */

@Path("/Bank")
@Produces("text/xml")
public class Bank {
    
    private Map<Integer, BankAccount> accounts;

    
    public Bank() {
        this.accounts = new HashMap<Integer, BankAccount>();
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public BankAccount getAccount(int key){
        return accounts.get(key);
    }
    
    
   @GET
   @Path("")
   public AccountEntries MikGranMaestro(){
       
       Iterator<Entry<Integer, BankAccount>> itAcc = accounts.entrySet().iterator();
        List<AccountEntry> res = new ArrayList<AccountEntry>();
        Entry<Integer, BankAccount> ae;
        while(itAcc.hasNext()){
            ae = itAcc.next();
            res.add(new AccountEntry(ae.getKey(), ae.getValue().toString()));
        }
        return new AccountEntries(res);
    }
   
   /*
       List<AccountEntry> list = new ArrayList<>();
       
      Iterator it = accounts.entrySet().iterator();
      
      while(it.hasNext()){
          Map.Entry values = (Map.Entry) it.next();
          int key = (int) values.getKey();
          
          BankAccount account = (BankAccount) values.getValue();
          
          String nome = account.getHolder().toString();
          
          AccountEntry entry = new AccountEntry(key, nome);
          list.add(entry);
          
      }
      
      AccountEntries listavera = new AccountEntries(list);
       return listavera;
       
   }*/
   
   
   @GET
   @Path("{id}")
   public BankAccount MikMedioMaestro(@PathParam("id")int id){
       BankAccount acc = new BankAccount("nome", "cognome");
       return acc;
       
   }
   
   
   @POST
   @Path("")
   public Response AddAccountMik(BankAccount accountNuovo) {
      Iterator<BankAccount> itAcc = accounts.values().iterator();
        while(itAcc.hasNext()){
            if(accountNuovo.equals(itAcc.next())){
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        accounts.put(accounts.size()+1, accountNuovo);
        return Response.ok(accountNuovo).build();
    }
   
   
   @Path("{id}/ueila")
   public AccountEntry Prova(@PathParam("id")int id){
       AccountEntry acc = new AccountEntry(999, "cognome2");
       return acc;
       
   }
    
    
    
}
