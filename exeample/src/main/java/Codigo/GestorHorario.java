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
public class GestorHorario {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Horario p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into horario (nombre) values ('"+ p.getNombre() + "');";
            consulta.executeUpdate(cadena);
    }    
public List<Horario> listar() throws SQLException {
        ResultSet rs = null;
        List<Horario> horarios;
        horarios = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM horario";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId(rs.getInt("id"));
                horario.setNombre(rs.getString("nombre"));
                horarios.add(horario);
            }
        return horarios;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Horario> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Horario> horarios = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM horario WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
           // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId(rs.getInt("id"));
                horario.setNombre(rs.getString("nombre"));
                horarios.add(horario);
            }
        return horarios;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from horario where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Horario consultarUn(int id) throws SQLException{
        Horario horario = new Horario();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from horario WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    horario.setId(rs.getInt("id"));
                    horario.setNombre(rs.getString("nombre"));
                }
                return horario;
    }

    public void modificar(Horario horario) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update horario set nombre='"+horario.getNombre() + "' where id="+horario.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}

