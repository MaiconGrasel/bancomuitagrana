<!DOCTYPE html>
<%-- 
    Document   : valida_conta
    Created on : 20/06/2021, 23:24:40
    Author     : Maicon Grasel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.feevale.muitagrana.ContasDAO"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>BMG - Verificando conta...</title>
    </head>
    <body>
        <%
        String strct = request.getParameter("conta");
        if (strct.equals("")){
            response.sendRedirect("index.html");
        }else{
            
            Integer conta = Integer.parseInt(request.getParameter("conta"));
            ContasDAO db = ContasDAO.getInstance();
            Integer result = db.validaConta(conta);
          
            if( result == 1 ){
                Thread.sleep(1000);
                session.setAttribute("conta",conta);
                response.sendRedirect("conta.jsp");
            }else{
                
                Thread.sleep(1000);
                response.sendRedirect("index.html");
            };
        }
        %>

    </body>
</html>

