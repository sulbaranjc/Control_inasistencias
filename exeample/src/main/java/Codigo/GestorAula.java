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
public class GestorAula {
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Aula p) throws SQLException{
            consulta = c.conectar().createStatement();
            String cadena = "insert into aula (nombre) values ('"+ p.getNombre() + "');";
            consulta.executeUpdate(cadena);
    }    
public List<Aula> listar() throws SQLException {
        ResultSet rs = null;
        List<Aula> aulas;
        aulas = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM aula";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Aula aula = new Aula();
                aula.setId(rs.getInt("id"));
                aula.setNombre(rs.getString("nombre"));
                aulas.add(aula);
            }
        return aulas;
    }
private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Aula> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Aula> aulas = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM aula WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+";";
           // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Aula aula = new Aula();
                aula.setId(rs.getInt("id"));
                aula.setNombre(rs.getString("nombre"));
                aulas.add(aula);
            }
        return aulas;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from aula where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Aula consultarUn(int id) throws SQLException{
        Aula aula = new Aula();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from aula WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    aula.setId(rs.getInt("id"));
                    aula.setNombre(rs.getString("nombre"));
                }
                return aula;
    }

    public void modificar(Aula aula) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update aula set nombre='"+aula.getNombre() + "' where id="+aula.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}

