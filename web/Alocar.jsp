<%-- 
    Document   : Alocar
    Created on : 27/11/2012, 13:14:03
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alocar Funcionario x Projeto</title>
    </head>
    <body>
        <h1>Alocar Funcionario x Projeto</h1>
        <form method="get" action="ServletGlobal">
            <table>
                <tr>
                    <td>
                        <label>Código do Projeto </label> &nbsp;
                        <input type="text" name="codProjeto"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Código do Funcionario</label> &nbsp;
                        <input type="text" name="codFuncionario"/>
                    </td>
                </tr>                               
                <tr>
                    <td>
                        <input type="hidden" name="acao" value="alocar"/>
                        <input type="submit" value="Alocar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
