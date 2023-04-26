package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {

    private String codigo;
    private String origen;
    private String destino;
    private Integer capacidad;
    List<Pasajero> pasajeros;

    public Vuelo() {
        this.codigo = "";
        this.origen = "";
        this.destino = "";
        this.capacidad = 0;

        this.pasajeros = new ArrayList<>();
    }

    public Vuelo(String codigo, String origen, String destino, Integer capacidad) {

        /*===========================Alternativa I ========================*/

        /*Hay que verificar primero los null, no se puede verificar ls longitud hasta que no se haga esto*/
        boolean codigoEsNull = codigo == null;

        if (codigoEsNull) {
            throw new IllegalArgumentException("Codigo no puede ser null");
        }

        boolean origenEsNull = origen == null;

        if (origenEsNull) {
            throw new IllegalArgumentException("Origen no puede ser null");
        }

        boolean destinoEsNull = destino == null;

        if (destinoEsNull) {
            throw  new IllegalArgumentException("Destino no puede ser null");
        }
        

        boolean codigoEsVacio = codigo.isEmpty(); //Esto verifica los strings.

        if (codigoEsVacio) {
            throw new IllegalArgumentException("Codigo no puede ser un string vacío");
        }
        boolean origenEsVacio = origen.isEmpty(); //Esto verifica los strings.

        if (origenEsVacio) {
            throw new IllegalArgumentException("Origen no puede ser un string vacío");
        }
        
        boolean destinoEsVacio = destino.isEmpty(); //Esto verifica los strings.

        if (destinoEsVacio) {
            throw new IllegalArgumentException("Destino no puede ser un string vacío");
        }

        boolean capacidadEsNegativa = capacidad < 0;

        if (capacidadEsNegativa) {
            throw new IllegalArgumentException("Capacidad no puede ser negativa");
        }

        /*===========================Alternativa II ========================*/
        /*
        boolean codigoEsNull = codigo == null;
        boolean origenEsNull = origen == null;
        boolean destinoEsNull = destino == null;
        */

        boolean algunArgumentoEsNull = codigoEsNull ||
                origenEsNull ||
                destinoEsNull ;

        if(algunArgumentoEsNull) {
            throw  new IllegalArgumentException("Ningun argumento puede ser null");
        }

        /*
        boolean codigoEsVacio = codigo.isEmpty();
        boolean origenEsVacio = origen.isEmpty();
        boolean destinoEsVacio = destino.isEmpty();
        * */


        boolean algunArgumentoEsVacio = codigoEsVacio ||
                origenEsVacio ||
                destinoEsVacio ;

        if(algunArgumentoEsVacio) {
            throw  new IllegalArgumentException("Ningun argumento puede ser vacio");
        }

        //boolean capacidadEsNegativa = capacidad < 0;

        if (capacidadEsNegativa) {
            throw new IllegalArgumentException("Capacidad no puede ser negativa");
        }

        /*==============================================================*/

        /*===========================Alternativa III ========================*/

        validarConstructor(codigo,origen,destino,capacidad);

        /*==============================================================*/
        
        
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;

        this.pasajeros = new ArrayList<>();
    }

    /*==============================validaciones================================*/

    public void validarConstructor(String codigo,
                                   String origen,
                                   String destino,
                                   Integer capacidad) {
        validarCodigo(codigo);
        validarOrigen(origen);
        validarDestino(destino);
        validarCapacidad(capacidad);
    }

    private void validarCapacidad(Integer capacidad) {
        boolean capacidadEsNegativa = capacidad < 0;

        if (capacidadEsNegativa) {
            throw new IllegalArgumentException("Capacidad no puede ser negativa");
        }
    }

    /*Las validaciones las podemos meter a un método*/

    private void validarCodigo (String codigo) {
        boolean codigoEsNull = codigo == null;

        if (codigoEsNull) {
            throw new IllegalArgumentException("Codigo no puede ser null");
        }

        boolean codigoEsVacio = codigo.isEmpty(); //Esto verifica los strings.

        if (codigoEsVacio) {
            throw new IllegalArgumentException("Codigo no puede ser un string vacío");
        }

    }

    private void validarOrigen (String origen) {

        boolean appellidosEsNull = origen == null;

        if (appellidosEsNull) {
            throw new IllegalArgumentException("Origen no puede ser null");
        }

        boolean origenEsVacio = origen.isEmpty(); //Esto verifica los strings.

        if (origenEsVacio) {
            throw new IllegalArgumentException("Origen no puede ser un string vacío");
        }

    }

    private void validarDestino (String destino) {

        boolean destinoEsNull = destino == null;

        if (destinoEsNull) {
            throw  new IllegalArgumentException("Destino no puede ser null");
        }

        boolean destinoEsVacio = destino.isEmpty(); //Esto verifica los strings.

        if (destinoEsVacio) {
            throw new IllegalArgumentException("Destino no puede ser un string vacío");
        }

    }


    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {

        validarCodigo(codigo);

        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {

        validarOrigen(origen);

        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {

        validarDestino(destino);

        this.destino = destino;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {

        validarCapacidad(capacidad);

        this.capacidad = capacidad;
    }

    public int obtenerNumeroDePasajeros() {
        return this.pasajeros.size();
    }

    public void agregarPasajero (String nombres,
                                 String apellidos,
                                 String numeroPasaporte,
                                 String asiento,
                                 Integer edad) {

        //Pasajero lanza alguna excepción si no se cumplen los requerimientos

        Pasajero pasajero = new Pasajero(nombres,
                apellidos,
                numeroPasaporte,
                asiento,
                edad);

        //verifico que no exceda la capacidad

        int nuevaCantidadDePasajeros = obtenerNumeroDePasajeros() + 1;

        boolean nuevaCantidadExcedeCapacidad =
                nuevaCantidadDePasajeros > this.capacidad;


        if (nuevaCantidadExcedeCapacidad) {
            throw new IllegalArgumentException("Capacidad de vuelo excedida");
        }

        boolean pasajeroYaExiste =
                buscarPasajeroPorPasaporte(numeroPasaporte) != -1;

        if (pasajeroYaExiste) {
            throw new IllegalArgumentException("Pasajero ya existe");
        }

        boolean asientoOcupado=
                buscarPasajeroPorAsiento(asiento) != -1;

        if (asientoOcupado) {
            throw new IllegalArgumentException("Este asiento está ocupado");
        }


        this.pasajeros.add(pasajero);


    }

    public boolean eliminarPasajero (String numeroPasaporte) {

        int posicionPasajeroAEliminar =
                buscarPasajeroPorPasaporte(numeroPasaporte);

        if (posicionPasajeroAEliminar == -1) {
            return false;
        }

        this.pasajeros.remove(posicionPasajeroAEliminar);

        return true;
    }

    private int buscarPasajeroPorPasaporte(String numeroPasaporteABuscar) {

        int posicionPasajeroBuscado = -1;

        for (int i = 0 ; i < pasajeros.size() ; i++) {
            Pasajero p = pasajeros.get(i);
            boolean numeroPasaporteEsElBuscado =
                    p.getNumeroPasaporte().equals(numeroPasaporteABuscar);
            if (numeroPasaporteEsElBuscado) {
                posicionPasajeroBuscado = i;
            }
        }

        return posicionPasajeroBuscado;

    }

    private int buscarPasajeroPorAsiento(String asientoABuscar) {

        int posicionPasajeroBuscado = -1;

        for (int i = 0 ; i < pasajeros.size() ; i++) {
            Pasajero p = pasajeros.get(i);
            boolean asientoEsElBuscado =
                    p.getAsiento().equals(asientoABuscar);
            if (asientoEsElBuscado) {
                posicionPasajeroBuscado = i;
            }
        }

        return posicionPasajeroBuscado;

    }

    public String pasajeroMasJoven () {

        if (obtenerNumeroDePasajeros() == 0) {
            return "El vuelo está vacío";
        }

        Pasajero pasajeroMasJoven = this.pasajeros.get(0);

        for (Pasajero p : this.pasajeros) {
            pasajeroMasJoven = Pasajero.compararEdades(p, pasajeroMasJoven);
        }

        String resultString = "El pasajero más joven del vuelo es " +
                pasajeroMasJoven.getNombres() + " " +
                pasajeroMasJoven.getApellidos() + " " +
                "(pasaporte: " + pasajeroMasJoven.getNumeroPasaporte() + "). "+
                "Tiene " + pasajeroMasJoven.getEdad() + "años" +
                " y está sentado en el asiento " + pasajeroMasJoven.getAsiento();

        //Alternativa con toString

        /*
        String resultString = "El pasajero más joven del vuelo es " +
                pasajeroMasJoven;
        * */

        return resultString;


    }


}
