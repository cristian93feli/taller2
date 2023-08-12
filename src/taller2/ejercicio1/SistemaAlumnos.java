/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class SistemaAlumnos extends Alumno {

    private List<SistemaAlumnos> alumnos = new ArrayList<>();

    private int id;



    public void info() {

        int numeroAlumnos = Integer.parseInt(JOptionPane.showInputDialog("cuantos alumnos desea ingresar"));
        for (int i = 0; i < numeroAlumnos; i++) {
             List<Double> calificaciones = new ArrayList<>();
            SistemaAlumnos mensajero = new SistemaAlumnos();

            String nombre = JOptionPane.showInputDialog("ingrese el nombre del alumno numero " + (i + 1));
            int edad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad del alumno"));

            int numeroCalificaciones = Integer.parseInt(JOptionPane.showInputDialog("cuantas calificaciones "
                    + "desea ingrear para el alumno alumno "));

            for (int j = 0; j < numeroCalificaciones; j++) {
                double calificacion = Integer.parseInt(JOptionPane.showInputDialog("ingrese la calificacion numero "
                        + j + 1));
                calificaciones.add(calificacion);
                // notas.add(calificacion);
            }
            id++;
          
            mensajero.setNombre(nombre);
            mensajero.setEdad(edad);
            mensajero.setId(id);
            mensajero.setCalificaciones(calificaciones);
            alumnos.add(mensajero);
        

        }
        menu(alumnos);
    }

    public void menu(List<SistemaAlumnos> alumnos) {
        int idConsultar;
        boolean bandera = true;
        while (bandera) {

            int opciones = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                        Que desea hacer?
                                                                         1. mostrar informacion
                                                                         2. calcular promediode un alumno
                                                                         3. Salir"""));
            switch (opciones) {
                case 1:
                    idConsultar = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del alumno a consultar"));
                    if ((idConsultar - 1) <= alumnos.size()) {
                        InformacionAlumnoIngresado(alumnos.get((idConsultar - 1)));
                    } else {
                        JOptionPane.showMessageDialog(null, "El id ingresado no existe");
                    }
                    break;
                case 2:
                    idConsultar = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del alumno el que"
                            + "desee promediar sus notas"));
                    if ((idConsultar - 1) <= alumnos.size()) {
                        System.out.println("el estudiante " + alumnos.get(idConsultar - 1).getNombre());
                        JOptionPane.showMessageDialog(null, "\"el estudiante \" + alumnos.get(idConsultar - 1).getNombre()");
                        calcularPromedio(alumnos.get(idConsultar - 1).getCalificaciones());
                    } else {
                        JOptionPane.showMessageDialog(null, "El id ingresado no existe");
                    }

                    break;
                case 3:
                    bandera = false;
                    break;
                default:

                // Código a ejecutar si variable no coincide con ningún caso
            }
        }
    }

    public void InformacionAlumnoIngresado(SistemaAlumnos datos) {

        System.out.print(datos.getId() + "\n" + datos.getNombre()
                + "\n" + datos.getEdad() + "\n");
        for (Double calificacion : datos.getCalificaciones()) {
            System.out.print(calificacion + " ");
        }
        System.out.println();

    }

    public void calcularPromedio(List<Double> notas) {
        double promedio = 0;
        for (Double calificacion : notas) {
            promedio = promedio + calificacion;

        }
        promedio = promedio / notas.size();
        System.out.print("tiene un promedio de notas de: " + promedio);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

}
