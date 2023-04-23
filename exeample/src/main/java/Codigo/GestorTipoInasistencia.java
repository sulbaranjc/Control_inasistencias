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
public class GestorTipoInasistencia {
Statement consulta;
    Conexion c = new Conexion();

public void alta(TipoInasistencia p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert tipo_inasistencia (nombre) values ('"+ p.getNombre() +"');";
            consulta.executeUpdate(cadena);
    }    
public List<TipoInasistencia> listar() throws SQLException {
        ResultSet rs = null;
        List<TipoInasistencia> tipoInasistencias;
        tipoInasistencias = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM tipo_inasistencia";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                TipoInasistencia tipoInasistencia = new TipoInasistencia();
                tipoInasistencia.setId(rs.getInt("id"));
                tipoInasistencia.setNombre(rs.getString("nombre"));
                tipoInasistencias.add(tipoInasistencia);
            }
        return tipoInasistencias;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<TipoInasistencia> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<TipoInasistencia> tipoInasistencias = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM tipo_inasistencia WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
            //System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                TipoInasistencia tipoInasistencia = new TipoInasistencia();
                tipoInasistencia.setId(rs.getInt("id"));
                tipoInasistencia.setNombre(rs.getString("nombre"));
                tipoInasistencias.add(tipoInasistencia);
            }
        return tipoInasistencias;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from tipo_inasistencia where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public TipoInasistencia consultarUn(int id) throws SQLException{
        TipoInasistencia tipoInasistencia = new TipoInasistencia();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from tipo_inasistencia WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    tipoInasistencia.setId(rs.getInt("id"));
                    tipoInasistencia.setNombre(rs.getString("nombre"));
                }
                return tipoInasistencia;
    }

    public void modificar(TipoInasistencia tipoInasistencia) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update tipo_inasistencia set nombre='"+tipoInasistencia.getNombre()+"' where id="+tipoInasistencia.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}
