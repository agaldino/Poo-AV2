<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Manager</title>
    </head>
    <body>
        <h3>Esta, será a página inicial com opções de redirecionamento para cadastro e etc</h3>
        
        <div ID="navegation">
            <a href="ServletGlobal?acao=CadastrarFuncionario">Cadastrar Funcionário</a> 
            <br/>
            <br/>
            <a href="ServletGlobal?acao=CadastrarProjeto">Cadastrar Projetos</a>
            <br/>
            <br/>
            <a href="ServletGlobal?acao=listFunc">Listar Funcionarios</a>
            <br/>
            <br/>
            <a href="ServletGlobal?acao=listProj">Listar Projetos</a>
        </div>
</html>