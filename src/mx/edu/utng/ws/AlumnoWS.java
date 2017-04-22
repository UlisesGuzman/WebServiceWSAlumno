package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoWS {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;
	
	public AlumnoWS() {
		conectar();
	}
	
	private void conectar(){
		
		try {
			Class.forName("org.postgresql.Driver");
			 connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/wstst",
					"postgres","urito12");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public int addAlumno(Alumno alumno){
		int result = 0;
		if(connection!=null){
			try {
				ps = connection.prepareStatement(
						"INSERT INTO Alumno(matricula, notas, fecha_alta, becado, grupo, generacion, nombre)"
						+"VALUES (?, ?, ?, ?, ?, ?, ?);");
				ps.setString(1, alumno.getMatricula());
				ps.setString(2, alumno.getNotas());
				ps.setString(3, alumno.getFechaAlta());
				ps.setBoolean(4, alumno.isBecado());
				ps.setString(5, alumno.getGrupo());
				ps.setInt(6, alumno.getGeneracion());
				ps.setString(7, alumno.getNombre());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int editAlumno(Alumno alumno){
		int result = 0;
		if(connection!=null){
			try {
				ps = connection.prepareStatement(
						"UPDATE alumno SET matricula=?,"
						+ "notas=?,"
						+ "fecha_alta=?,"
						+ "becado=?,"
						+ "grupo=?,"
						+ "generacion=?,"
						+ "nombre=?"
						+ "WHERE cve_universidad =?;");
				ps.setString(1, alumno.getMatricula());
				ps.setString(2, alumno.getNotas());
				ps.setString(3, alumno.getFechaAlta());
				ps.setBoolean(4, alumno.isBecado());
				ps.setString(5, alumno.getGrupo());
				ps.setInt(6, alumno.getGeneracion());
				ps.setString(7, alumno.getNombre());
				ps.setInt(8, alumno.getCveUniversidad());
				result = ps.executeUpdate();
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		return result;
	}
	
	public int removeAlumno(int cveUniversidad){
		int result = 0;
		if(connection!=null){
			try {
				ps = connection.prepareStatement(
						"DELETE FROM Alumno WHERE cve_universidad =?;");
				ps.setInt(1, cveUniversidad);
				result = ps.executeUpdate();
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		return result;
	}
	
	public Alumno[] getAlumnos(){
		Alumno[] result = null;
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		if(connection!=null){
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(
						"SELECT * FROM alumno;");
				while(resultSet.next()){
					Alumno alumno = new Alumno(
							resultSet.getInt("cve_universidad"),
							resultSet.getString("matricula"),
							resultSet.getString("notas"),
							resultSet.getString("fecha_alta"),
							resultSet.getBoolean("becado"),
							resultSet.getString("grupo"),
							resultSet.getInt("generacion"),
							resultSet.getString("nombre"));
					
					alumnos.add(alumno);
				
				}
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		result = alumnos.toArray(new Alumno[alumnos.size()]);
		return result;
	}
	
	public Alumno getAlumnoById(int cveUniversidad){
		Alumno alumno = null;
		
		if(connection!=null){
			try {
				ps = connection.prepareStatement("SELECT * FROM alumno WHERE cve_universidad= ?");
				ps.setInt(1, cveUniversidad);
				resultSet = ps.executeQuery();
						
				if(resultSet.next()){
					alumno = new Alumno(
							resultSet.getInt("cve_universidad"),
							resultSet.getString("matricula"),
							resultSet.getString("notas"),
							resultSet.getString("fecha_alta"),
							resultSet.getBoolean("becado"),
							resultSet.getString("grupo"),
							resultSet.getInt("generacion"),
							resultSet.getString("nombre"));
					
				
				}
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		return alumno;
	}
}

