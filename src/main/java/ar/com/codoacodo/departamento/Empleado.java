package ar.com.codoacodo.departamento;

public class Empleado {
	
	int dni;
	String nombre;
	String apellido;
	Departamento dpto_id;

    public Empleado(int dni,String nombre,String apellido,Departamento dpto_id) {
    	this.dni = dni;
    	this.nombre = nombre ;
    	this.apellido = apellido;
    	this.dpto_id = dpto_id ;
    	
    	
    }
    
  //metodos
  	public void mostrarDatos() {
  		System.out.println("detallando Empleado..");
  		System.out.println("Dni:" + dni);
  		System.out.println("Nombre:" + nombre);
  		System.out.println("Apellido:" + apellido);
  
  		this.dpto_id.mostrarDatos();
  		
  		
  		
  	}
  	public void setDpto_id(Departamento dpto_id) {
  		this.dpto_id = dpto_id;
  		
  	}
  	
    public void mostrarNombreDeptoDeEmpleado() {
    	System.out.println("Nombre Depto de Empleado:" + this.dpto_id.getNombreDpto_id());
    	
    }
	
}
