<%-- 
    Document   : CadastrarProjeto
    Created on : 25/11/2012, 14:40:22
    Author     : andre
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Projeto</title>
    </head>
    <body>
        <%
            String mod = request.getParameter("mod");
            if (mod.equals("cad")) {
        %>
        <h1>Cadastro de Projeto</h1>
        <form method="get" action="ServletGlobal">
            <table>
                <tr>
                    <td>
                        <label>Nome do Projeto </label> &nbsp;
                        <input type="text" name="ds_nome"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Financiador </label> &nbsp;
                        <input type="text" name="ds_financiador"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Data de Inicio: </label> &nbsp;
                        <input type="date" name="dt_Inicio"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Investimento: </label> &nbsp;
                        <input type="text" name="nr_investimento"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Responsavel: </label> &nbsp;
                        <input type="text" name="ds_responsavel"/>
                    </td>
                </tr>                
                <tr>
                    <td>
                        <input type="hidden" name="acao" value="cadProj"/>
                        <input type="submit" value="cadastrar"/>
                    </td>
                </tr>
            </table>
        </form>
        <%        } else if (mod.equals("edit")) {
            Projeto p = (Projeto) request.getAttribute("projeto");
        %>
        <h1>Editar Projeto</h1>
        <form method="get" action="ServletGlobal">
            <table>
                <tr>
                    <td>
                        <label>Nome do Projeto: </label> &nbsp;
                        <input type="text" name="ds_nome" value="<%=p.getNomeprojeto()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Financiador: </label> &nbsp;
                        <input type="text" name="ds_financiador" value="<%=p.getFinanciado()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Data de Inicio: </label> &nbsp;
                        <input type="date" name="dt_Inicio" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(p.getDtinicio())%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Investimento: </label> &nbsp;
                        <input type="text" name="nr_investimento" value="<%=p.getInvestimento()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Responsavel: </label> &nbsp;
                        <input type="text" name="ds_responsavel" value="<%=p.getResponsavel()%>"/>
                    </td>
                </tr>      
                 <tr>
                    <td>
                        <input type="HIDDEN" name="editCod" value="<%=p.getCodprojeto()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="acao" value="editarProjeto"/>
                        <input type="submit" value="Editar"/>
                    </td>
                </tr>
            </table>
        </form>
        <%}%>
    </body>    
</html>
