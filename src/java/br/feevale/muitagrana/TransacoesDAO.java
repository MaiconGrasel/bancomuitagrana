package br.feevale.muitagrana;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Maicon Grasel
 */
public final class TransacoesDAO {
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
        } catch (SQLException e) {
           // e.printStackTrace();
        }
    }
    
    
    private TransacoesDAO(){
        connect();
    }
    
    public String getTransacoes(Conta conta){

        String result = "";
        BigDecimal total = new BigDecimal(0.0);
        Transacao tr = new Transacao();
        String sql = "SELECT * FROM SISOP.T_TRANSACOES WHERE CONTA_ID = ? ORDER BY 4 DESC";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, conta.getIdConta());
            ResultSet rs = pstmt.executeQuery();
            result = "<table>"
                    + "<tr>"
                    +"<th>CONTA</th><th>MONTANTE</th><th>DATA</th><th>ORIGEM</th>"
                    + "</tr>";
            while (rs.next()){
                tr.setContaId(rs.getInt("CONTA_ID"));
                tr.setContaDestion(rs.getInt("ID_ORIGEM"));
                tr.setMontante(rs.getBigDecimal("MONTANTE"));
                total = total.add(tr.getMontante());
                tr.setDate(rs.getDate("DATA").toLocalDate());
                
                result +="<tr>"
                            +"<td>"+tr.getContaID().toString()+"</td>"
                            +"<td>"+tr.getMontante().toString()+"</td>"
                            +"<td>"+tr.getData().toString()+"</td>"
                            +"<td>"+tr.getDestinoID().toString()+"</td>"
                        +"</tr>";
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        result += "</table>";
        result = "<table>"
                    +"<th>Saldo Atual : "+total.toString()+"</th>"
                +"</table>"
                +"<table>"
                    +"<th>Extrato de movimentações</th>"
                +"</table>"
                +result;
        return result;
   
    }
     
    public void setTransacao(Conta destino, Conta origem,String strmtt){
        
        BigDecimal mtt = new BigDecimal(strmtt);
        String sql = "INSERT INTO SISOP.T_TRANSACOES (CONTA_ID, ID_ORIGEM, MONTANTE, DATA)"
                   + "VALUES(?,?,?,CURRENT_DATE)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, destino.getIdConta());
            pstmt.setInt(2, origem.getIdConta());
            pstmt.setBigDecimal(3, mtt);
            pstmt.execute();
        } catch (SQLException e) {
           //e.printStackTrace();
        }
              
    }
      
}
