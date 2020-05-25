package Step;

import org.openqa.selenium.support.PageFactory;
import PageObject.CadastraUsuarioPageObject;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import utils.GeradorDriver;

public class CadastraUsuario extends GeradorDriver{

	CadastraUsuarioPageObject usuario = PageFactory.initElements(getDriver(), CadastraUsuarioPageObject.class);
	
	@E("^acessa o menu para cadastro$")
	public void acessa_o_menu_para_cadastro() {
		usuario.acessaMenu();
	}
	
	@Entao("^preenche o formuário$")
	public void preenche_o_formuário() {
		
	    usuario.preencheCadastroUsuario("Antonio", "Silva", "email@email.com", "Rua Itabira", "UNI", "Analista", "M", "32");
	}
}
