package br.feevale.muitagrana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Maicon Grasel
 */
public class ContasDAO {

    private static ContasDAO instance;
    String url = "jdbc:derby://localhost:1527/banco_muita_grana";
    Connection con;
    
    public static synchronized ContasDAO getInstance(){
        
        if (instance == null) {
            instance = new ContasDAO();
        }
       return instance;
    }
    
    public void connect(){
        try {
            con = DriverManager.getConnection(url, "sisop", "123456");
        }catch (SQLException e){
            //e.printStackTrace();
        }
    }
    
    private ContasDAO(){
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
    
    public Conta checkConta(Integer conta) {
        String sql = "SELECT ID_CONTA FROM SISOP.T_CONTAS WHERE ID_CONTA = ?";
        Conta a = new Conta(conta);
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, conta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               a.setIdConta(rs.getInt(1));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return a;
    }
    
    public Conta getConta(Integer idconta){
        Conta conta = new Conta(idconta);
        return conta;
    };
    
}
