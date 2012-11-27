<%-- 
    Document   : ListarProjeto
    Created on : 26/11/2012, 19:49:05
    Author     : andre
--%>

<%@page import="model.Projeto"%>
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
            List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
            for (Projeto p : projetos) {
        %>
        
    <li><%=p.getNomeprojeto()%> ( <%=p.getResponsavel()%> ) <a href="ServletGlobal?acao=editProj&id=<%=p.getCodprojeto()%>">Editar</a> &nbsp;
    <a href="ServletGlobal?acao=excluiProj&id=<%=p.getCodprojeto()%>">Excluir</a></li>
    
        <%
            }
        %>
        
        <a href="index.jsp">Voltar</a>
    </body>
</html>
