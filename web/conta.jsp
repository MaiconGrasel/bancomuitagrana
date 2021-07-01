<!DOCTYPE html>
<%-- 
    Document   : conta
    Created on : 24/06/2021, 21:50:24
    Author     : Maicon Grasel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.feevale.muitagrana.Transacao"%>
<%@page import="br.feevale.muitagrana.TransacoesDAO"%>
<%@page import="br.feevale.muitagrana.Conta"%>
<%@page import="br.feevale.muitagrana.ContasDAO"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>BMG-Conta</title>
        <script>
          var option ;  
          function handleClick(opt){
              option = opt.value;
              option > 2 ? (
                document.getElementById("inputDestino").style.display = "block"
              ):(
                document.getElementById("inputDestino").style.display = "none");
          }
          function logout(){
              session.setAttribute("conta","");
          }
          
        </script>
    </head>
    <body>
        <header>
            <h1>BEM VINDO A SUA CONTA</h1>
            <form action="index.html">
                <input type="submit" value="Sair" onsubmit="logout()"><p>
            </form>
        </header>
        <div class="container">
            <form method="post">
                <p>Nova Transacao<p>
                <p>Digite o valor: <input type="number" min="0" step="0.01" name="mtt" placeholder="99.99"><p>
                <p>
                    Depósito:<input type="radio" name="opt" onclick="handleClick(this)" value=1>
                    Saque:<input type="radio" name="opt" onclick="handleClick(this)" value=2>
                    Transferência:<input type="radio" name="opt" onclick="handleClick(this)" value=3>
                <p>
                    
                <div style="display: none;" id="inputDestino">    
                    <p> Conta de Destino:<input type="number" name="destino"><p>
                </div>
                
                <p><input type="submit" value="Realizar Transação"><p>
            </form>

            <%
                ContasDAO cob = ContasDAO.getInstance();
                TransacoesDAO db = TransacoesDAO.getInstance();
                out.print(db.getTransacoes(cob.getConta((Integer)request.getSession().getAttribute("conta"))));
                Integer conta = (Integer)request.getSession().getAttribute("conta");
                String mtt = request.getParameter("mtt");

                if(mtt != null){
                    
                    Integer opt = Integer.valueOf(request.getParameter("opt"));

                    if (opt != 3 && opt != 0){
                        if (opt == 2){
                            mtt = "-"+mtt;
                        }
                        try{

                            db.setTransacao(cob.getConta(conta),cob.getConta(conta), mtt);
                            response.sendRedirect("conta.jsp");

                        }catch(Exception e){

                        }
                    }else if (opt == 3){

                        try{
                            Integer destino = Integer.valueOf(request.getParameter("destino"));
                            db.setTransacao(cob.checkConta(destino), cob.getConta(conta),  mtt);
                            mtt = "-"+mtt;
                            db.setTransacao(cob.getConta(conta), cob.checkConta(destino), mtt);
                            response.sendRedirect("conta.jsp");
                        }catch(Exception e){

                        }
                    }      
                }            
            %>
        </div>
        <footer></footer>>
    </body>
</html>
