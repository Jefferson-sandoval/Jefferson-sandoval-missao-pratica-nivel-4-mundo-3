<%-- 
    Document   : ProdutoDados
    Created on : 31 de mai. de 2024, 15:53:22
    Author     : Jefferson
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Dados do Produto</title>
</head>
<body class="container">
    <h1>Dados do Produto</h1>

    <form action="ServletProdutoFC" method="post" class="form">

        <c:choose>
            <c:when test="${not empty produto}">
                <c:set var="acao" value="alterar"/>
            </c:when>
            <c:otherwise>
                <c:set var="acao" value="incluir"/>
            </c:otherwise>
        </c:choose>

        <input type="hidden" name="acao" value="${acao}"/>

        <c:if test="${acao == 'alterar'}">
            <input type="hidden" name="id" value="${produto.idProduto}"/>
        </c:if>

        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" id="nome" name="nome" value="${produto.nome}" class="form-control" required/>
        </div>

        <div class="mb-3">
            <label for="quantidade" class="form-label">Quantidade:</label>
            <input type="number" id="quantidade" name="quantidade" value="${produto.quantidade}" class="form-control" required/>
        </div>

        <div class="mb-3">
            <label for="precovenda" class="form-label">Preço de Venda:</label>
            <input type="text" id="precovenda" name="precovenda" value="${produto.precovenda}" class="form-control" required/>
        </div>
        
        <input type="submit" value="${acao == 'incluir' ? 'Adicionar Produto' : 'Alterar Produto'}" class="btn btn-primary"/>
    </form>
</body>
</html>