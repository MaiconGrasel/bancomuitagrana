<%-- 
    Document   : testejsp
    Created on : 20/06/2021, 22:22:58
    Author     : Maicon Grasel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.feevale.muitagrana.Transacao"%>
<%@page import="br.feevale.muitagrana.TransacoesDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>VAI CARAI</h1>
        <%
            TransacoesDAO db = TransacoesDAO.getInstance();
            out.print(db.getTeste());
        %>
    </body>
</html>
