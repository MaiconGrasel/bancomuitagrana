package br.feevale.muitagrana;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author Maicon Grasel
 */
public class Transacao {
    private Conta conta;
    private Conta destino;
    private BigDecimal montante;
    private LocalDate data;
    
    
    public Transacao(Integer c, BigDecimal m, LocalDate d){
            conta.setIdConta(c);
            montante = m;
            data = d;
    }
    
    public Transacao(){
    }
    
    public Transacao(Transacao x){
        this.conta = x.getConta();
        this.montante = x.getMontante();
        this.data = x.getData();
    }
    
    public String getTeste(){
        String teste = "";
        String a = this.getConta().toString();
        String b = this.getMontante().toString();
        String c = this.getData().toString();
        teste += a+" "+b+" "+c;
       
        return teste;
    }
    
    public void setConta(Conta x){
        this.conta = x;
    }
    
    public void setContaDestion(Integer x){
        Conta a = new Conta(x);
        this.destino = a;
    }
    
    public void setMontante(BigDecimal a){
        this.montante = a;
    }
    public void setContaId(Integer x) {
        Conta a = new Conta(x);
        this.conta = a;
    }
    
    public void setDate(){
        this.data = LocalDate.now();
    }
    
    public void setDate(LocalDate a){
        this.data = a;
    }
        
    public Conta getConta() {
        return this.conta;
    }
    
    public Integer getContaID() {
        return this.conta.getIdConta();
    }
    
    public BigDecimal getMontante(){
        return this.montante;
    }
    public LocalDate getData(){
        return this.data;
    }
    public Conta getDestino(){
        return this.destino;
    }
    
    public Integer getDestinoID() {
        return this.destino.getIdConta();
    }
}
