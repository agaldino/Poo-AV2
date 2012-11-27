<%-- 
    Document   : ListarAlocacao
    Created on : 27/11/2012, 14:07:04
    Author     : andre
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Projeto"%>
<%@page import="model.Alocacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lista de Alocações</title>
    </head>
    <body>
        <table>
            <thead style="text-align: center">
            <th>Código do projeto</th>
            <th>    Nome do projeto</th>
            <th>    Funcionario</th>
            <th>    Data de Alocacao</th>
            </thead>
        <%
            List<Alocacao> al = (List<Alocacao>) request.getAttribute("alocacoes");
            for(Alocacao a:al){
            Projeto p = a.getProjeto();
            Funcionario f = a.getFuncionario();
            
        %>
        <tbody>
            <tr style="text-align: center">
                <td>
                    <%=p.getCodprojeto()%> 
                </td>
                <td>
                    <%=p.getNomeprojeto()%>
                </td>
                <td>
                    <%=f.getCodfuncionario()%> - <%=f.getNome()%>
                </td>
                <td>
                    <%=new SimpleDateFormat("yyyy-MM-dd").format(a.getDataalocacao())%>
                </td>
            </tr>
        </tbody>
        <%}%>
        </table>
    </body>
</html>
