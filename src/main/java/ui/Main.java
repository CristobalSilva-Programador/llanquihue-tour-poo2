package ui;

import data.GestorTours;
import model.Tour;

public class Main {

    public static void main(String[] args) {

        GestorTours gestor =
                new GestorTours();

        gestor.cargarDesdeExcel(
                "src/main/resources/tours.xlsx");

        System.out.println(
                "========= TODOS LOS TOURS =========\n");

        gestor.listarTodos();

        System.out.println(
                "\n========= TOURS LACUSTRES =========\n");

        for (Tour tour
                : gestor.buscarPorTipo(
                "Lacustre")) {

            System.out.println(tour);
            System.out.println();
        }

        System.out.println(
                "\n====== TOURS SOBRE $2000 ======\n");

        for (Tour tour
                : gestor.buscarPorPrecio(
                2000)) {

            System.out.println(tour);
            System.out.println();
        }
    }
}
