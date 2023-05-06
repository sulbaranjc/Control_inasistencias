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
public class GestorTurno {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Turno p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into turno (nombre) values ('"+ p.getNombre() + "');";
            consulta.executeUpdate(cadena);
    }    
public List<Turno> listar() throws SQLException {
        ResultSet rs = null;
        List<Turno> turnos;
        turnos = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM turno";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setId(rs.getInt("id"));
                turno.setNombre(rs.getString("nombre"));
                turnos.add(turno);
            }
        return turnos;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Turno> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Turno> turnos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM turno WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
           // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setId(rs.getInt("id"));
                turno.setNombre(rs.getString("nombre"));
                turnos.add(turno);
            }
        return turnos;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from turno where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Turno consultarUn(int id) throws SQLException{
        Turno turno = new Turno();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from turno WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    turno.setId(rs.getInt("id"));
                    turno.setNombre(rs.getString("nombre"));
                }
                return turno;
    }

    public void modificar(Turno turno) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update turno set nombre='"+turno.getNombre() + "' where id="+turno.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}

