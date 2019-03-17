<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css">
<style>
a					{
	text-decoration: none;
}

</style>

</head>
<body>

	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="loginServlet" method="post">
				<span class="contact100-form-title"> Gerenciador Pessoal de Chamados </span>
				<span class="contact100-form-subtitle"> Personal tasks manager</span>

				<div class="wrap-input100 validate-input"
					data-validate="Preencha com um email valido">
					<input class="input100" type="text" name="email"
						placeholder="E-mail" value="${usuario.email}"> <span class="focus-input100"></span>
				</div>	

				<div class="wrap-input100 validate-input"
					data-validate="Digite a senha">
					<input class="input100" type="password" name="senha"
						placeholder="Senha" value="${usuario.senha}"> <span class="focus-input100"></span>
				</div>
				<div align="right">
					<a  href="cadastrarusuario.jsp">Cadastrar</a>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span> <i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Logar
						</span>
					</button>
				</div>
				
				
			</form>
		</div>
	</div>
	
</body>
</html>