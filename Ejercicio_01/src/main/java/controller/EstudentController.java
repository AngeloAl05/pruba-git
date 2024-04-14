package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EstudianteModel;

import java.io.IOException;

import entity.Estudiante;

@WebServlet("/ejercicio1")
public class EstudentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nombre");
		String ape = request.getParameter("apellido");
		String edad = request.getParameter("edad");
		String grado = request.getParameter("grado");

		Estudiante objEstudiante = new Estudiante();
		objEstudiante.setNombre(nom);
		objEstudiante.setApellido(ape);
		objEstudiante.setEdad(edad);
		objEstudiante.setGrado(grado);

		EstudianteModel estumo = new EstudianteModel();
		estumo.insertarEstudiante(objEstudiante);
		response.setContentType("application/json;charset=UTF-8");
	}

}
