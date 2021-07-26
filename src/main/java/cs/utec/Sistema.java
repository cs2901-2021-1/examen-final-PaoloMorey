package cs.utec;

import java.util.Map;
import java.util.logging.Logger;

public class Sistema {

    static final Logger logger = Logger.getLogger(Sistema.class.getName());

    private static Sistema instanciaSingleton = null;

    private Map<Integer, CentroDeVacunacion> centrosDeVacunacion;
    private Map<String, Usuario> usuarios;
    private float avanceDeLaVacunacion;
    private float coberturaDeLaVacunacion;
    private double numeroDeCentrosDeVacunacion;
    private double numeroDePersonasVacunadasParcialmente;
    private double numeroDePersonasVacunadasCompletamente;
    private Usuario currentUser = null;

    public static Sistema getSistemaInstance(){
        if (instanciaSingleton == null){
            instanciaSingleton = new Sistema();
        }
        return instanciaSingleton;
    }

    public void setCentrosDeVacunacion(Map<Integer, CentroDeVacunacion> centrosDeVacunacion) {
        this.centrosDeVacunacion = centrosDeVacunacion;
    }

    public void registrarUsuario(String usuario){
        if (usuarios.containsKey(usuario)){
            logger.info("Usuario ya existente");
        }else{
            Usuario nuevoUsuario = new Usuario(usuario);
            usuarios.put(usuario, nuevoUsuario);
        }
    }

    public void iniciarSesion(String usuario, String contrasena){
        if (currentUser == null){
            if (usuarios.containsKey(usuario)){
                if (usuarios.get(usuario).getContrasena().equals(contrasena)){
                    currentUser = usuarios.get(usuario);
                }else{
                    logger.info("Contraseña Incorrecta");
                }
            }else{
                logger.info("Usuario inexistente");
            }
        }else{
            logger.info("Ya existe una sesion iniciada");
        }
    }

    public void cerrarSesion(){
        if (currentUser != null){
            currentUser = null;
        }else{
            logger.info("No existe una sesión iniciada para cerrar sesion");
        }
    }

    public void vacunaParcialRealizada(){
        numeroDePersonasVacunadasParcialmente++;
    }

    public void vacunaCompletaRealizada(){
        numeroDePersonasVacunadasCompletamente++;
    }

    public void actualizarInformacion(){
        double totalDePersonas = 22935533;
        avanceDeLaVacunacion = (float) ((numeroDePersonasVacunadasCompletamente*100)/ totalDePersonas);
        coberturaDeLaVacunacion = (float) ((numeroDePersonasVacunadasParcialmente*100)/ totalDePersonas);
    }

    public void visualizarInformacion(){
        this.actualizarInformacion();
        var avance = "Avance de la vacunacion: " + avanceDeLaVacunacion + "%";
        var cobertura = "Cobertura de la vacunacion" + coberturaDeLaVacunacion + "%";
        var centros = "Numero de centros de vacunacion: " + centrosDeVacunacion.size();
        var parcial = "Numero de personas vacunadas parcialmente: " + numeroDePersonasVacunadasParcialmente;
        var completa = "Numero de personas vacunadas completamente: " + numeroDePersonasVacunadasCompletamente;
    }

    public void darDeAlta(int id, String nombre, String direccion){
        if (currentUser == null){
            logger.info("Primero tienes que inciar sesión");
        }
        else{
            if (centrosDeVacunacion.containsKey(id)){
                logger.info("Centro de vacunación ya dado de alta");
            }else{
                CentroDeVacunacion nuevoCentro = new CentroDeVacunacion(id, nombre, direccion);
                centrosDeVacunacion.put(id, nuevoCentro);
            }
        }
    }

    public void darDeBaja(int id){
        if (currentUser == null){
            logger.info("Primero tienes que inciar sesión");
        }else{
            if (centrosDeVacunacion.containsKey(id)){
                centrosDeVacunacion.remove(id);
            }else{
                logger.info("Centro de vacunación inexistente");
            }
        }
    }

}
