import org.junit.Test;
import org.junit.Assert;

public class testeUsuario {
    @Test
    public void testeAdicionarUsuario(){
        Site site = new Site();
        site.adicionarUsuario("Weslley Addson", "28/05/2001",false, "22052299076", 525347,"Engenheiro");
        Assert.assertNotNull(site.getUsuarioSite("22052299076"));
        site.adicionarUsuario("Kaio Luan", "18/01/199", false, "72136761056", 525347,"Medico");
        Assert.assertNull(site.getUsuarioSite("72136761056"));
        site.adicionarUsuario("Maria Joao", "20/10/1996", false, "2097736", 525347,"Professor");
        Assert.assertNull(site.getUsuarioSite("2097736"));
    }
    @Test
    public void testeUsuarioPrioritario(){
        Site site = new Site();
        site.adicionarUsuario("Maria das Dores", "10/02/1940",true, "24385982040", 525347,"Enfermeira");
        Assert.assertTrue(site.usuarioPrioritario("24385982040"));
        site.adicionarUsuario("Weslley Addson", "28/05/2001",false, "37429606016", 525347,"Engenheiro");
        Assert.assertFalse(site.usuarioPrioritario("37429606016"));
        site.adicionarUsuario("Joao neves","28/05/1960",false, "65587363066", 525347,"Agricultor");
        Assert.assertTrue(site.usuarioPrioritario("65587363066"));
    }

    @Test
    public void testeUsuarioMaiorQueSesentaAnos(){
        Site site = new Site();
        site.adicionarUsuario("Joao neves","28/05/1960",false, "74271484016", 525347,"Agricultor");
        Assert.assertTrue(site.usuarioPrioritario("74271484016"));
        site.adicionarUsuario("Weslley Addson", "28/05/2001",false, "56210039006", 525347,"Engenheiro");
        Assert.assertFalse(site.usuarioPrioritario("56210039006"));
    }

    @Test
    public void testegetUsuarioSite(){
        Site site = new Site();
        site.adicionarUsuario("Weslley Addson", "28/05/2001", false, "56210039006", 321369,"Engenheiro");
        Assert.assertNotNull(site.getUsuarioSite("56210039006"));
        Assert.assertNull(site.getUsuarioSite("5621003900"));
    }
}
