<%-- 
    Document   : valida_conta
    Created on : 20/06/2021, 23:24:40
    Author     : Maicon Grasel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.feevale.muitagrana.TransacoesDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <title>BMG - Verificando conta...</title>
        <%
            Integer conta = Integer.parseInt(request.getParameter("conta"));
            TransacoesDAO db = TransacoesDAO.getInstance();
            Integer result = db.validaConta(conta);
            Thread.sleep(5000);
            if( result == 1 ){
                response.sendRedirect("conta.jsp");
            }else{

                response.sendRedirect("index.html");
            };
    
        %>
    </head>
    <body>
        <h1>Estamos verificando sua conta, você será redirecionado em 5 segs...</h1>
    </body>
    

</html>
