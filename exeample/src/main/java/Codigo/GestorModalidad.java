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
 * @author Michelli Fernanda
 */
public class GestorModalidad {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Modalidad p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into modalidad (nombre) values ('"+ p.getNombre() + "');";
            consulta.executeUpdate(cadena);
    }    
public List<Modalidad> listar() throws SQLException {
        ResultSet rs = null;
        List<Modalidad> modalidads;
        modalidads = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM modalidad";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Modalidad modalidad = new Modalidad();
                modalidad.setId(rs.getInt("id"));
                modalidad.setNombre(rs.getString("nombre"));
                modalidads.add(modalidad);
            }
        return modalidads;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Modalidad> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Modalidad> modalidads = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM modalidad WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
           // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Modalidad modalidad = new Modalidad();
                modalidad.setId(rs.getInt("id"));
                modalidad.setNombre(rs.getString("nombre"));
                modalidads.add(modalidad);
            }
        return modalidads;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from modalidad where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Modalidad consultarUn(int id) throws SQLException{
        Modalidad modalidad = new Modalidad();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from modalidad WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    modalidad.setId(rs.getInt("id"));
                    modalidad.setNombre(rs.getString("nombre"));
                }
                return modalidad;
    }

    public void modificar(Modalidad modalidad) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update modalidad set nombre='"+modalidad.getNombre() + "' where id="+modalidad.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}

