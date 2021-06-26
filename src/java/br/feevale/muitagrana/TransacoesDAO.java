/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.muitagrana;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return response;
    }
    public String getTransacoes(Integer conta){
        String result = "";
        BigDecimal total = new BigDecimal(0.0);
        Transacao tr = new Transacao();
        String sql = "SELECT * FROM SISOP.T_TRANSACOES WHERE CONTA_ID = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, conta);
            ResultSet rs = pstmt.executeQuery();
            result = "<table>"
                    + "<tr>"
                    +"<th>CONTA</th><th>MONTANTE</th><th>DATA</th>"
                    + "</tr>";
            while (rs.next()){
                tr.setConta(rs.getInt("CONTA_ID"));
                tr.setMontante(rs.getBigDecimal("MONTANTE"));
                total = total.add(tr.getMontante());
                tr.setDate(rs.getDate("DATA").toLocalDate());
                result +="<tr>"
                            +"<td>"+tr.getConta().toString()+"</td>"
                            +"<td>"+tr.getMontante().toString()+"</td>"
                            +"<td>"+tr.getData().toString()+"</td>"
                        +"</tr>";
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        result += "</table>";
        result = "<table>"
                    +"<th>Saldo Atual : "+total.toString()+"</th>"
                +"</table>"
                +result;
        return result;
   
    }
}
