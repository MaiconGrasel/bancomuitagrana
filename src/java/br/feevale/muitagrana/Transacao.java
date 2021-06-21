/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.muitagrana;

import java.text.DecimalFormat;
import java.util.Date;
import java.time.LocalDate;

/**
 *
 * @author Maicon Grasel
 */
public class Transacao {
    private Conta conta;
    private DecimalFormat montante;
    private LocalDate data;
    
    public Transacao(Conta c, DecimalFormat m, LocalDate d){
            conta = c;
            montante = m;
            data = d;
    }
    
    public void setConta(Conta x){
        this.conta = conta;
    }
    public void setMontante(DecimalFormat a){
        this.montante = a;
    }
    public void setDate(){
        this.data = LocalDate.now();
    }
    public Integer getConta(){
        return this.conta.getIdConta();
    }
    public DecimalFormat getMontante(){
        return this.montante;
    }
    public LocalDate getData(){
        return this.data;
    }
}
