<!Doctype html>
<html>
		<head>
		 <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Nuevo Empleado</title>
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">  
	</head>
	<body>
	   <div class="container bg-light">
	   
	   		<jsp:include page="navbar.jsp"/>
	   </div>
		
		
		<main class="container mt-5">
			<h1>Nuevo Empleado</h1>
			
			<div class="row mt-5">
				<div class="col-12">
					<form class="row g-3 needs-validation" 
						action="<%=request.getContextPath()%>/CreateEmpleadoController"
						method="POST">
					  <div class="col-md-3">
					    <label for="validationCustom01" class="form-label">
					    	DNI
					    </label>
					    <input type="text"
					    	name="dni" 
					    	class="form-control" 
					    	id="validationCustom01" 
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom02" class="form-label">NOMBRE</label>
					    <input type="text"
					    	name="nombre" 
					    	class="form-control" 
					    	id="validationCustom02"
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom02" class="form-label">APELLIDO</label>
					    <input type="text"
					    	name="apellido" 
					    	class="form-control" 
					    	id="validationCustom02"
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom02" class="form-label">DPTO_ID</label>
					    <input type="text"
					    	name="dpto_id" 
					    	class="form-control" 
					    	id="validationCustom02"
					    	value="" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					 
					  <div class="col-12">
					    <button class="btn btn-primary" type="submit">Nuevo</button>
					    <a href="<%=request.getContextPath()%>/FindAllEmpleadoController" class="btn btn-success">Cancelar</a>
					  </div>
					</form>
				</div>
			</div>
		</main>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	
</html>