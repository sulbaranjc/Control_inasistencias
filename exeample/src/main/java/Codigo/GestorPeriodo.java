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
public class GestorPeriodo {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Periodo p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into periodo (nombre) values ('"+ p.getNombre() + "');";
            consulta.executeUpdate(cadena);
    }    
public List<Periodo> listar() throws SQLException {
        ResultSet rs = null;
        List<Periodo> periodos;
        periodos = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM periodo";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Periodo periodo = new Periodo();
                periodo.setId(rs.getInt("id"));
                periodo.setNombre(rs.getString("nombre"));
                periodos.add(periodo);
            }
        return periodos;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Periodo> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Periodo> periodos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM periodo WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
           // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Periodo periodo = new Periodo();
                periodo.setId(rs.getInt("id"));
                periodo.setNombre(rs.getString("nombre"));
                periodos.add(periodo);
            }
        return periodos;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from periodo where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Periodo consultarUn(int id) throws SQLException{
        Periodo periodo = new Periodo();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from periodo WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    periodo.setId(rs.getInt("id"));
                    periodo.setNombre(rs.getString("nombre"));
                }
                return periodo;
    }

    public void modificar(Periodo periodo) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update periodo set nombre='"+periodo.getNombre() + "' where id="+periodo.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}

