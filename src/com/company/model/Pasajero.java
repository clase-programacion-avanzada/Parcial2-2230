package com.company.model;

public class Pasajero {

    private String nombres;
    private String apellidos;
    private String numeroPasaporte;
    private String asiento;
    private Integer edad;

    public Pasajero() {
        this.nombres = "";
        this.apellidos = "";
        this.numeroPasaporte = "";
        this.asiento = "";
        this.edad = 0;
    }

    public Pasajero(String nombres, String apellidos, String numeroPasaporte, String asiento, Integer edad) {
        /*===========================Alternativa I ========================*/

        /*Hay que verificar primero los null, no se puede verificar ls longitud hasta que no se haga esto*/
        boolean nombreEsNull = nombres == null;

        if (nombreEsNull) {
            throw new IllegalArgumentException("Nombres no puede ser null");
        }

        boolean appellidosEsNull = apellidos == null;

        if (appellidosEsNull) {
            throw new IllegalArgumentException("Apellidos no puede ser null");
        }

        boolean numeroPasaporteEsNull = numeroPasaporte == null;

        if (numeroPasaporteEsNull) {
            throw  new IllegalArgumentException("Numero de pasaporte no puede ser null");
        }

        boolean asientoEsNull = asiento == null;

        if (asientoEsNull) {
            throw new IllegalArgumentException("Numero de pasaporte no puede ser null");
        }

        boolean nombreEsVacio =
                nombres.isBlank(); //Esto verifica los strings.

        if (nombreEsVacio) {
            throw new IllegalArgumentException("Nombres no puede ser un string vacío");
        }
        boolean apellidoEsVacio = apellidos.isEmpty(); //Esto verifica los strings.

        if (apellidoEsVacio) {
            throw new IllegalArgumentException("Apellidos no puede ser un string vacío");
        }
        boolean asientoEsVacio = asiento.isEmpty(); //Esto verifica los strings.

        if (asientoEsVacio) {
            throw new IllegalArgumentException("Asiento no puede ser un string vacío");
        }
        boolean numeroPasaporteEsVacio = numeroPasaporte.isEmpty(); //Esto verifica los strings.

        if (numeroPasaporteEsVacio) {
            throw new IllegalArgumentException("Numero de pasaporte no puede ser un string vacío");
        }

        boolean edadEsNegativa = edad < 0;

        if (edadEsNegativa) {
            throw new IllegalArgumentException("Edad no puede ser negativa");
        }

        /*===========================Alternativa II ========================*/
        /*
        boolean nombreEsNull = nombres == null;
        boolean appellidosEsNull = apellidos == null;
        boolean numeroPasaporteEsNull = numeroPasaporte == null;
        boolean asientoEsNull = asiento == null;
        */

        boolean algunArgumentoEsNull = nombreEsNull ||
                appellidosEsNull ||
                numeroPasaporteEsNull ||
                asientoEsNull;

        if(algunArgumentoEsNull) {
            throw  new IllegalArgumentException("Ningun argumento puede ser null");
        }

        /*
        boolean nombreEsVacio = nombres.isEmpty();
        boolean apellidoEsVacio = apellidos.isEmpty();
        boolean asientoEsVacio = asiento.isEmpty();
        boolean numeroPasaporteEsVacio = numeroPasaporte.isEmpty();
        * */


        boolean algunArgumentoEsVacio = nombreEsVacio ||
                apellidoEsVacio ||
                numeroPasaporteEsVacio ||
                asientoEsVacio;

        if(algunArgumentoEsVacio) {
            throw  new IllegalArgumentException("Ningun argumento puede ser vacio");
        }

        //boolean edadEsNegativa = edad < 0;

        if (edadEsNegativa) {
            throw new IllegalArgumentException("Edad no puede ser negativa");
        }

        /*==============================================================*/

        /*===========================Alternativa III ========================*/

        validarConstructor(nombres,apellidos,numeroPasaporte,asiento,edad);

        /*==============================================================*/


        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroPasaporte = numeroPasaporte;
        this.asiento = asiento;
        this.edad = edad;
    }
    /*==============================validaciones================================*/

    public void validarConstructor(String nombres,
                                   String apellidos,
                                   String numeroPasaporte,
                                   String asiento,
                                   Integer edad) {
        validarNombres(nombres);
        validarApellidos(apellidos);
        validarNumeroPasaporte(numeroPasaporte);
        validarAsiento(asiento);
        validarEdad(edad);
    }

    private void validarEdad(Integer edad) {
        boolean edadEsNegativa = edad < 0;

        if (edadEsNegativa) {
            throw new IllegalArgumentException("Edad no puede ser negativa");
        }
    }

    /*Las validaciones las podemos meter a un método*/

    private void validarNombres (String nombres) {
        boolean nombreEsNull = nombres == null;

        if (nombreEsNull) {
            throw new IllegalArgumentException("Nombres no puede ser null");
        }

        boolean nombreEsVacio = nombres.isEmpty(); //Esto verifica los strings.

        if (nombreEsVacio) {
            throw new IllegalArgumentException("Nombres no puede ser un string vacío");
        }

    }

    private void validarApellidos (String apellidos) {

        boolean appellidosEsNull = apellidos == null;

        if (appellidosEsNull) {
            throw new IllegalArgumentException("Apellidos no puede ser null");
        }

        boolean apellidoEsVacio = apellidos.isEmpty(); //Esto verifica los strings.

        if (apellidoEsVacio) {
            throw new IllegalArgumentException("Apellidos no puede ser un string vacío");
        }

    }

    private void validarNumeroPasaporte (String numeroPasaporte) {

        boolean numeroPasaporteEsNull = numeroPasaporte == null;

        if (numeroPasaporteEsNull) {
            throw  new IllegalArgumentException("Numero de pasaporte no puede ser null");
        }

        boolean numeroPasaporteEsVacio = numeroPasaporte.isEmpty(); //Esto verifica los strings.

        if (numeroPasaporteEsVacio) {
            throw new IllegalArgumentException("Numero de pasaporte no puede ser un string vacío");
        }

    }

    private void validarAsiento (String asiento) {

        boolean asientoEsNull = asiento == null;

        if (asientoEsNull) {
            throw new IllegalArgumentException("Numero de pasaporte no puede ser null");
        }

        boolean asientoEsVacio = asiento.isEmpty(); //Esto verifica los strings vacíos.

        if (asientoEsVacio) {
            throw new IllegalArgumentException("Asiento no puede ser un string vacío");
        }

    }

    /*====================================Getters & Setters==========================================================*/
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {

        validarNombres(nombres);

        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {

        validarApellidos(apellidos);

        this.apellidos = apellidos;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {

        validarNumeroPasaporte(numeroPasaporte);

        this.numeroPasaporte = numeroPasaporte;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {

        validarAsiento(asiento);

        this.asiento = asiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {

        validarEdad(edad);

        this.edad = edad;
    }

    public static Pasajero compararEdades(Pasajero pasajero1, Pasajero pasajero2) {

        if (pasajero1.getEdad() < pasajero2.getEdad()) {
            return pasajero1;
        }

        return pasajero2;

    }

    @Override
    public String toString() {
        return nombres + " " +
                apellidos + " " +
                "(pasaporte: " + numeroPasaporte + "). "+
                "Tiene " + edad + "años" +
                " y está sentado en el asiento " + asiento;
    }
}
