package PageObject;

import elements.Elements;

public class CadastraUsuarioPageObject extends Elements {
	
	public void acessaMenu(){
		
		bt_AutomacaoWeb.click();
		aguarda();
		menu_Formulario.click();
		aguarda();
		subMenu_CriarUsuario.click();
	}
	
	public void preencheCadastroUsuario(String nome, String sobrenome, String email, String endereco, String universidade, String profissao, String genero, String idade) {
		aguarda();
		campoNome.sendKeys(nome); 
		campoSobrenome.sendKeys(sobrenome);
		campoEmail.sendKeys(email);
		campoEndereco.sendKeys(endereco);
		campoUniversidade.sendKeys(universidade);
		campoProfissao.sendKeys(profissao);
		campoGenero.sendKeys(genero);
		campoIdade.sendKeys(idade);
		
		btCriar.click();
		aguarda();
	}
	
	public void PreencheCadastroSemObrigatorio() {
		
		btCriar.click();
		aguarda();
	}
	
	public void clicaBotaoVoltar() {
	
		btVoltar.click();
		aguarda();
	}
	
	public void aguarda() {
		
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
