package Step;

import org.openqa.selenium.support.PageFactory;

import PageObject.CadastraUsuarioPageObject;
import cucumber.api.java.pt.Entao;
import utils.GeradorDriver;
import utils.Suporte;

public class ValidaFuncionalidadeVoltarStep extends GeradorDriver{
	
	CadastraUsuarioPageObject usuario = PageFactory.initElements(getDriver(), CadastraUsuarioPageObject.class);
	Suporte usuarioValida = PageFactory.initElements(getDriver(), Suporte.class);

	@Entao("^clica no botao voltar$")
	public void clica_no_botao_voltar() {
		
		usuario.clicaBotaoVoltar();
	}

	@Entao("^valida a pagina de retorno$")
	public void valida_a_pagina_de_retorno() throws InterruptedException {
	    
		String urlEsperada = "https://automacaocombatista.herokuapp.com/users";
		usuarioValida.verificaURL(getDriver(), urlEsperada);
	}

}
