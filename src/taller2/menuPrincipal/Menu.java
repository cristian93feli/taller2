/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.menuPrincipal;

import javax.swing.JOptionPane;
import taller2.ejercicio1.SistemaAlumnos;
import taller2.ejercicio2.MenuConversionMoneda;
import taller2.ejercicio3.Calculadora;
import taller2.ejercicio4.MenuEjercicio4;

/**
 *
 * @author crist
 */
public class Menu {

    public void ejecutarMenu() {

        boolean bandera = true;
        while (bandera) {

            int opciones = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                        Que ejercicio desea ver?
                                                                         1. Ejercicio 1
                                                                         2. Ejercicio 2
                                                                         3. Ejercicio 3
                                                                         4. Ejercicio 4
                                                                         5. Salir"""));
            switch (opciones) {
                case 1:
                    SistemaAlumnos ejercicio1 = new SistemaAlumnos();
                    ejercicio1.info();
                    break;
                case 2:
                    MenuConversionMoneda ejercicio2 = new MenuConversionMoneda();
                    ejercicio2.ejecutarPrograma();
                    break;
                case 3:
                    Calculadora calculadora = new Calculadora();
                    calculadora.ejecutarCalculadora();
                    break;
                case 4:
                    MenuEjercicio4 menu = new MenuEjercicio4();
                    menu.MenuPrincipal();
                    break;
                case 5:
                    bandera = false;
                    break;
                default:

               
            }
        }
    }
}
