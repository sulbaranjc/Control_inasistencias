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
public class GestorFp {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Fp p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into fp (nombre,descripcion) values ('"+ p.getNombre() + "','"+p.getDescripcion()+"')";
            consulta.executeUpdate(cadena);
    }    
public List<Fp> listar() throws SQLException {
        ResultSet rs = null;
        List<Fp> fps;
        fps = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM fp";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Fp fp = new Fp();
                fp.setId(rs.getInt("id"));
                fp.setNombre(rs.getString("nombre"));
                fp.setDescripcion(rs.getString("descripcion"));
                fps.add(fp);
            }
        return fps;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Fp> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Fp> fps = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM fp WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+" OR "+"descripcion like '%"+filtro+"%'"+";";
           // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Fp fp = new Fp();
                fp.setId(rs.getInt("id"));
                fp.setNombre(rs.getString("nombre"));
                fp.setDescripcion(rs.getString("descripcion"));
                fps.add(fp);
            }
        return fps;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from fp where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Fp consultarUn(int id) throws SQLException{
        Fp fp = new Fp();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from fp WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    fp.setId(rs.getInt("id"));
                    fp.setNombre(rs.getString("nombre"));
                    fp.setDescripcion(rs.getString("descripcion"));
                }
                return fp;
    }

    public void modificar(Fp fp) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update fp set nombre='"+fp.getNombre()+"', descripcion='"+fp.getDescripcion()+"' where id="+fp.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}
