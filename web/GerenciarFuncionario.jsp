<%-- 
    Document   : CadastrarFuncionario
    Created on : 20/11/2012, 13:24:26
    Author     : vitor
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String mod = request.getParameter("mod");
            if (mod.equals("cad")) {
        %>
        <h1>Cadastro de Funcionario</h1>
        <form method="get" action="ServletGlobal">
            <table>               
                <tr>
                    <td>
                        <label>Nome: </label> &nbsp;
                        <input type="text" name="ds_nome"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Data de Nascimento: </label> &nbsp;
                        <input type="date" name="dt_nasc"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Especialidade: </label> &nbsp;
                        <input type="text" name="ds_espec"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Cargo:</label> &nbsp;
                        <input type="text" name="ds_cargo"/>
                    </td>
                </tr>               
                <tr>
                    <td>
                        <label>Sexo:</label> &nbsp;
                        <input type="radio" name="sex" value="M"/>M
                        <input type="radio" name="sex" value="F"/>F
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Salario:</label> &nbsp;
                        <input type="text" name="nr_salario"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Ativo:</label> &nbsp;
                        <input type="checkbox" name="b_ativo" value="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="acao" value="cadFunc"/>
                        <input type="submit" value="cadastrar"/>
                    </td>
                </tr>
            </table>
        </form>
        <%        } else if(mod.equals("edit")) {
            Funcionario f = (Funcionario) request.getAttribute("funcionario");
        %>
        <h1>Editar Funcionario</h1>
        <form method="get" action="ServletGlobal">
            <table>               
                <tr>
                    <td>
                        <label>Nome: </label> &nbsp;
                        <input type="text" name="ds_nome" value="<%=f.getNome()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Data de Nascimento: </label> &nbsp;
                        <input type="date" name="dt_nasc" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(f.getDatanasc())%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Especialidade: </label> &nbsp;
                        <input type="text" name="ds_espec" value="<%=f.getEspecialidade()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Cargo:</label> &nbsp;
                        <input type="text" name="ds_cargo" value="<%=f.getCargo()%>"/>
                    </td>
                </tr>               
                <tr>
                    <% if (f.getSexo().equals('M')) {%>
                    <td>
                        <label>Sexo:</label> &nbsp;                        
                        <input type="radio" name="sex" value="M" checked/>M                        
                        <input type="radio" name="sex" value="F"/>F                        
                    </td>
                    <%} else {%>
                    <td>
                        <label>Sexo:</label> &nbsp;                        
                        <input type="radio" name="sex" value="M" />M                        
                        <input type="radio" name="sex" value="F" checked/>F                        
                    </td>
                    <%}%>
                </tr>
                <tr>
                    <td>
                        <label>Salario:</label> &nbsp;
                        <input type="text" name="nr_salario" value="<%=f.getSalario()%>"/>
                    </td>
                </tr>
                <tr>
                    <% if(f.getBAtivo().equals(1)){%>
                    <td>
                        <label>Ativo:</label> &nbsp;
                        <input type="checkbox" name="b_ativo" value="true" checked/>
                    </td>
                    <% }else{ %>
                    <td>
                        <label>Ativo:</label> &nbsp;
                        <input type="checkbox" name="b_ativo" value="true"/>
                    </td>
                    <%}%>
                </tr>
                <tr>
                    <td>
                        <input type="HIDDEN" name="editCod" value="<%=f.getCodfuncionario()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="acao" value="editarFuncionario"/>
                        <input type="submit" value="Editar"/>
                    </td>
                </tr>
            </table>
        </form>
        <%
            }
        %>
    </body>
</html>
