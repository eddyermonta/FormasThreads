package org.example.modelo;

import org.example.Formas;

public class TrianguloRectangulo implements Formas {
    private double altura;
    private double base;

    public TrianguloRectangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }
    @Override
    public double calcularArea() {
      return  (this.altura * this.base)/2;
    }

}
