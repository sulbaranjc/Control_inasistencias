/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Michelli Fernanda
 */
@Data
public class Asistencia {
    private int id;
    private Date fecha;
    private int idAlumno;
    private int idHorarioDetalle;
    private int idTipoAsistencia;
}
