package com.mycompany.mavenproject1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CarreraDAO dao = new CarreraDAO();

        List<String> carreras = dao.obtenerCarrerasPorEscuela("Ingenieria");

        for (String carrera : carreras) {
            System.out.println(carrera);
        }
    }
}