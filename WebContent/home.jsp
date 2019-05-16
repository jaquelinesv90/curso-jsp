<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import=" java.util.*,
				 java.text.SimpleDateFormat,
				 com.gerenciador.dao.*,
				 com.gerenciador.model.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>

<link rel="stylesheet" href="resources/css/main.css">
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td,th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
a					{
	text-decoration: none;
}

</style>
</head>
<body>
	<div class="container-contact100">
			<form class="contact100-form validate-form" action="ChamadoServlet">
				<div align="right">
					<a href="sobre.jsp"> Sobre</a>
					<a href="logoutServlet"> Sair</a>
				</div>
			
				<span class="contact100-form-title"> Meus Chamados </span>
				<table>
					<tr>
						<th>Nº<br>Chamado</th>
						<th>Título</th>
						<th>Descrição</th>
						<th>Data de<br>abertura</th>
						<th>Status</th>
						<th>Dias em<br>aberto</th>
						<th colspan="7">Ação</th>
					</tr>				
					<c:forEach items="${chamados}" var="chamado">	
						<tr>
							<td><c:out value="${chamado.numchamado}"></c:out></td>
							<td><c:out value="${chamado.titulo}"></c:out></td>
							<td><c:out value="${chamado.descricao}"></c:out></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${chamado.dataabertura}"/></td>
							<td><c:out value="${chamado.status}"></c:out></td>
							<td><c:out value="${chamado.diasaberto}"></c:out></td>
							<td><a href="chamadoServlet?hiddenAcao=editar&param_id=${chamado.id}">Editar</a></td>
							<td><a href="chamadoServlet?hiddenAcao=excluir&param_id=${chamado.id}">Excluir</a></td>
						</tr>
					</c:forEach>				
				</table>
				
				<br>
				
				<a href="chamadoServlet?hiddenAcao=novo">Novo</a>
				<a>Imprimir</a>
			<!--				
				<input type="button" onclick="exibeMsgExcluir()" value="Excluir">
				
 
				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn" style="margin-right: 10px">
						<span><i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Novo </span>
					</button>
 
					<button class="contact100-form-btn" style="margin-right: 10px">
						<span> <i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Excluir
						</span>
					</button>

					<button class="">
						<span> <i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Editar
						</span>
					</button>
						
				</div>
				-->	
			</form>
	</div>
	<div class="alert alert-sucess">
	
		<h3>${mensagem}</h3>
	</div>

    <script  language="javascript">
    
    	
    </script>	
</body>
</html>