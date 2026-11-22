package model;

public class Tour {

    private String nombre;
    private String tipo;
    private int precio;

    private Ubicacion ubicacion;

    public Tour(String nombre,
                String tipo,
                int precio,
                Ubicacion ubicacion) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {

        if(tipo == null || tipo.isEmpty()){
            throw new IllegalArgumentException(
                    "El tipo no puede estar vacío");
        }

        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {

        if(precio < 0){
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo");
        }

        this.precio = precio;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {

        return "Tour: " + nombre +
                "\nTipo: " + tipo +
                "\nPrecio: $" + precio +
                "\nUbicación: " + ubicacion;
    }
}