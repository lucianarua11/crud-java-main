package ar.com.codoacodo.dao.implement;

import ar.com.codoacodo.dao.iEmpleadoDAO;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

// la interface List tiene una serie de metodos que son 
// add(elemento)
//remove(elemento)
// me permite trabajar como si fueran vectores dinamicamente como en js, dependiendo de la memoria



// en la clase que creamos, heredamos de una interface, la interfaceDAO que tiene los
//metodos para interactuar con la base
public class EmpleadoDAOMysqlImpl implements iEmpleadoDAO {

	@Override
	public Empleado getById(Long dni)  throws Exception{
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		String sql = "select * from empleados where dni = " + dni;
	   
		Statement statement  = connection.createStatement();
		
		//3 - obtengo el resulSet
		ResultSet resultset = statement.executeQuery(sql);
		// El resultset devuelve un registro de una tabla 
		
	     // primero verifico si hay datos 
		
		if (resultset.next()){
			// obtengo el dato del campo dni
			Long dniBd = resultset.getLong("dni");
			String nombreBd = resultset.getString("nombre");
			String apellidoBd = resultset.getString("apellido");
			Long dpto_idBd = resultset.getLong("dpto_id");
			return new Empleado(dniBd,nombreBd,apellidoBd,dpto_idBd);
			
		}
		cerrar(connection);
		return null; // si no hay resultset entonces no devuelve nada
	}

	
	@Override
	public List<Empleado> findAll() throws Exception {
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
	    String sql = "select * from empleados";
			   
		Statement statement  = connection.createStatement();
				
		//3 - obtengo el resulSet
		ResultSet resultset = statement.executeQuery(sql);
		// El resultset devuelve un registro de una tabla 
				
	     // primero verifico si hay datos 
		    // creo una lista de departamentos
			List<Empleado> empleados = new ArrayList<Empleado>();	
			
			// mientras encontremos resultados de la base 
			while (resultset.next()){
			// obtengo el dato del campo id
			Long dniBd = resultset.getLong("dni");
			String nombreBd = resultset.getString("nombre");
			String apellidoBd = resultset.getString("apellido");
			Long dpto_idBd = resultset.getLong("dpto_id");
			// creamos un empleado y lo agregamos a la lista 
			Empleado d = new Empleado(dniBd,nombreBd,apellidoBd,dpto_idBd);
			empleados.add(d);
					
			}
			cerrar(connection);
		   // devolvemos empleados		
		   return empleados; //
	}

	@Override
	public void delete(Long dni) throws Exception {
	   //-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
	     String sql = "DELETE FROM empleados WHERE DNI=" + dni;
	 	 Statement statement  = connection.createStatement();
	 	//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		  statement.executeUpdate(sql);
		  cerrar(connection);
		 
	}

	@Override
	public void update(Empleado dpto_id) throws Exception {
		// creo un Departamento con los datos modificados del departemento 
		  
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		 String sql = "update empleados set nombre = ?, apellido = ?, dpto_id = ? where dni= ?"  ;
		 PreparedStatement statement  = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setLong(1,dpto_id.getDni());
		 statement.setString(2,dpto_id.getNombre());
	     statement.setString(3,dpto_id.getApellido());
		 statement.setLong(4,dpto_id.getDpto_id());
		 
		//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		 statement.execute();
		
		 cerrar(connection);
	}

	@Override
	public void create(Empleado newDni) throws Exception {
		
        
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		 String sql = "insert into empleados (dni, nombre, apellido, dpto_id) values (?,?,?,?)" ;
		 PreparedStatement statement  = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setLong(1,newDni.getDni());
		 statement.setString(2,newDni.getNombre());
		 statement.setString(3,newDni.getApellido());
		 statement.setLong(4,newDni.getDpto_id());
		//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		 statement.execute();
		 
		 ResultSet res = statement.getGeneratedKeys(); // RETORNA LA KEY QUE SE GENERO
		 if (res.next()) {
			 System.out.println("Se creo el empleado correctamente");
		 }
		 cerrar(connection);
	}
	@Override
	public List<Empleado> search(String clave) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM EMPLEADOS WHERE DNI LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		//setear el valor que va en remplazo del ?
		statement.setString(1, "%" + clave + "%");
		
		// 3 - resultset
		ResultSet resultSet = statement.executeQuery();

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Empleado> dni = new ArrayList<Empleado>();

		// verifico si hay datos
		while (resultSet.next()) {
			dni.add(this.crearEmpleado(resultSet));
		}
		
		cerrar(connection);
		
		return dni;
	}
	
	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	private Empleado crearEmpleado(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo dni
		Long dniDb = resultSet.getLong("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		Long dpto_id = resultSet.getLong("dpto_id");
		

		return new Empleado(dniDb, nombre, apellido, dpto_id);
	}
	
	// implementar el nuevo metodo que busca por el nombre y que devuelve una lista de departamentos

}
