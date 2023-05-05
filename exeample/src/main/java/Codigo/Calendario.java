/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.sql.Time;
import lombok.Data;

/**
 *
 * @author Michelli Fernanda
 */
@Data
public class Calendario {
  private int id;
  private int idDiaSemana;
  private Time HoraInicio;
  private Time HoraFinal;
}
