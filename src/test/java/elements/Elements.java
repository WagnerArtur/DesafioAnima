package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {

	// Elementos constantes que cont�m como seu valor o inspecionamento
	// (ccsSelector) de campos, botoes e mensagens
	// O final significa justamente a constante de cada um dele

	public static final String VERIFICA_HOME = "body > div.s12.center > h4";
	public static final String COMECAR_AUTOMACAO_WEB = "#index-banner > div > div:nth-child(3) > a";
	public static final String MENSAGEM_SUCESSO = "#notice";
	public static final String MENSAGEM_OBRIGATORIEDADE = "#error_explanation > h2";
	
	@FindBy (css="#index-banner > div > div:nth-child(3) > a") 
	protected WebElement bt_AutomacaoWeb;
	
	@FindBy (css= "body > div.row > div.col.s3 > ul > li:nth-child(1) > a")
	protected WebElement menu_Formulario;

	@FindBy (css= "body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(1) > a")
	protected WebElement subMenu_CriarUsuario;

	@FindBy (css= "#user_name")
	protected WebElement campoNome;

	@FindBy (css= "#user_lastname")
	protected WebElement campoSobrenome;

	@FindBy (css= "#user_email")
	protected WebElement campoEmail;

	@FindBy (css= "#user_address")
	protected WebElement campoEndereco;

	@FindBy (css= "#user_university")
	protected WebElement campoUniversidade;

	@FindBy (css= "#user_profile")
	protected WebElement campoProfissao;

	@FindBy (css= "#user_gender")
	protected WebElement campoGenero;
	
	@FindBy (css= "#user_age")
	protected WebElement campoIdade;
	
	@FindBy (css= "#new_user > div:nth-child(7) > div > div > input[type=submit]")
	protected WebElement btCriar;
	
	@FindBy (css= "body > div.row > div.col.s9 > div:nth-child(3) > div > a.btn.waves-light.red")
	protected WebElement btVoltar;
	
	@FindBy (css= "")
	protected WebElement msgErroCamposObrigatorios;
	
	@FindBy (css= "")
	protected WebElement c;
	
	
	
	
}