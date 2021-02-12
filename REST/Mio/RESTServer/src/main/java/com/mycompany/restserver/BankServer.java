/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserver;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class BankServer {
    
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(Bank.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new Bank()));
        factoryBean.setAddress("http://localhost:8080");
        Server server=factoryBean.create();
    }
    
}
