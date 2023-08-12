/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import taller2.ejercicio1.SistemaAlumnos;

/**
 *
 * @author crist
 */
public class MenuEjercicio4 {

    List<Hotel> Listahoteles = new ArrayList<>();
      int contador = 0;
            
    public void MenuPrincipal() {
              Cliente cliente = new Cliente();
            Hotel hotel = new Hotel();
            Reserva reservacion = new Reserva();
        int idConsultar;
        boolean bandera = true;
        while (bandera) {


           if(contador < 1){
            cliente.empresasVinculadas();
            hotel.CrearHoteles();
           }
            int opcionesEmpresa = cliente.mostrarInfoEmpresas();
            if(opcionesEmpresa == 5){
            bandera = false;
            break;
            }
            
            int OpcionesHotel = hotel.mostrarinfoHotel();
            if(OpcionesHotel == 5){
            bandera = false;
            MenuPrincipal();
            }
            hotel.mostrarInformacionHabitacion(OpcionesHotel);

            int opcionReserva = Integer.parseInt(JOptionPane.showInputDialog("que desea realizar?n\n\n"
                    + "1. Consultar una reserva \n\n"
                    + "2. Crear Una Reserva \n\n"
                    + "3. Cancelar una reserva \n\n"
                    + "4. Volver Al Menu De inicio"));
            //crear una reserva

            contador ++;

            switch (opcionReserva) {
                case 1:
                    reservacion.consultarReserva(OpcionesHotel);
                    break;
                case 2:
                    String numeroHabitacion = hotel.modificarEstadoHabitacion(OpcionesHotel);
                    if(numeroHabitacion != null){
                    reservacion.crearReserva(hotel.getHotel(), cliente.getDatosEmpresa(), opcionesEmpresa,
                            OpcionesHotel, numeroHabitacion);
                    }
                    break;
                case 3:
                  
                   hotel.activarHabitacion(reservacion.cancelarReserva());
                    break;
                case 4:
                    MenuPrincipal();
                    break;
                case 5:
                    bandera = false;
                    break;
                default:

            }
        }
    }

}
