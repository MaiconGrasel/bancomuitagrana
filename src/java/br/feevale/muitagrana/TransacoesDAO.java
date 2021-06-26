/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.muitagrana;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Maicon Grasel
 */
public class TransacoesDAO {
    private Conta conta;
    private static TransacoesDAO instance;
    String ulr = "jdbc:derby://localhost:1527/banco_muita_grana";
    Connection con;
    
    public static synchronized TransacoesDAO getInstance(){
        if (instance == null){
            instance = new TransacoesDAO();
        }
        return instance;
    }
    
    public void connect(){
        try {
            con = DriverManager.getConnection(ulr, "sisop", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private TransacoesDAO(){
        connect();
    }
    
    public Integer validaConta(Integer conta){
        String sql = "SELECT COUNT(ID_CONTA)FROM SISOP.T_CONTAS WHERE ID_CONTA = ?";
        Integer response = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, conta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                response = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
