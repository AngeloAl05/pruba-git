package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Estudiante;
import util.MySqlDBConexion;

public class EstudianteModel {
	
	public int insertarEstudiante(Estudiante obj){
		Connection conn=null;
		PreparedStatement pstm=null;
		int salida = -1;
		try {
			conn = MySqlDBConexion.getConexion();
			
			String sql ="insert into estudiante values(null,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getEdad());
			pstm.setString(4, obj.getGrado());
			System.out.println("SQL >>"+pstm);
			salida = pstm.executeUpdate();
			System.out.println("SQL Insertados >>"+salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm!=null) pstm.close(); 
				if (conn!=null) conn.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
		
	}
}
