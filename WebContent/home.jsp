<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
<input type="hidden" value="editar" name="hiddenEdicao">
	<div class="container-contact100">
			<form class="contact100-form validate-form" action="ChamadoServlet">
				<div align="right">
					<a href="sobre.jsp"> Sobre</a>
					<a href="index.jsp" > Sair</a>
				</div>
			
				<span class="contact100-form-title"> Meus Chamados </span>
				<table>
					<tr>
						<th></th>
						<th>N Chamado</th>
						<th>Titulo</th>
						<th>Descricao</th>
						<th>Data abertura</th>
						<th>Status</th>
						<th>Dias aberto</th>
						<th colspan="7">Ação</th>
					</tr>				
					<c:forEach items="${chamados}" var="chamado">	
						<tr>
							<th><input type="radio" name="name_radio" value="${chamado.id}" id="radioButton"><br></th>
							<td><c:out value="${chamado.numchamado}"></c:out></td>
							<td><c:out value="${chamado.titulo}"></c:out></td>
							<td><c:out value="${chamado.descricao}"></c:out></td>
							<td><c:out value="${chamado.dataabertura}"></c:out></td>
							<td><c:out value="${chamado.status}"></c:out></td>
							<td><c:out value="${chamado.diasaberto}"></c:out></td>
							<td><a href="chamadoServlet?hiddenAcao=editar&{user.id}">Editar</a></td>
							<td><a href="chamadoServlet?hiddenAcao=editar&{user.id}">Excluir</a></td>
						</tr>
					</c:forEach>				
				</table>
				
				<br>
				
				<a href="novo.jsp">Novo</a>
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
	

    <script  language="javascript">
    	function exibeMsgExcluir(){
    		
			var choices = [];
			var els = document.getElementsByName('name_radio');
			
			for(var i = 0; i< els.length;i++){
				if(els[i].checked){
					choices.push(els[i].value);
				}
			}
    		
			if(choices.length > 0){
		 		alert("chamar o modal de confirmação");
			}
    		<!-- criar o modal de mensagem -->
    		
    	}
    	/*function editar(){
			var els = document.getElementsByName('name_radio');
			
			for(var i = 0; i< els.length;i++){
				if(els[i].checked){
					pegar via javascript e setar com scriptlet
					var id = els[i].value;*/
					/*}
			}
    	}*/
    	
    </script>	
</body>
</html>