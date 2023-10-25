package net.contador;
import java.io.IOException;

public class Contador {

    public static void main(String[] args) {

        String caracter = args[0];
        String text = args[1];
        int contador = 0;

        for (int i = 0; i < text.length(); i++) {
            if (caracter.equals(String.valueOf(text.charAt(i)))) {
                contador++;
            }
        }
        System.out.println("El texto lleva la '" + caracter + "' " + contador + " veces\n");
    }
}

