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
            String cadena = "insert into grupo (nombre,id_fp, id_turno,id_periodo, id_modalidad) values ('"+ p.getNombre() + "',"+p.getIdFp()+ ","+p.getIdTurno()+ ","+p.getIdPeriodo()+ ","+p.getIdModalidad()+")";
            //System.out.println(cadena);
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


public List<Grupo> listarPorAlumno( int alumnoId) throws SQLException {
        ResultSet rs = null;
        List<Grupo> grupos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT gru.*, fp.nombre AS fp_nombre, "+
                    "periodo.nombre AS periodo_nombre, "+
                    "modalidad.nombre AS modalidad_nombre, "+
                    "turno.nombre AS turno_nombre, "+
                    "alumno_grupo.id AS idgrupoalumno "+
                    "FROM grupo AS gru, fp, periodo, turno, modalidad, alumno_grupo  "
                    + "WHERE "
                    +" gru.id_fp = fp.id "
                    +" AND gru.id_modalidad = modalidad.id "
                    +" AND gru.id_turno = turno.id "
                    + "AND gru.id_periodo = periodo.id "
                    + "AND alumno_grupo.id_grupo = gru.id "
                    + "AND alumno_grupo.id_alumno = "+alumnoId+" "
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
                grupo.setIdGrupoAlumno(rs.getInt("idgrupoalumno"));
                grupos.add(grupo);
            }
        return grupos;
    }


public List<Grupo> listarGruposFiltradosSinAlumno( String filtro, int alumnoId) throws SQLException {
        ResultSet rs = null;
        List<Grupo> grupos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT gru.*, fp.nombre AS fp_nombre, "+
                    "periodo.nombre AS periodo_nombre, "+
                    "modalidad.nombre AS modalidad_nombre, "+
                    "turno.nombre AS turno_nombre "+
                    "FROM grupo AS gru "
                    + "JOIN fp ON gru.id_fp = fp.id "
                    + "JOIN periodo ON gru.id_periodo = periodo.id "
                    + "JOIN turno ON gru.id_turno = turno.id "
                    + "JOIN modalidad ON gru.id_modalidad = modalidad.id "
                    + "WHERE gru.id NOT IN ( "
                    + "SELECT ag.id_grupo "
                    + "FROM alumno_grupo AS ag "
                    + "WHERE ag.id_alumno = "+ alumnoId + " "
                    + ") "
                    + "AND (gru.id = "+convertirANumero(filtro)
                    +" OR fp.nombre like '%"+filtro+"%'"
                    +" OR periodo.nombre like '%"+filtro+"%'"
                    +" OR modalidad.nombre like '%"+filtro+"%'"
                    +" OR turno.nombre like '%"+filtro+"%'"
                    +" OR gru.nombre like '%"+filtro+"%'"+") "
                    + "ORDER BY fp.nombre;";
            // String cadena = "SELECT * FROM grupo ";
            //System.out.println(cadena);
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
                    +" OR fp.nombre like '%"+filtro+"%'"
                    +" OR periodo.nombre like '%"+filtro+"%'"
                    +" OR modalidad.nombre like '%"+filtro+"%'"
                    +" OR turno.nombre like '%"+filtro+"%'"
                    +" OR gru.nombre like '%"+filtro+"%'"+") "
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
            String cadena = "SELECT grp.*,"
                    + " fp.nombre as fp_nombre, "
                    + " periodo.nombre as periodo_nombre, "
                    + " modalidad.nombre as modalidad_nombre, "
                    + " turno.nombre as turno_nombre "
                    + " FROM grupo AS grp , fp, periodo, modalidad, turno"
                    + " WHERE "+" grp.id_periodo = periodo.id "
                    + " AND grp.id_modalidad = modalidad.id "
                    + " AND grp.id_turno = turno.id "
                    + " AND grp.id_fp = fp.id "
                    + " AND grp.id=" + id +";";
            //System.out.println(cadena);
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    grupo.setId(rs.getInt("id"));
                    grupo.setNombre(rs.getString("nombre"));
                    grupo.setIdFp(rs.getInt("id_fp"));
                    grupo.setNombreFpId(rs.getString("fp_nombre"));
                    grupo.setIdPeriodo(rs.getInt("id_periodo"));
                    grupo.setNombrePeriodoId(rs.getString("periodo_nombre"));
                    grupo.setIdTurno(rs.getInt("id_turno"));
                    grupo.setNombreTurnoId(rs.getString("turno_nombre"));
                    grupo.setIdModalidad(rs.getInt("id_modalidad"));
                    grupo.setNombreModalidadId(rs.getString("modalidad_nombre"));
                }
                return grupo;
    }

public void modificar(Grupo grupo) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update grupo set "
                + "nombre='"+grupo.getNombre()+"',"
                +" id_fp="+grupo.getIdFp()+","
                +" id_turno="+grupo.getIdTurno()+","
                +" id_modalidad="+grupo.getIdModalidad()+","
                +" id_periodo="+grupo.getIdPeriodo()
                +" where id="+grupo.getId()+";";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
}
    
//public void getGruposPorProfesor(Grupo grupo) throws SQLException{
//        consulta = c.conectar().createStatement();
//        String cadena = "update grupo set nombre='"+grupo.getNombre()+"', fp_id="+grupo.getIdFp()+" where id="+grupo.getId();
//        //System.out.println(cadena);
//        consulta.executeUpdate(cadena);
//}
    


}
