package cs.utec;

import java.util.logging.Logger;
import java.util.Scanner;

public class SistemaMain {
    static final Logger logger = Logger.getLogger(SistemaMain.class.getName());

    public static void main(String[] args){
        Sistema sys = Sistema.getSistemaInstance();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            logger.info("Ingrese 0 para iniciar sesión");
            logger.info("Ingrese 1 para registrarse");
            logger.info("Ingrese cualquier otro numero para salir");
            int option = Integer.parseInt(scanner.nextLine());
            if (option == 0){
                logger.info("Usuario: ");
                String usuario = scanner.nextLine();
                logger.info("Contrasena: ");
                String contrasena = scanner.nextLine();
                while (sys.iniciarSesion(usuario, contrasena)){
                    logger.info("Ingrese 0 para visualizar informacion");
                    logger.info("Ingrese 1 para dar de alta un centro de vacunación");
                    logger.info("Ingrese 2 para dar de baja un centro de vacunación");
                    logger.info("Ingrese 3 para cerrar sesión");
                    int toDo = Integer.parseInt(scanner.nextLine());
                    switch (toDo){
                        case 0:
                            sys.visualizarInformacion();
                        case 1:
                            logger.info("Inserte id del centro");
                            int id = Integer.parseInt(scanner.nextLine());
                            logger.info("Inserte nombre del centro");
                            String nombre = scanner.nextLine();
                            logger.info("Inserte direccion del centro");
                            String direccion = scanner.nextLine();
                            sys.darDeAlta(id, nombre, direccion);
                        case 2:
                            logger.info("Inserte id del centro");
                            int id_ = Integer.parseInt(scanner.nextLine());
                            sys.darDeBaja(id_);
                        case 3:
                            logger.info("Sesion cerrada");
                        default:
                            break;
                    }
                }
            }else if (option == 1){
                logger.info(" Nuevo Usuario: ");
                String usuario = scanner.nextLine();
                sys.registrarUsuario(usuario);
            }else{
                break;
            }
        }
    }
}
