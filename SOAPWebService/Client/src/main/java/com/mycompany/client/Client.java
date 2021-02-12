/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import java.util.ArrayList;

/**
 *
 * @author studente
 */
public class Client {
    
    public static void main(String[] args){
        
        try { // Call Web Service Operation
            com.mycompany.aaaws.AAAWSImplService service = new com.mycompany.aaaws.AAAWSImplService();
            com.mycompany.aaaws.AAAWSInterface port = service.getAAAWSImplPort();
            // TODO process result here
            java.util.List<java.lang.String> resultGetCli = port.getClients();
            
            ArrayList<Integer> idbuoni = new ArrayList<Integer>();
            ArrayList<String> soluzione = new ArrayList<String>();
                   
            // Call Web Service Operation
            com.mycompany.bankws.BankImplService serviceBank = new com.mycompany.bankws.BankImplService();
            com.mycompany.bankws.BankInterface portBank = serviceBank.getBankImplPort();
            
            for(String s:resultGetCli){
                String work = s.substring(0, 1);
                String name = s.substring(3);
                int workwork = Integer.parseInt(work);
                java.util.List<java.lang.String> resultGetOp = portBank.getOperationsByClientID(workwork);
                
                
                
                for(String ss: resultGetOp){
            
                    int ssInt = Integer.parseInt(ss);
                    
                    java.lang.String resultgetDet = portBank.getOperationDetailsByID(ssInt);
                
                    
                    int prova = resultgetDet.indexOf("benzina autostrada");
                    if(prova != -1){
                        soluzione.add(name);
                       
                    }
                    
                }            
                
            }
          
            
            
            
        
     
            
            
            
            System.out.println("Result = "+soluzione);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        
        
        
        

    }
    
    
    

    
    
}
