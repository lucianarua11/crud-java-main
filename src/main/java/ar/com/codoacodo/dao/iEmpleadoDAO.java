package ar.com.codoacodo.dao;

import ar.com.codoacodo.domain.Empleado;
import java.util.List;

public interface iEmpleadoDAO {
	// en esta interface vamos a definir metodos de acceso a la tabla empleados
		// LAS INTERFACES POR SI SOLAS NO HACEN NADA, SOLO ES UNA ESTRUCTURA
		// SE DEBE IMPLEMENTAR EN UNA CLASE, ES DECIR EN UNA CLASE USAMOS ESTOS METODOS QUE DEFINIMOS ACA
		
		/*crud
		 getById()
		 find()
		 delete()
		 update()
		 create()*/
		
		// select * from empleados where DNI = DNI;
		public Empleado getById(Long dni) throws Exception; // devuelve de un DNI todos los campos 
		
		// cambiamos el array por una lista de java 
		// select * from empleados;
		public List<Empleado> findAll() throws Exception;	// devuelve todos los registros de la tabla empleados
		
		
		// delete from empleados where DNI = DNI;
		public void delete(Long dni) throws Exception;// esto borra un registro por el DNI del empleado
		
		
		//update empleados set nombre = nombre, apellido = apellido where DNI = dni;
		public void update(Empleado dni) throws Exception; // se le pasa un objeto 
		
		// insert to empleado (campo 1..campo2..campo3) values(newempleado.campo1....newDepto.campoN)
		public void create(Empleado newDni) throws Exception;
		
		//select * from empleado where titulo like '%clave%' 
	    public List<Empleado> search(String clave) throws Exception;
		
	    
	    
	    
	    
	    // crear un method que consulte a la base por el nombre y que devuelva una lista de departamentos
		// crear un nuevo method que haga update solo al nombre o solo al presupuesto 
		
	}

