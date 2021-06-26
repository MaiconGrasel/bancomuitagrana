/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private BigDecimal montante;
    private LocalDate data;
    
    public Transacao(Integer c, BigDecimal m, LocalDate d){
            conta.setIdConta(c);
            montante = m;
            data = d;
    }
    
    public Transacao(){
    }
    
    public Transacao( Transacao x){
        this.conta.setIdConta(x.getConta());
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
    public void setConta(Integer x){
        Conta a = new Conta();
        a.setIdConta(x);
        this.conta = a;
    }
    
    public void setMontante(BigDecimal a){
        this.montante = a;
    }
    
    public void setDate(){
        this.data = LocalDate.now();
    }
    
    public void setDate(LocalDate a){
        this.data = a;
    }
    
    public Integer getConta(){
        return this.conta.getIdConta();
    }
    
    public BigDecimal getMontante(){
        return this.montante;
    }
    public LocalDate getData(){
        return this.data;
    }
}
