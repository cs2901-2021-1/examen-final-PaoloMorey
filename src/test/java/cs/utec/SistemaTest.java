package cs.utec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SistemaTest {

    @Test
    public void testCentroDeVacunacion(){
        CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion(1, "Centro 1", "Av Brasil 3775");
        centroDeVacunacion.setId(2);
        centroDeVacunacion.setNombre("Hola");
        centroDeVacunacion.setDireccion("Av Pablo Carriquiry 385");
        Assert.assertEquals(centroDeVacunacion.getId(), 2);
        Assert.assertEquals(centroDeVacunacion.getNombre(), "Hola");
        Assert.assertEquals(centroDeVacunacion.getDireccion(), "Av Pablo Carriquiry 385");
    }

    @Test
    public void testUsuario(){
        Usuario usuario = new Usuario("paolo.morey");
        usuario.setContrasena("yerom.oloap");
        usuario.setUsername("paolo.morey");
        Assert.assertEquals(usuario.getUsername(), "paolo.morey");
        Assert.assertEquals(usuario.getContrasena(), "yerom.oloap");
    }
}
