<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema</title>

<link rel="stylesheet" href="resources/css/main.css">
</head>

<style type="text/css">
.contact100-form-title {
	text-align: left;
	text-transform: unset;
}

.container-contact100 {
	justify-content: left;
}

.wrap-contact100 {
	width: 550px;
	background: transparent;
	padding: 25px 0px 160px 0px;
}
</style>

<body>

	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action="home.jsp">
				<span class="contact100-form-title"> Sobre o sistema</span>
				
				<div>
					<span><i class="fa fa-paper-plane-o m-r-6"
								aria-hidden="true"></i> Desenvolvido com JSP,JDBC, SERVLETS,
								HTML, JAVASCRIPT, POSTGRESQL
							</span>
				</div>
				<div>
					<span><i class="fa fa-paper-plane-o m-r-6"
								aria-hidden="true"></i> Desenvolvido por: Jaqueline L.
							</span>	
				</div>	
				<div>
					<span><i class="fa fa-paper-plane-o m-r-6"
								aria-hidden="true"></i> Contato: jaquelinesv90@gmail.com
							</span>	
				</div>			
				<br>
				<div>
					<span><i class="fa fa-paper-plane-o m-r-6"
								aria-hidden="true"></i>  Data da ultima atualização:
							</span>	
				</div>
				<div>
					<button class="contact100-form-btn">
						<span> <i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Voltar
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>