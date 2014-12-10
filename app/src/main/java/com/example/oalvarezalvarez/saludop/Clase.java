package com.example.oalvarezalvarez.saludop;

/**
 * Created by oalvarezalvarez on 10/12/14.
 */

    import java.io.Serializable;

    public class Clase implements Serializable
    {
        private static  final  long SERIEV=12;
        String nombre;
        int edad;
        public Clase(String nombre,int edad)
        {
            this.nombre=nombre;
            this.edad=edad;
        }

    }

