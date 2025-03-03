package com.mycompany.proyectofinalgrupo8;

import java.util.Scanner;

public class FlujoJuego {
    private int numJugadores, tamPista;
    private Jugador[] jugadoresArray;
    private ColaJugadores colaJugadores;
    private PilaCastigos castigos;
    private PilaPremios premios;

    public FlujoJuego () {
        this.numJugadores = 0;
        this.jugadoresArray = new Jugador[numJugadores];
        this.colaJugadores = new ColaJugadores();
        this.premios = new PilaPremios();
        this.castigos = new PilaCastigos();
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getTamPista() {
        return tamPista;
    }

    public void setTamPista(int tamPista) {
        this.tamPista = tamPista;
    }

    public Jugador[] getJugadoresArray() {
        return jugadoresArray;
    }

    public void setJugadoresArray(Jugador[] jugadoresArray) {
        this.jugadoresArray = jugadoresArray;
    }

    public ColaJugadores getColaJugadores() {
        return colaJugadores;
    }

    public void setColaJugadores(ColaJugadores colaJugadores) {
        this.colaJugadores = colaJugadores;
    }

    public PilaCastigos getCastigos() {
        return castigos;
    }

    public void setCastigos(PilaCastigos castigos) {
        this.castigos = castigos;
    }

    public PilaPremios getPremios() {
        return premios;
    }

    public void setPremios(PilaPremios premios) {
        this.premios = premios;
    }

    //Metodos
    public void llenarColaJugadores() {
        for (Jugador jugador : jugadoresArray) {
            colaJugadores.encolar(jugador);
            System.out.println("El jugador " + jugador.getNombre() + "ha sido agregado a la cola");
        }
    }

    public void llenarPilasBonus() {
        premios.push("+",8,"Cargando premio");
        premios.push("+",2,"Cargando premio");
        premios.push("+",0,"Cargando premio");

        // Lenar pilas castigos
        premios.push("-",3,"Cargando castigo");
        premios.push("-",1,"Cargando castigo");
        premios.push("-",5,"Cargando castigo");
    }
    public boolean hayPremio() {
        return premios.getTop() == null;
    }

    public boolean hayCastigo() {
        return castigos.getTop() == null;
    }
    public int aplicarPremio() {
        if (hayPremio()) {
            System.out.println("La pila de premios esta vacia...");
            return 0;
        } else {
            // Cambiar por premios.pop
            int premio = premios.getTop().getNumero();
            System.out.println("Haz conseguido sacar un numero par se te aplicara un premio");
            System.out.println("Como premio avanzaras " + premio + " veces");
            return premio;
        }
    }

    public int aplicarCastigo() {
        if (hayCastigo()) {
            System.out.println("La pila de castigos esta vacia...");
            return 0;
        } else {
            // cambiar por castigos.pop 
            int castigo = castigos.getTop().getNumero();
            System.out.println("Haz conseguido sacar un numero impar se te aplicara un castigo");
            System.out.println("Como castigo te retrocederas " + castigo + " veces");
            return castigo;
        }
    }

    public void juego() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int totalDa2 = 0;
        Dados da2 = new Dados();
        
        Jugador jugadorTurno = colaJugadores.getFrente().getJugador();
        System.out.println("Jugador: " + jugadorTurno.getNombre() +
                " presione enter para lanzar los dados");
        scanner.nextLine();
        da2.tirar();
        da2.mostrar();
        totalDa2 = da2.getValorDado2() + da2.getValorDado1();
        if (totalDa2 % 2 == 0) {
            jugadorTurno.setPosicion(aplicarPremio());
            colaJugadores.encolar(colaJugadores.desencolar());
        } else {
            jugadorTurno.setPosicion(aplicarCastigo());
            colaJugadores.encolar(colaJugadores.desencolar());
        }
    }


}
