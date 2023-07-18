package ar.com.codoacodo.empleado;

public class Empleado {
	private Long dni;  // private actua como public para la clase misma, pero invisible para el resto
	private String nombre;
	private String apellido;
	private Long dpto_id;
	
	public Empleado (Long dni,String nombre,String apellido, Long dpto_id) {
		
		this.dni = dni ;  // el id que esta vacio, va a estar lleno con un dato que viene de un select * from 
		this.nombre = nombre;
		this.apellido = apellido;
		this.dpto_id = dpto_id;
		
		
	}
	//metodos
	public void mostrarDatos() {
		System.out.println("detallando Empleado..");
		System.out.println("Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", dpto_id=" + dpto_id +  "]");
		
	}
	
	public String getNombreEmpleado() {
		return nombre;
	}
	public String getApellidoEmpleado() {
		return apellido;
	}
	public Long getDpto_idEmpleado() {
		return dpto_id;
	}


}
