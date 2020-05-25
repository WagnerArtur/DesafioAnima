package Step;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.pt.Dado;
import utils.GeradorDriver;
import utils.Suporte;

public class ValidaUrlStep extends GeradorDriver {
	
	Suporte suporte = PageFactory.initElements(getDriver(), Suporte.class);
	
	@Dado("^verifica a URL do sistema para validação$")
	public void verifica_a_URL_do_sistema_para_validação() throws InterruptedException  {
		
		String urlEsperada = "https://automacaocombatista.herokuapp.com/home/index";
		suporte.verificaURL(getDriver(), urlEsperada);
		
		getDriver().close();
	}
}
