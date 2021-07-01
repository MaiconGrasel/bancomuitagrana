package br.feevale.muitagrana;

/**
 *
 * @author Maicon Grasel
 */
public class Conta {
    private Integer idConta;
       
    public Conta(Integer idconta){
        this.idConta = idconta;
    };
    
    public void setIdConta(Integer idconta){
        this.idConta = idconta;
    };
    public Integer getIdConta(){
        return this.idConta;
    };

}

