<%-- 
    Document   : ListarFuncionario
    Created on : 26/11/2012, 18:19:12
    Author     : andre
--%>

<%@page import="model.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Funcionarios</h1>
        <%
            List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("funcionarios");
            for (Funcionario f : funcionarios) {
        %>
        
    <li><%=f.getNome()%> ( <%=f.getEspecialidade()%> ) </li>
    
        <%
            }
        %>
</body>
</html>
