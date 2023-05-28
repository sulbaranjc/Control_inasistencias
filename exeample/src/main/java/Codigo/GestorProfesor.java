/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sulbaranjc
 */
public class GestorProfesor {
    
Statement consulta;
    Conexion c = new Conexion();
    
public void alta(Profesor p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into profesor(nombre,apellido,correo, telefono,contrasena) values ('"+ p.getNombre() + "','"+p.getApellido()+ "','"+p.getCorreo()+ "','"+p.getTelefono()+ "','"+p.getContrasena()+"')";
            //System.out.println(cadena);
            consulta.executeUpdate(cadena);
    }    
public List<Profesor> listar() throws SQLException {
        ResultSet rs = null;
        List<Profesor> profesorList;
        profesorList = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM profesor ORDER BY nombre";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setTelefono(rs.getString("telefono"));
                profesorList.add(profesor);
            }
        return profesorList;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Profesor> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Profesor> profesorList = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM profesor WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+" OR "+"apellido like '%"+filtro+"%'"+" OR "+"correo like '%"+filtro+"%' ORDER BY nombre;";
            //String cadena = "SELECT * FROM profesor ";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setTelefono(rs.getString("telefono"));
                profesorList.add(profesor);
            }
        return profesorList;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from profesor where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Profesor consultarUn(int id) throws SQLException{
        Profesor profesor = new Profesor();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from profesor WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    profesor.setId(rs.getInt("id"));
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setApellido(rs.getString("apellido"));
                    profesor.setCorreo(rs.getString("correo"));
                    profesor.setTelefono(rs.getString("telefono"));
                    profesor.setContrasena(rs.getString("contrasena"));
                }
                return profesor;
    }

    public void modificar(Profesor profesor) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update profesor set nombre='"+profesor.getNombre()+"', apellido='"+profesor.getApellido()+"', correo='"+profesor.getCorreo()+"', telefono='"+profesor.getTelefono()+"', contrasena='"+profesor.getContrasena()+"'"+" where id="+profesor.getId();
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }


    public Profesor autenticarProfesor(Profesor prof) throws SQLException {
    Profesor profesor = null;
    ResultSet rs = null;
    consulta = c.conectar().createStatement();
    String cadena = "SELECT * FROM profesor WHERE correo='" + prof.getCorreo() + "' AND contrasena='" + prof.getContrasena() + "'";
    rs = consulta.executeQuery(cadena);
    if (rs.next()) {
        profesor = new Profesor();
        profesor.setId(rs.getInt("id"));
        profesor.setNombre(rs.getString("nombre"));
        profesor.setApellido(rs.getString("apellido"));
        profesor.setCorreo(rs.getString("correo"));
        profesor.setTelefono(rs.getString("telefono"));
        profesor.setContrasena(rs.getString("contrasena"));
    }
    return profesor;
}
    
 
}
