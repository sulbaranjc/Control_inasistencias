/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author sulbaranjc
 */

public class SingletonProfesor {
    private static SingletonProfesor singletonProfesorInstance = null;
    private static GestorProfesor gestorProfesor;
    private static Profesor profesor;
    private static boolean sesion = false;

    private SingletonProfesor() {
        // Evita que se creen instancias de la clase
    }

    public static SingletonProfesor getInstance() {
        if (singletonProfesorInstance == null) {
            singletonProfesorInstance = new SingletonProfesor();
        }
        return singletonProfesorInstance;
    }

      public static GestorProfesor getGestorProfesor() {
        if (gestorProfesor == null) {
            gestorProfesor = new GestorProfesor();
        }
        return gestorProfesor;
    }

    public static void setGestorProfesor(GestorProfesor gestorProfesor) {
        SingletonProfesor.gestorProfesor = gestorProfesor;
        sesion = gestorProfesor != null;
    }

    public static Profesor getProfesor() {
        return profesor;
    }

    public static void setProfesor(Profesor profesor) {
        SingletonProfesor.profesor = profesor;
        sesion = profesor != null;
    }

    public static boolean isSesion() {
        return sesion;
    }

    public static void logoutProfesor() {
        SingletonProfesor.gestorProfesor = null;
        SingletonProfesor.profesor = null;
        SingletonProfesor.sesion = false;
    }
}

