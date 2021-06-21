/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.muitagrana;

import java.sql.Connection;

/**
 *
 * @author Maicon Grasel
 */
public class ContasDAO {
    
    private static ContasDAO instance;
    String url = "jdbc:derby://localhost:1527/banco_muita_grana";
    Connection con;
    
    public static synchronized ContasDAO getInstance(){
       return instance; 
    }    
}
