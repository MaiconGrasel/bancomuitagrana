<!DOCTYPE html>
<%-- 
    Document   : conta
    Created on : 24/06/2021, 21:50:24
    Author     : Maicon Grasel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.feevale.muitagrana.Transacao"%>
<%@page import="br.feevale.muitagrana.TransacoesDAO"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <title>BMG-Conta</title>
    </head>
    <body>
        <h1>BEM VINDO A SUA CONTA</h1>
        <%
            Integer conta = (Integer)request.getSession().getAttribute("conta");
            TransacoesDAO db = TransacoesDAO.getInstance();
            out.print(db.getTransacoes(conta));
        %>
        
    </body>
</html>
