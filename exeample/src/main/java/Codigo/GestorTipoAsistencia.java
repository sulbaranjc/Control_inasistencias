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
public class GestorTipoAsistencia {
Statement consulta;
    Conexion c = new Conexion();

public void alta(TipoAsistencia p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert tipo_asistencia (nombre) values ('"+ p.getNombre() +"');";
            consulta.executeUpdate(cadena);
    }    
public List<TipoAsistencia> listar() throws SQLException {
        ResultSet rs = null;
        List<TipoAsistencia> tipoasistencias;
        tipoasistencias = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM tipo_asistencia";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                TipoAsistencia tipoasistencia = new TipoAsistencia();
                tipoasistencia.setId(rs.getInt("id"));
                tipoasistencia.setNombre(rs.getString("nombre"));
                tipoasistencias.add(tipoasistencia);
            }
        return tipoasistencias;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<TipoAsistencia> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<TipoAsistencia> tipoasistencias = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM tipo_asistencia WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
            //System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                TipoAsistencia tipoasistencia = new TipoAsistencia();
                tipoasistencia.setId(rs.getInt("id"));
                tipoasistencia.setNombre(rs.getString("nombre"));
                tipoasistencias.add(tipoasistencia);
            }
        return tipoasistencias;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from tipo_asistencia where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public TipoAsistencia consultarUn(int id) throws SQLException{
        TipoAsistencia tipoasistencia = new TipoAsistencia();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from tipo_asistencia WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    tipoasistencia.setId(rs.getInt("id"));
                    tipoasistencia.setNombre(rs.getString("nombre"));
                }
                return tipoasistencia;
    }

    public void modificar(TipoAsistencia tipoasistencia) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update tipo_asistencia set nombre='"+tipoasistencia.getNombre()+"' where id="+tipoasistencia.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}
