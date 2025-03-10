/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 * @author William Bastos
 */
public class PilaCastigos extends PilaGenerica{

    public PilaCastigos() {
        super();
    }
    
    /**
     * Muestra el contenido de la pila de castigos.
     */
    public void mostrarCastigos(){
        System.out.println("Castigos disponibles: ");
        NodoPila temp = getTop();
        while (temp != null){
            System.out.println("El castigo con la descripcion: " + temp.getDescripcion() + " realizara la operacion: " + temp.getOperacion() + " y retrocedera " + temp.getNumero() + " posiciones");
            temp = temp.getSig();
        }
    }
    
    /**
     * Muestra los elementos de la Pila de premios
     */
    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("La pila de castigos esta vacia.");
        } else {
            NodoPila actual = getTop();
            while (actual != null) {
                System.out.println(actual.toString());
                actual = actual.getSig();
            }
        }
    }
}
