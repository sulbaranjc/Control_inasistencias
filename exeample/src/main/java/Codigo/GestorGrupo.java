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
public class GestorGrupo {
    
     Statement consulta;
    Conexion c = new Conexion();

public void alta(Grupo p) throws SQLException{
            consulta = c.conectar().createStatement(); // IdTurno
            String cadena = "insert into grupo (nombre,id_fp, id_turno) values ('"+ p.getNombre() + "',"+p.getIdFp()+ "',"+p.getIdTurno()+")";
            consulta.executeUpdate(cadena);
    }    

public List<Grupo> listar() throws SQLException {
        ResultSet rs = null;
        List<Grupo> grupos;
        grupos = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT grupo.*, fp.nombre as fp_nombre FROM grupo, fp WHERE grupo.fp_id = fp.id ORDER BY fp.nombre;";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(rs.getInt("id"));
                grupo.setNombre(rs.getString("nombre"));
                grupo.setIdFp(rs.getInt("fp_id"));
                grupo.setNombreFpId(rs.getString("fp_nombre"));
                grupos.add(grupo);
            }
        return grupos;
    }

public List<Grupo> getGruposPorProfesor(int idProfesor) throws SQLException {
        ResultSet rs = null;
        List<Grupo> grupos;
        grupos = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM grupo;";
        rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(rs.getInt("id"));
                grupo.setNombre(rs.getString("nombre"));
                grupo.setIdFp(rs.getInt("fp_id"));
                grupo.setNombreFpId(rs.getString("fp_nombre"));
                grupos.add(grupo);
            }
        return grupos;
    }


private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
public List<Grupo> listarFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Grupo> grupos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT gru.*, fp.nombre AS fp_nombre, "+
                    "periodo.nombre AS periodo_nombre, "+
                    "modalidad.nombre AS modalidad_nombre, "+
                    "turno.nombre AS turno_nombre "+
                    "FROM grupo AS gru, fp, periodo, turno, modalidad  "
                    + "WHERE "
                    +" gru.id_fp = fp.id "
                    +" AND gru.id_modalidad = modalidad.id "
                    +" AND gru.id_turno = turno.id "
                    + "AND gru.id_periodo = periodo.id "
                    + "AND (gru.id = "+convertirANumero(filtro)
                    +" OR fp.nombre like '%"+filtro+"%'"+" OR gru.nombre like '%"+filtro+"%'"+") "
                    + "ORDER BY fp.nombre;";
            // String cadena = "SELECT * FROM grupo ";
            // System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(rs.getInt("id"));
                grupo.setNombre(rs.getString("nombre"));
                grupo.setIdFp(rs.getInt("id_fp"));
                grupo.setNombreFpId(rs.getString("fp_nombre"));
                grupo.setNombrePeriodoId(rs.getString("periodo_nombre"));
                grupo.setNombreTurnoId(rs.getString("turno_nombre"));
                grupo.setNombreModalidadId(rs.getString("modalidad_nombre"));
                grupos.add(grupo);
            }
        return grupos;
    }
        public void eliminar(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from grupo where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
public Grupo consultarUn(int id) throws SQLException{
        Grupo grupo = new Grupo();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select asg.*, fp.nombre as fp_nombre FROM grupo AS asg , fp WHERE asg.fp_id = fp.id and asg.id=" + id +";";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    grupo.setId(rs.getInt("id"));
                    grupo.setNombre(rs.getString("nombre"));
                    grupo.setIdFp(rs.getInt("fp_id"));
                    grupo.setNombreFpId(rs.getString("fp_nombre"));
                }
                return grupo;
    }

public void modificar(Grupo grupo) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update grupo set nombre='"+grupo.getNombre()+"', fp_id="+grupo.getIdFp()+" where id="+grupo.getId();
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
}
    
public void getGruposPorProfesor(Grupo grupo) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update grupo set nombre='"+grupo.getNombre()+"', fp_id="+grupo.getIdFp()+" where id="+grupo.getId();
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
}
    


}
