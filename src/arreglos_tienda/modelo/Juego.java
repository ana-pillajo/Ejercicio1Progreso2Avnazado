package arreglos_tienda.modelo;

public class Juego {
    private String nombre;
    private String categporia;
    private int tamano;
    private double precio;
    private int LicenciasDisponibles;
    private int LicenciasVendidas;

    public Juego(String nombre, String categporia, int tamano, double precio, int licenciasDisponibles) {
        this.nombre = nombre;
        this.categporia = categporia;
        this.tamano = tamano;
        this.precio = precio;
        LicenciasDisponibles = licenciasDisponibles;
        LicenciasVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategporia() {
        return categporia;
    }

    public int getTamano() {
        return tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return LicenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return LicenciasVendidas;
    }

    public void setNombre(String nombre) {
        if(nombre != null && !nombre.trim().isEmpty())
            this.nombre = nombre;
    }

    public void setCategporia(String categporia) {
        if(categporia != null && !categporia.trim().isEmpty())
            this.categporia = categporia;
    }

    public void setTamano(int tamano) {
        if(tamano >0)
            this.tamano = tamano;
    }

    public void setPrecio(double precio) {
        if(precio>0)
            this.precio = precio;
    }
    public boolean comprar(int cantidad){
        if(cantidad>0){
            LicenciasDisponibles+= cantidad;
            return true;
        }
        return false;
    }
    public boolean vender(int cantidad){
        if(cantidad>0 && cantidad <= LicenciasDisponibles){
            LicenciasDisponibles -= cantidad;
            LicenciasVendidas += cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", categporia='" + categporia + '\'' +
                ", tamano=" + tamano +
                ", precio=" + precio +
                ", LicenciasDisponibles=" + LicenciasDisponibles +
                ", LicenciasVendidas=" + LicenciasVendidas +
                '}';
    }
}

