<%-- 
    Document   : CadastrarFuncionario
    Created on : 20/11/2012, 13:24:26
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                        <input type="text" name="ds_especialidade"/>
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
                        <label>Sexo</label> &nbsp;
                        <input type="radio" name="sex" value="M"/>
                        <input type="radio" name="sex" value="F"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Salario</label> &nbsp;
                        <input type="text" name="nr_salario"/>
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
    </body>
</html>
