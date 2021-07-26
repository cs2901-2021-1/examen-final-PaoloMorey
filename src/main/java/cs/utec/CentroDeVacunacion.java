package cs.utec;

public class CentroDeVacunacion {

    private int id;
    private String nombre;
    private String direccion;
    private int vacunasParciales;
    private int vacunasCompletas;

    public CentroDeVacunacion(int id, String nombre, String direccion){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.vacunasParciales = 0;
        this.vacunasCompletas = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void notificarCompleta(){
        Sistema sys = Sistema.getSistemaInstance();
        sys.vacunaCompletaRealizada();
        Sistema.logger.info("Vacuna completa realizada");
    }

    public void notificarParcial(){
        Sistema sys = Sistema.getSistemaInstance();
        sys.vacunaParcialRealizada();
        Sistema.logger.info("Vacuna parcial realizada");
    }

    public void vacunarParcialmente(){
        vacunasParciales++;
        notificarParcial();
    }

    public void vacunarCompletamente(){
        vacunasCompletas++;
        notificarCompleta();
    }
}
