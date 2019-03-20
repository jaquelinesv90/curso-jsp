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
.contact100-form-title{
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

    <script type="text/javascript">
    	function voltar(){
    		history.back();
    	}
    </script>
<body>

	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" id="formCadastroChamado" action="chamadoServlet" method="get">
				<input type="hidden" name="hiddenAcao" value="salvar">
				<span class="contact100-form-title">Novo </span>
	
				<div class="wrap-input100 validate-input"
					data-validate="Digite o numero do chamado">
					<input class="input100" type="text" name="numChamado" value="${chamado.numChamado}"
						placeholder="Numero do chamado"> <span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input"
					data-validate="Digite o titulo">
					<input class="input100" type="text" name="titulo" id="titulo"
						placeholder="Titulo" value="${chamado.titulo}"> <span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input"
					data-validate="Digite uma descricao">
					<textarea class="input100" name="descricao" id="descricao"
						placeholder="Descricao" value="${chamado.descricao}"></textarea>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" name="dataAbertura"  value="${chamado.dataAbertura}"
						placeholder="Data de abertura"> <span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" name="status"  value="${chamado.status}"
						placeholder="Status"> <span class="focus-input100"></span>
				</div>
				<select name="listarStatus">
					<c:forEach var="item" items="${chamado.getListStatus}">
						<option value="${item.status}">
					</c:forEach>
				</select>
				
				<!--  
				<select id="selectStatus" class="wrap-input100 validate-input">
					<option class="input100" value="1" selected> Em Aberto</option>
					<option class="input100" value="2"> Em Andamento</option>
					<option class="input100" value="3"> Encerrado</option>
				</select>
				-->
								
				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" name="diasAberto"  value="${chamado.diasAberto}"
						placeholder="Quantidade de dias em aberto"> <span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">

					<button class="contact100-form-btn" style="margin-right: 10px" 
								type="button"  onclick="voltar()">
						<span><i class="fa fa-paper-plane-o m-r-6" 
							aria-hidden="true"></i> Voltar </span>
					</button>
				  
					<button class="contact100-form-btn" type="submit">
						<span> <i class="fa fa-paper-plane-o m-r-6"
							aria-hidden="true"></i> Cadastrar
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>

	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>


</body>
</html>