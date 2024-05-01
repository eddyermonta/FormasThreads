package org.example.control;

import org.example.Formas;
import org.example.modelo.Rectangulo;
import org.example.modelo.TrianguloRectangulo;
import org.example.util.Constantes;
import java.util.Observable;

public class CalculadorArea extends Observable implements Runnable  {

    private final int tipo;
    private double areaTotalFiguras;
    private final Formas trianguloIzquierdo, trianguloDerecho, rectanguloCentro, rectanguloDerecho;
    public CalculadorArea(int tipo) {
        this.tipo = tipo;
        this.trianguloIzquierdo = new TrianguloRectangulo(12,10);
        this.trianguloDerecho = new TrianguloRectangulo(5,2);
        this.rectanguloCentro = new Rectangulo(12,8);
        this.rectanguloDerecho = new Rectangulo(5,6);
        this.areaTotalFiguras = 0;
    }

    @Override
    public void run() {
        switch (this.tipo){

            case Constantes.TRIANGULO_RECTANGULO:
                areaTotalFiguras+= this.trianguloIzquierdo.calcularArea() + this.trianguloDerecho.calcularArea();
                System.out.println("area total resultado hilo triangulos rectangulos :" +areaTotalFiguras);
                break;

            case Constantes.RECTANGULO:
                areaTotalFiguras+= this.rectanguloCentro.calcularArea() + this.rectanguloDerecho.calcularArea();
                System.out.println("area total resultado hilo rectangulos :" +areaTotalFiguras);
                break;

        }
        this.setChanged();
        this.notifyObservers(areaTotalFiguras);
        this.clearChanged();
    }
}
