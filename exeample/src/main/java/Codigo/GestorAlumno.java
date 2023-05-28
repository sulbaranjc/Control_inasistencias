/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sulbaranjc
 */
public class GestorAlumno {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Alumno p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into alumno(nombre,apellido,correo) values ('"+ p.getNombre() + "','"+p.getApellido()+ "','"+p.getCorreo()+"')";
            consulta.executeUpdate(cadena);
    }    
public List<Alumno> listar() throws SQLException {
        ResultSet rs = null;
        List<Alumno> alumnos;
        alumnos = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM alumno";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setCorreo(rs.getString("correo"));
                alumnos.add(alumno);
            }
        return alumnos;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Alumno> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM alumno WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+" OR "+"apellido like '%"+filtro+"%'"+" OR "+"correo like '%"+filtro+"%'";
            //String cadena = "SELECT * FROM alumno ";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setCorreo(rs.getString("correo"));
                alumnos.add(alumno);
            }
        return alumnos;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from alumno where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Alumno consultarUn(int id) throws SQLException{
        Alumno alumno = new Alumno();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from alumno WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    alumno.setId(rs.getInt("id"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setCorreo(rs.getString("correo"));
                }
                return alumno;
    }

    public void modificar(Alumno alumno) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update alumno set nombre='"+alumno.getNombre()+"', apellido='"+alumno.getApellido()+"', correo='"+alumno.getCorreo()+"'"+" where id="+alumno.getId();
        // System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }

        public void altaAlumnoGrupo(int alumnoId, int grupoId) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into alumno_grupo(id_grupo,id_alumno) values ("+ grupoId + ","+alumnoId+ ");";
            // System.out.println(cadena);
            consulta.executeUpdate(cadena);
    }    

        public void eliminarAlumnoGrupo(int id) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "delete from alumno_grupo WHERE id = "+id+";";
            // System.out.println(cadena);
            consulta.executeUpdate(cadena);
    }    
        
    
}
