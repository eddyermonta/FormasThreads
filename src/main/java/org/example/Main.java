package org.example;

import org.example.control.CalculadorArea;
import org.example.util.Constantes;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main implements Observer {
    private static final AtomicReference<Double> areaAtomic = new AtomicReference<>(0.0);

    public static void getTime(long startTime){
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + executionTime + " milisegundos");
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CalculadorArea areaTrianguloRectangulo = new CalculadorArea(Constantes.TRIANGULO_RECTANGULO);
        CalculadorArea areaRectangulo = new CalculadorArea(Constantes.RECTANGULO);

        Thread hilo1 = new Thread(areaTrianguloRectangulo);
        Thread hilo2 = new Thread(areaRectangulo);

        areaTrianguloRectangulo.addObserver(new Main());
        areaRectangulo.addObserver(new Main());

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("El areaTotal: " + areaAtomic.get());
        getTime(startTime);
    }

    @Override
    public void update(Observable o, Object arg) {
        double area = (double) arg;
        areaAtomic.updateAndGet(currentArea -> currentArea + area);
    }
}
