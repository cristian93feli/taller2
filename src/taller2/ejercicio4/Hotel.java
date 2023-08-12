/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Hotel {

    private int idHotel;
    private String nombreHotel;
    private String ubicacion;
    private List<Habitacion> habitacion = new ArrayList<>();
    private List<Hotel> hotel = new ArrayList<>();

    public Hotel(int idHotel, String nombreHotel, String ubicacion) {
        this.idHotel = idHotel;
        this.nombreHotel = nombreHotel;
        this.ubicacion = ubicacion;
        this.habitacion = new ArrayList<>();
    }

    public Hotel() {
    }

    public void CrearHoteles() {

        Hotel hotel1 = new Hotel(1, "Maria Claudia", "Bogota");
        hotel1.agregarHabitacion(new Habitacion("102", true));
        hotel1.agregarHabitacion(new Habitacion("103", true));
        hotel1.agregarHabitacion(new Habitacion("104", true));
        hotel1.agregarHabitacion(new Habitacion("201", true));
        hotel1.agregarHabitacion(new Habitacion("202", true));
        hotel1.agregarHabitacion(new Habitacion("203", true));
        hotel1.agregarHabitacion(new Habitacion("204", true));
        hotel1.agregarHabitacion(new Habitacion("205", true));

        Hotel hotel2 = new Hotel(2, "Mistico", "Girardot");
        hotel2.agregarHabitacion(new Habitacion("102", true));
        hotel2.agregarHabitacion(new Habitacion("103", true));
        hotel2.agregarHabitacion(new Habitacion("104", true));
        hotel2.agregarHabitacion(new Habitacion("201", true));
        hotel2.agregarHabitacion(new Habitacion("202", true));
        hotel2.agregarHabitacion(new Habitacion("203", true));
        hotel2.agregarHabitacion(new Habitacion("204", true));
        hotel2.agregarHabitacion(new Habitacion("205", true));

        Hotel hotel3 = new Hotel(3, "Paseo Real", "Villleta");
        hotel3.agregarHabitacion(new Habitacion("102", true));
        hotel3.agregarHabitacion(new Habitacion("103", true));
        hotel3.agregarHabitacion(new Habitacion("104", true));
        hotel3.agregarHabitacion(new Habitacion("201", true));
        hotel3.agregarHabitacion(new Habitacion("202", true));
        hotel3.agregarHabitacion(new Habitacion("203", true));
        hotel3.agregarHabitacion(new Habitacion("204", true));
        hotel3.agregarHabitacion(new Habitacion("205", true));

        Hotel hotel4 = new Hotel(4, "Escorpion plaza", "Manizales");
        hotel4.agregarHabitacion(new Habitacion("102", true));
        hotel4.agregarHabitacion(new Habitacion("103", true));
        hotel4.agregarHabitacion(new Habitacion("104", true));
        hotel4.agregarHabitacion(new Habitacion("201", true));
        hotel4.agregarHabitacion(new Habitacion("202", true));
        hotel4.agregarHabitacion(new Habitacion("203", true));
        hotel4.agregarHabitacion(new Habitacion("204", true));
        hotel4.agregarHabitacion(new Habitacion("205", true));

        hotel.add(hotel1);
        hotel.add(hotel2);
        hotel.add(hotel3);
        hotel.add(hotel4);

    }

    public void agregarHabitacion(Habitacion nuevaHabitacion) {
        habitacion.add(nuevaHabitacion);
    }

    public int mostrarinfoHotel() {
        StringBuilder mensajeHoteles = new StringBuilder();

        for (int i = 0; i < hotel.size(); i++) {
            mensajeHoteles.append(hotel.get(i).idHotel)
                    .append("  ")
                    .append(hotel.get(i).nombreHotel)
                    .append("   ")
                    .append(hotel.get(i).ubicacion)
                    .append("\n");
        }

        return Integer.parseInt(JOptionPane.showInputDialog("Estos son los hoteles disponibles \n\n\n" + "Ingrese el Id del Hotel, el "
                + "cual desea consultar o crear una reserva \n\n\n" + mensajeHoteles.toString()
                + "5. Salir"));
    }

    public void mostrarInformacionHabitacion(int idHotel) {
        StringBuilder mensajeHoteles = new StringBuilder();
        for (int j = 0; j < hotel.get(idHotel - 1).habitacion.size(); j++) {
            System.out.println(hotel.get(idHotel - 1).habitacion.get(j).isDisponible());
            if (hotel.get(idHotel - 1).habitacion.get(j).isDisponible() == true) {
                                     
                        String prueba = hotel.get(idHotel - 1).habitacion.get(j).isDisponible()==true
                                ?"Disponible":"Ocupada";
                        
                
                mensajeHoteles.append(hotel.get(idHotel - 1).habitacion.get(j).getNumeroHabitacion())
                        .append("  ")
                        .append(prueba)
                        .append("\n");

            }

        }
        JOptionPane.showMessageDialog(null, "Estas son las habitaciones disponibles \n\n\n"
                + mensajeHoteles.toString());

    }

    public String modificarEstadoHabitacion(int opcionesHotel) {
    boolean reservaHecha = false;
        String opcionHabitacion = JOptionPane.showInputDialog("Ingrese el numero de habitacion"
                + " a reservar");
        for (int i = 0; i < hotel.get(opcionesHotel - 1).getHabitacion().size(); i++) {

            if (hotel.get(opcionesHotel - 1).getHabitacion().get(i).isDisponible() == true
                    && hotel.get(opcionesHotel - 1).getHabitacion().get(i).getNumeroHabitacion()
                            .equals(opcionHabitacion)) {

                hotel.get(opcionesHotel - 1).getHabitacion().get(i).setDisponible(false);
                reservaHecha = true;
                break;
            }
            
        }
        opcionHabitacion = reservaHecha ? opcionHabitacion : null;
        System.out.println("revisando datos");
        return opcionHabitacion;
    }
    
    public void activarHabitacion(List<Object> infoHabitacionActivar){
        for(int i = 0; i < hotel.get(Integer.parseInt(String.valueOf(infoHabitacionActivar.get(0))))
                .getHabitacion().size(); i++)
        if(
            hotel.get(Integer.parseInt(String.valueOf(infoHabitacionActivar.get(0))))
                .getHabitacion().get(i).getNumeroHabitacion().equals(infoHabitacionActivar.get(1)))
        {
         hotel.get(Integer.parseInt(String.valueOf(infoHabitacionActivar.get(0))))
                .getHabitacion().get(i).setDisponible(true);
        }
       
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Habitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(List<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
