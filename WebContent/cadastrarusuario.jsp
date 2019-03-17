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
			<form class="contact100-form validate-form" id="formCadastroUsuario" action="salvarUsuario" method="post">
				
				<div class="wrap-input100 validate-input"
					data-validate="Digite um email">
					<input class="input100" type="text" name="email" value="${user.email}"
						placeholder="Email"> <span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input"
					data-validate="Digite uma Senha">
					<input class="input100" type="password" name="senha" value="${user.senha}"
						placeholder="Senha"> <span class="focus-input100"></span>
				</div>
				
				<div class="container-contact100-form-btn">
					<input  class="contact100-form-btn" type="submit" value="Cadastrar">
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

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>

</body>
</html>