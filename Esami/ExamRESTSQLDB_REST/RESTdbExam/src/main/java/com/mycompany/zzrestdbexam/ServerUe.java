/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zzrestdbexam;

import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.endpoint.Server;

import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class ServerUe {
    
    
    public static void main(String args[]) throws Exception {

        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(MovieAdapter.class);
        MovieAdapter fr = new MovieAdapter();
        fr.setConnection("/home/studente/Desktop/UEILA");     //NEED TO PUT AS ARGUMENT THE NAME OF PATH OF THE DATABASE /home/student/database
        factoryBean.setResourceProvider(new SingletonResourceProvider(fr));
        factoryBean.setAddress("http://localhost:8080/");

        

        Server server;
        server = factoryBean.create();

        System.out.println("Server ready...");

        while (true) {
        }
    }
    
}
