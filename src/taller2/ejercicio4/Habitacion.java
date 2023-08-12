/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.ejercicio4;

/**
 *
 * @author crist
 */
public class Habitacion{
    private String numeroHabitacion;
    private boolean disponible;

    public Habitacion(String numeroHabitacion, boolean disponible) {
        this.numeroHabitacion = numeroHabitacion;
        this.disponible = disponible;
    }


    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }


    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
