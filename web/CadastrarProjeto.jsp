<%-- 
    Document   : CadastrarProjeto
    Created on : 25/11/2012, 14:40:22
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Projeto</title>
    </head>
    <body>
        <h1>Cadastro de Funcionario</h1>
        <form method="get" action="ServletGlobal">
            <table>
                <tr>
                    <td>
                        <label>Matrícula: </label> &nbsp;
                        <input type="text" name="nr_matricula"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Nome: </label> &nbsp;
                        <input type="text" name="ds_nome"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Data de Nascimento: </label> &nbsp;
                        <input type="text" name="dt_nasc"/>
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
    </body>
</html>
