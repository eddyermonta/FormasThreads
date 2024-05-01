package org.example.modelo;

import org.example.Formas;

public class Rectangulo implements Formas {
    private double largo;
    private double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }
    @Override
    public double calcularArea() {
        return this.largo * this.ancho;
    }

}
