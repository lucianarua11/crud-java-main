package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ar.com.codoacodo.dao.iEmpleadoDAO;
import ar.com.codoacodo.dao.implement.EmpleadoDAOMysqlImpl;
import ar.com.codoacodo.domain.Empleado;

@WebServlet("/UpdateEmpleadoController")
public class UpdateEmpleadoController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturo los parametros que viene en el request enviado por el form
		String nombre= req.getParameter("nombre");//name de input
		String dni = req.getParameter("dni");//name de input
		String apellido = req.getParameter("apellido");//name de input
		String dpto_id = req.getParameter("dpto_id");//name de input
		
		//interface = new class que implementa la interface
		iEmpleadoDAO dao = new EmpleadoDAOMysqlImpl();
		
		
		
		Empleado d;
       
		d = new Empleado(Long.parseLong(dni),nombre,apellido,Long.parseLong(dpto_id));
		// si no usamos try catch podemos arriba poner throws Exception
		try { 
			dao.update(d);
			//aca mensaje de exito, PERO COMO UNA LISTA
			req.setAttribute("success", List.of("Empleado dni:" + d.getDni() + " actualizado correctamente"));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Error actualizando Empleado<" + e.getMessage()));
		}
		
		
		//ahora redirect!!!!
	     getServletContext().getRequestDispatcher("/FindAllEmpleadoController").forward(req, resp);
		
		
	}
	
	//cargar el empleado y enviarlo a la jsp que va a editar los datos
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dni = req.getParameter("dni");
			
			// realizar validaciones, para los datos que vienen!!!
			
			//interface = new class que implementa la interface
			iEmpleadoDAO dao = new EmpleadoDAOMysqlImpl();
			
			Empleado d = null;
			//cargo los datos 
			try {
				d = dao.getById(Long.parseLong(dni));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//guardar el producto en request y pasar dicho producto a la jsp
			req.setAttribute("empleado", d);
			
			//redirect
			//ahora redirect!!!!
			getServletContext().getRequestDispatcher("/editarEmpleado.jsp").forward(req, resp);
		}

		
}

