package Step;

import org.openqa.selenium.support.PageFactory;

import PageObject.CadastraUsuarioPageObject;
import cucumber.api.java.pt.Entao;
import elements.Elements;
import utils.GeradorDriver;
import utils.Suporte;

public class ValidaCamposObrigatorios extends GeradorDriver{
	
	CadastraUsuarioPageObject usuario = PageFactory.initElements(getDriver(), CadastraUsuarioPageObject.class);
	Suporte usuarioValida = PageFactory.initElements(getDriver(), Suporte.class);

	@Entao("^preenche o formulário exceto os campos obrigatorios$")
	public void preenche_o_formulário_exceto_os_campos_obrigatorios() throws InterruptedException {
		usuario.PreencheCadastroSemObrigatorio();
	}
	
	@Entao("^valida a mensagem de obrigatoriedade$")
	public void valida_a_mensagem_de_obrigatoriedade() throws Throwable {
		
		String msgObrigatoria = "3 errors proibiu que este usuário fosse salvo:";
		usuarioValida.verificaTexto(getDriver(), msgObrigatoria, Elements.MENSAGEM_OBRIGATORIEDADE);
	}
}
