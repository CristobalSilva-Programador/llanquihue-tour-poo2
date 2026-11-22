package data;

import model.Tour;
import model.Ubicacion;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorTours {

    private List<Tour> tours = new ArrayList<>();

    public void agregar(Tour tour) {
        tours.add(tour);
    }

    public void listarTodos() {

        for (Tour tour : tours) {

            System.out.println(tour);
            System.out.println("--------------------------");
        }
    }

    public List<Tour> buscarPorTipo(String tipo) {

        List<Tour> resultado = new ArrayList<>();

        for (Tour tour : tours) {

            if (tour.getTipo()
                    .equalsIgnoreCase(tipo)) {

                resultado.add(tour);
            }
        }

        return resultado;
    }

    public List<Tour> buscarPorPrecio(int precioMinimo) {

        List<Tour> resultado = new ArrayList<>();

        for (Tour tour : tours) {

            if (tour.getPrecio() >= precioMinimo) {

                resultado.add(tour);
            }
        }

        return resultado;
    }

    public void cargarDesdeExcel(String ruta) {

        try {

            FileInputStream fis =
                    new FileInputStream(ruta);

            XSSFWorkbook libro =
                    new XSSFWorkbook(fis);

            XSSFSheet hoja =
                    libro.getSheetAt(0);

            for (int i = 1;
                 i <= hoja.getLastRowNum();
                 i++) {

                var fila = hoja.getRow(i);


                if (fila == null || fila.getCell(0) == null) {
                    continue;
                }

                String nombre =
                        fila.getCell(0)
                                .getStringCellValue();

                String tipo =
                        fila.getCell(1)
                                .getStringCellValue();

                int precio =
                        (int) fila.getCell(2)
                                .getNumericCellValue();

                String comuna =
                        fila.getCell(3)
                                .getStringCellValue();

                String region =
                        fila.getCell(4)
                                .getStringCellValue();

                Ubicacion ubicacion =
                        new Ubicacion(
                                comuna,
                                region);

                Tour tour =
                        new Tour(
                                nombre,
                                tipo,
                                precio,
                                ubicacion);

                agregar(tour);
            }

            libro.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al leer Excel: "
                            + e.getMessage());
        }
    }
}