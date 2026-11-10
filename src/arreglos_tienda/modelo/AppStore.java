package arreglos_tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int Indice;

    public AppStore(){
        juegos = new Juego[MAX];
        Indice = -1;
    }
    public void cargarDatos(){
        //invoca al metodo agregarJuego() como si fuera un void pq no voy a dar ningún mensaje al usuario
        agregarJuego(new Juego("Fifa2026","Deportes",45,58,15));
        agregarJuego(new Juego("Roblox","Acción",25,90,20));
    }

    public Juego[] getJuegos() {
        return juegos;
    }
    /*
        no es necesario el set porque el ingreso debería ser por cada elemento
        public void setJuegos(Juego juegos[]) {
            this.juegos = juegos;
        }

     */

    public int getIndice() {
        return Indice;
    }

    public boolean agregarJuego(Juego j){
        if(j != null && Indice < MAX -1){
            juegos[++Indice] = j;
            return true;
        }
        return false;
    }
    public Juego buscarJuego(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            for(int i = 0; i <= Indice; i++){
                if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                    return juegos[i];
                }
            }
            return null;
        }
        return null;

    }
    public boolean comprar(String nombre, int cantidad){
        if(nombre != null && !nombre.trim().isEmpty() && cantidad > 0){
            Juego j = buscarJuego(nombre);
            if(j != null){
                return j.comprar(cantidad);
            }
        }
        return false;
    }
    public double vender(String nombre, int cantidad){
        //no voy a validar los paràmetros pq el buscar ya lo valida y el vender
        //del producto tbn
        Juego j = buscarJuego(nombre);
        if(j != null){
            if (j.vender(cantidad)) {
                return j.getPrecio() * cantidad;
            }else{
                return 0;
            }
        }
        return 0;
    }

    public String masVendido(){
        String nombre = "";
        int mayor;
        if(Indice >= 0){
            nombre = juegos[0].getNombre();
            mayor = juegos[0].getLicenciasVendidas();
            for(Juego j : juegos){
                if(j != null){
                    if(j.getLicenciasVendidas() > mayor){
                        nombre = j.getNombre();
                        mayor = j.getLicenciasVendidas();
                    }
                }else{
                    return nombre;
                }
            }
        }
        return nombre;
    }
}