<%-- 
    Document   : valida_conta
    Created on : 20/06/2021, 23:24:40
    Author     : Maicon Grasel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.feevale.muitagrana.TransacoesDAO"%>
<%
    Integer conta = Integer.parseInt(request.getParameter("conta"));
    TransacoesDAO db = TransacoesDAO.getInstance();
    Integer result = db.validaConta(conta);
    
    if( result == 1 ){
        response.sendRedirect("index.html");
    }else{
        response.sendRedirect("testejsp.jsp");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMG - Verificando conta...</title>
    </head>
    <body>
        <h1>Estamos verificando sua conta, você será redirecionado em...</h1>
    </body>
</html>
