
package taller2.ejercicio3;




public class Division extends OperacionMatematica {

    @Override
    public double calcular(double numero1, double numero2) {
        if (numero2 != 0) {
            return numero1 / numero2;
        } else {
            throw new IllegalArgumentException("No es posible dividir entre cero.");
        }
    }

}
