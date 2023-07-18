<!doctype html>
<html lang="es">
	<head>
		 <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>CRUD</title>
		 <!-- Bootstrap CSS -->
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"> 
	</head>
	<body>
	  <div class="container bg-ligth" style="height:100vh;">
	      <!-- aca va el navbar.jsp -->
		 <jsp:include page="navbar.jsp"/>
		 <h1 class="mt-5 mb-5 text-center">BASE DE DATOS</h1>
		 <!--   
		 <button type="button" class="btn btn-dark mt-5" onclick="verListado()">
		 	Listado de Departamentos
		 	Listado de Empleados
		 </button>-->
		 <div class="container d-flex justify-content-center">
		     <img src="cac.png" class="img-fluid img-thumbnail" alt="...">
		 </div>
	   </div>
	</body>
	
	<script type="text/javascript">
		function verListado(){
			window.location = 'http://localhost:8080/app-web/FindAllDepartamentoController';
			
		}
	</script>
	
	<script type="text/javascript">
		function verListadoEmpleado(){
			window.location = 'http://localhost:8080/app-web/FindAllEmpleadoController';
			
		}
	</script>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</html>