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
public class Reserva {

    private int id;
    private Cliente cliente;
    private Hotel hotel;
    private List<Reserva> listaReserva = new ArrayList<>();

    public Reserva(int id, Cliente cliente, Hotel hotel) {
        this.id = id;
        this.cliente = cliente;
        this.hotel = hotel;
    }

    Reserva() {
    }

    public void crearReserva(List<Hotel> listaHoteles, List<Cliente> listaCliente, int opcionesEmpresa,
            int opcionesHotel, String numeroHabitacion) {
        Cliente cliente2 = new Cliente();
        Hotel datosHotel2 = new Hotel();

        ++id;
        cliente2.setNombreEmpleado(JOptionPane.showInputDialog("Ingrese el nombre del empleado"));
        cliente2.setCedulaEmpleado(JOptionPane.showInputDialog("Ingrese la cedula del empleado"));
        cliente2.setNombreEmpresa(listaCliente.get(opcionesEmpresa - 1).getNombreEmpresa());
        cliente2.setNitEmpresa(listaCliente.get(opcionesEmpresa - 1).getNitEmpresa());

        datosHotel2.setIdHotel(listaHoteles.get(opcionesHotel - 1).getIdHotel());
        datosHotel2.setNombreHotel(listaHoteles.get(opcionesHotel - 1).getNombreHotel());
        datosHotel2.setUbicacion(listaHoteles.get(opcionesHotel - 1).getUbicacion());

        datosHotel2.agregarHabitacion(new Habitacion(numeroHabitacion, false));

        Reserva nuevaReserva = new Reserva(id, cliente2, datosHotel2);

        listaReserva.add(nuevaReserva);
    }

    public void consultarReserva(int opcionesHotel) {
        StringBuilder mensajeroReserva = new StringBuilder();
        for (int i = 0; i < listaReserva.size(); i++) {

            if (listaReserva.get(i).hotel.getIdHotel() == (opcionesHotel)) {
                mensajeroReserva.append(listaReserva.get(i).id)
                        .append("\nNombre:")
                        .append(listaReserva.get(i).cliente.getNombreEmpleado())
                        .append("\nCedula:")
                        .append(listaReserva.get(i).cliente.getCedulaEmpleado())
                        .append("\nNombre de la Empresa:")
                        .append(listaReserva.get(i).cliente.getNombreEmpresa())
                        .append("\nNumero de Habitacion")
                        .append(listaReserva.get(i).hotel.getHabitacion().get(0).getNumeroHabitacion())
                        .append("\n\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, (mensajeroReserva.toString()));
    }

    public List<Object> cancelarReserva() {
        List<Object> infoHotel = new ArrayList<>();
        int indiceAEliminar = Integer.parseInt(JOptionPane.showInputDialog("ingrese por favor el id "
                + "de reserva a eliminar"));
      //  indiceAEliminar = indiceAEliminar - 1;
      //  listaReserva.get(indiceAEliminar).getHotel().getHabitacion().get(0).getNumeroHabitacion();

        
        
        for(int i = 0; i < listaReserva.size(); i++){
        
            if(listaReserva.get(i).id == indiceAEliminar){
             infoHotel.add(listaReserva.get(i).getHotel().getIdHotel()-1);
              infoHotel.add(listaReserva.get(i).getHotel().getHabitacion().get(0).getNumeroHabitacion());
            listaReserva.remove(i);
            System.out.println("Registro eliminado con éxito.");
            }
        }

        return infoHotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

}
