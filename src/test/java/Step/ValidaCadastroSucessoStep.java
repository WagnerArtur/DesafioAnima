package Step;

import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.pt.Entao;
import elements.Elements;
import utils.GeradorDriver;
import utils.Suporte;

public class ValidaCadastroSucessoStep extends GeradorDriver {

	Suporte usuario = PageFactory.initElements(getDriver(), Suporte.class);

	@Entao("^valida a mensagem de sucesso$")
	public void valida_a_mensagem_de_sucesso() {

		String msgSucesso = "Usuário Criado com sucesso";
		usuario.verificaTexto(getDriver(), msgSucesso, Elements.MENSAGEM_SUCESSO);
	}
}
