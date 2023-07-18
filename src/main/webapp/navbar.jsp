<!Doctype html>
<html>
<head>
		 <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Navegador</title>
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">  
	</head>
	<body>
<nav class="navbar navbar-expand-sm bg-info navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/portada.jsp">CRUD</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">Inicio</a>
        </li>
        
        <li class="nav-item dropdown">
		  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Listado</a>
		  <ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/FindAllDepartamentoController">Listado de Departamentos</a></li>
		    <li><hr class="dropdown-divider"></li>
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/FindAllEmpleadoController">Listado de Empleados</a></li>
		  </ul>
		</li>
		
		<li class="nav-item dropdown">
		  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Nuevo</a>
		  <ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/nuevo.jsp">Nuevo Departamento</a></li>
		    <li><hr class="dropdown-divider"></li>		    
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/nuevoEmpleado.jsp">Nuevo Empleado</a></li>
		  </ul>
		</li>
       
      </ul>
      <div class="d-flex w-75 justify-content-end">
	      <div class="d-flex w-45 me-4 justify-content-end"> 
		      <form class="d-flex" action="<%=request.getContextPath()%>/SearchDepartamentoController">
			        <input  name="claveBusqueda"  class="form-control me-2" type="search" placeholder="Buscar Nombre Depto" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Buscar</button>
		      </form> 
		      
		      
	      </div>
	      <div class="d-flex w-45 justify-content-end"> 
		      <form class="d-flex" action="<%=request.getContextPath()%>/SearchEmpleadoController">
			        <input  name="claveBusqueda"  class="form-control me-2" type="search" placeholder="Buscar DNI Empleado" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Buscar</button>
		      </form> 
	      </div>
      </div>
    </div>
  </div>
</nav>
</body>

<main>
</main>
</html>