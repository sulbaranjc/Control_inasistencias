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
public class GestorAsignatura {
    
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Asignatura p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into asignatura (nombre,fp_id) values ('"+ p.getNombre() + "',"+p.getFpId()+")";
            consulta.executeUpdate(cadena);
    }    

public List<Asignatura> listar() throws SQLException {
        ResultSet rs = null;
        List<Asignatura> asignaturas;
        asignaturas = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT asignatura.*, fp.nombre as fp_nombre FROM asignatura, fp WHERE asignatura.fp_id = fp.id ORDER BY fp.nombre;";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setId(rs.getInt("id"));
                asignatura.setNombre(rs.getString("nombre"));
                asignatura.setFpId(rs.getInt("fp_id"));
                asignatura.setNombreFpId(rs.getString("fp_nombre"));
                asignaturas.add(asignatura);
            }
        return asignaturas;
    }

public List<Asignatura> getAsignaturasPorProfesor(int idProfesor) throws SQLException {
        ResultSet rs = null;
        List<Asignatura> asignaturas;
        asignaturas = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM asignatura;";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setId(rs.getInt("id"));
                asignatura.setNombre(rs.getString("nombre"));
                asignatura.setFpId(rs.getInt("fp_id"));
                asignatura.setNombreFpId(rs.getString("fp_nombre"));
                asignaturas.add(asignatura);
            }
        return asignaturas;
    }


private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Asignatura> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Asignatura> asignaturas = new ArrayList<>();
            consulta = c.conectar().createStatement();
        //String cadena = "SELECT asignatura.*, fp.nombre as fp_nombre FROM asignatura, fp WHERE asignatura.fp_id = fp.id ORDER BY fp.nombre;";
            String cadena = "SELECT asg.*, fp.nombre AS fp_nombre FROM asignatura AS asg, fp "
                    + "WHERE "+" asg.fp_id = fp.id "
                    + "and (asg.id = "+convertirANumero(filtro)
                    +" OR fp.nombre like '%"+filtro+"%'"+" OR asg.nombre like '%"+filtro+"%'"+") "
                    + "ORDER BY fp.nombre;";
            //String cadena = "SELECT * FROM asignatura ";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setId(rs.getInt("id"));
                asignatura.setNombre(rs.getString("nombre"));
                asignatura.setFpId(rs.getInt("fp_id"));
                asignatura.setNombreFpId(rs.getString("fp_nombre"));
                asignaturas.add(asignatura);
            }
        return asignaturas;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from asignatura where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Asignatura consultarUn(int id) throws SQLException{
        Asignatura asignatura = new Asignatura();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select asg.*, fp.nombre as fp_nombre FROM asignatura AS asg , fp WHERE asg.fp_id = fp.id and asg.id=" + id +";";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    asignatura.setId(rs.getInt("id"));
                    asignatura.setNombre(rs.getString("nombre"));
                    asignatura.setFpId(rs.getInt("fp_id"));
                    asignatura.setNombreFpId(rs.getString("fp_nombre"));
                }
                return asignatura;
    }

public void modificar(Asignatura asignatura) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update asignatura set nombre='"+asignatura.getNombre()+"', fp_id="+asignatura.getFpId()+" where id="+asignatura.getId();
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
}
    
public void getAsignaturasPorProfesor(Asignatura asignatura) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update asignatura set nombre='"+asignatura.getNombre()+"', fp_id="+asignatura.getFpId()+" where id="+asignatura.getId();
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
}
    


}
