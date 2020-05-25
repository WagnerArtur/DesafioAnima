package Step;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.pt.Dado;
import elements.Elements;
import utils.GeradorDriver;
import utils.Suporte;

public class ValidaAcessoAutomacaoStep extends GeradorDriver {
	
	Suporte suporte = PageFactory.initElements(getDriver(), Suporte.class);

	@Dado("^verifica a tela Home$")
	public void verifica_a_tela_Home() {
		
		String textoEsperado = "Site para Automação";
		suporte.verificaTexto(getDriver(), textoEsperado, Elements.VERIFICA_HOME);
	}
}
