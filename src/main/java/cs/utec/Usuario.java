package cs.utec;

import java.util.logging.Logger;

public class Usuario {

    static final Logger logger = Logger.getLogger(Usuario.class.getName());

    private String username;
    private String contrasena;

    private String reverseString(String s){
        byte[] strAsByteArray = s.getBytes();
        byte[] ans = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++){
            ans[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        return new String(ans);
    }

    public Usuario(String username){
        this.username = username;
        this.contrasena = reverseString(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
