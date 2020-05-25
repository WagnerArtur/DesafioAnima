package utils;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Suporte {

	WebDriver driver;
	WebDriverWait wait;

	public void preenche(WebDriver webDriver, String selector, String preenchimento) {
		webDriver.findElement(By.xpath(selector)).sendKeys(preenchimento);
	}

	public void tempoDeEspera(long tempo) throws InterruptedException {
		Thread.sleep(tempo);
	}

	public void aguardeResposta(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void selecionaElementoLista(WebDriver driver, String id, String Texto) {
		Select selecao = new Select(driver.findElement(By.cssSelector(id)));
		selecao.selectByVisibleText(Texto);
	}

	public void anexaArquivos(WebDriver driver) {
		String filePath = System.getProperty("user.dir");
		StringSelection ss = new StringSelection(filePath + "\\src\\main\\resources\\anexo.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		try {
			Robot robot = new Robot();
			robot.delay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (Exception e) {

		}
	}

	public void identificaNovaAba(WebDriver webDriver, String url) {

		ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs2.get(0));
		webDriver.close();
		System.out.println("fecha pag");
		webDriver.switchTo().window(tabs2.get(1));
		WebDriverWait wait = new WebDriverWait(webDriver, 60);
		wait.until(ExpectedConditions.urlContains(url));
		System.out.println("getDrive");
		String urlObtida = webDriver.getCurrentUrl();
		String urlEsperada = url;
		Assert.assertTrue(urlObtida.contains(urlEsperada));
		System.out.println("Concluído");
	}

	public void identificaURL(WebDriver webDriver, String url) {
		ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());

		webDriver.switchTo().window(tabs2.get(1));
		String urlObtida = webDriver.getCurrentUrl();
		String urlEsperada = url;
		Assert.assertTrue(urlObtida.contains(urlEsperada));
	}

	public void captaTexto(WebDriver webDriver, String msg) {

		WebElement msgSucesso = webDriver.findElement(By.cssSelector(".toast-message"));
		String msgObtida = msgSucesso.getText();
		String msgEsperada = msg;
		System.out.println(msgSucesso.getText());
		Assert.assertTrue(msgObtida.contains(msgEsperada));
	}

	public void comparaEsperadoObtido(WebDriver webDriver, String selector, String txtEsperado, int espera) {
		boolean teste = true;
		int cont = 0;
		while (teste && cont < espera) {
			try {

				WebElement page = webDriver.findElement(By.cssSelector(selector));
				String text = page.getText();
				System.out.println(text);
				Assert.assertTrue(txtEsperado.contains(text));

				teste = false;

			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				cont++;
			}
		}

		if (cont == espera) {
			WebElement page = webDriver.findElement(By.cssSelector(selector));
			String text = page.getText();
			System.out.println(text);
			Assert.assertTrue(txtEsperado.contains(text));
		}
	}

	public void capturaMSG(WebDriver webDriver, String selector, int espera) {

		boolean teste = true;
		int cont = 0;
		while (teste && cont < espera) {
			try {

				WebElement element = webDriver.findElement(By.cssSelector(selector));
				String msg = element.getText();
				System.out.println(msg);
				teste = false;

			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
					System.out.println("Apresentou erro!");
				}
				cont++;
			}
		}

		if (cont == espera) {

			WebElement element = webDriver.findElement(By.cssSelector(selector));
			String msg = element.getText();
			System.out.println(msg);
		}
	}

	public void seletor(WebDriver driver, String selector) {
		driver.findElement(By.cssSelector(selector));
	}

	public void selecionaItemMenu(WebDriver webDriver, String nomeMenu) {
		List<WebElement> menus = webDriver.findElement(By.cssSelector("ul[class=\"nav nav-main\"]"))
				.findElements(By.tagName("li"));
		for (WebElement menu : menus) {
			if (menu.getText().toLowerCase().trim().equals(nomeMenu.toLowerCase())) {
				menu.click();
				break;
			}
		}

	}

	public void verificaTabela(WebDriver webDriver, String selector2) {
		List<WebElement> contador = webDriver.findElement(By.cssSelector(selector2)).findElements(By.tagName("tr"));
		contador.size();
		System.out.println("Quantidade de Itens: " + contador.size());
		Assert.assertTrue(contador.size() > 0);
	}

	public void aguardaCarregamento(WebDriver webDriver, String seletor) {
		wait = new WebDriverWait(webDriver, 620);
		wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.cssSelector(seletor))));
	}

	public void verificaURL(WebDriver webDriver, String urlEsperada) throws InterruptedException {
		tempoDeEspera(1500);
		String urlObtida = webDriver.getCurrentUrl();
		System.out.println(urlObtida);
		Assert.assertTrue(urlObtida.contains(urlEsperada));
	}

	public void verificaTexto(WebDriver webDriver, String text, String seletor) {
		WebElement page = webDriver.findElement(By.cssSelector(seletor));
		String txtEsperado = page.getText();
		System.out.println(text);
		Assert.assertTrue(txtEsperado.contains(text));
	}

	public void trocaAba(WebDriver driver, String url) {
		String janelaAtual = driver.getWindowHandle();
		Set<String> janelas = driver.getWindowHandles();

		for (String janela : janelas) {
			driver.switchTo().window(janela);
			if (driver.getCurrentUrl().equals(url)) {
				break;
			}
		}
	}

	public String pegarTexto(WebDriver driver, String elemento) {
		return driver.findElement(By.cssSelector(elemento)).getText();
	}

	public boolean campoVazio(WebDriver webDriver, String css) {
		return webDriver.findElement(By.cssSelector(css)).getAttribute("value").length() < 1;
	}

	public void carregando(WebDriver driver) {
		Suporte $ = new Suporte();
		$.aguardaCarregamento(driver, ".message > div:nth-child(1) > h3:nth-child(2)");
	}

	public boolean verificaCampoCheio(WebDriver driver, String css) {
		return driver.findElement(By.cssSelector(css)).getText().length() > 0;
	}

	public boolean verificaCampoCheio(WebDriver driver, WebElement elemento) {
		System.out.println(elemento.getText());
		return elemento.getText().length() > 0;
	}

	public void verificaEdicao(WebDriver driver, String observacao) {

	}

	public void percorreLista(WebDriver driver, String string) {
		List<WebElement> linhaTabela = driver.findElements(By.cssSelector(string));

		for (int i = 0; i < linhaTabela.size(); i++) {
			WebElement cedula = linhaTabela.get(i);
			if (!(i == 1)) {
				assertTrue(verificaCampoCheio(driver, cedula));
			}
		}
	}

	public static void aguardarElementoNaTela(WebElement elemento) {
		WebDriverWait aguardar = new WebDriverWait(GeradorDriver.getDriver(), 30);
		aguardar.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	public static void aguardarElementoClicavel(WebElement elemento) {
		WebDriverWait aguardar = new WebDriverWait(GeradorDriver.getDriver(), 100);
		aguardar.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	public static void aguardarElementoVisivel(WebElement elemento) {
		WebDriverWait aguardar = new WebDriverWait(GeradorDriver.getDriver(), 30);
		aguardar.until(ExpectedConditions.visibilityOf(elemento));
	}

	public static void aguardarElementoInvisivel(WebElement elemento) {
		WebDriverWait aguardar = new WebDriverWait(GeradorDriver.getDriver(), 30);
		aguardar.until(ExpectedConditions.invisibilityOf(elemento));
	}

	public static void threadSleep(long tempo) throws InterruptedException {
		Thread.sleep(tempo);
	}

	public void clicaElemento(WebDriver webDriver, String elemento, int espera) {

		boolean teste = true;
		int cont = 0;
		while (teste && cont < espera) {
			try {
				webDriver.findElement(By.cssSelector(elemento)).click();
				teste = false;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				cont++;
			}
		}
		if (cont == espera) {
			webDriver.findElement(By.cssSelector(elemento)).click();
		}

	}

	public void limpaEPreenche(WebDriver driver, String selector, String nome) {

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}

		WebElement elemento = driver.findElement(By.cssSelector(selector));
		elemento.clear();

		elemento.sendKeys(nome);
	}

	public void preencheCampo(WebDriver webDriver, String selector, String preenchimento, int espera) {
		boolean teste = true;
		int cont = 0;
		while (teste && cont < espera) {
			try {
				webDriver.findElement(By.cssSelector(selector)).sendKeys(preenchimento);
				teste = false;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				cont++;
			}
		}
		if (cont == espera) {
			webDriver.findElement(By.cssSelector(selector)).sendKeys(preenchimento);
		}

	}

	public void clicaEnter(WebDriver webDriver) throws AWTException {
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void geraNumero(WebDriver webDriver, int quantidadeDigitos, String selector) {

		String contexto = "0123456789";
		Random random = new Random();
		String contextofuncao = "";
		int index = -1;
		
		for (int i = 0; i < quantidadeDigitos; i++) {
			index = random.nextInt(contexto.length());
			contextofuncao += contexto.substring(index, index + 1);
	
			webDriver.findElement(By.cssSelector(selector)).sendKeys(contextofuncao);
		}
	}
	
	public void scrollPBaixo(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,250)", "");
		try {
			threadSleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void scroolPCima(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
		try {
			threadSleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verificaListaDoc(WebDriver driver) {
		List<WebElement> tabela = driver.findElements(By.cssSelector("#collapseExample > table > tbody"));
		List<WebElement> linhas = tabela.get(0).findElements(By.tagName("button"));

		for (int i = 0; i < linhas.size(); i++) {			
			try {
				tempoDeEspera(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement validar = linhas.get(i);
			validar.click();
	
			try {
				tempoDeEspera(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement deAcordo = driver.findElement(By.cssSelector("#deAcordo"));
			deAcordo.click();
			
			try {
				tempoDeEspera(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement salvar = driver.findElement(By.cssSelector("#btn-salvar"));
			salvar.click();
		}
	}
	
	public void verificaListaDoc_04(WebDriver driver) {
		
		List<WebElement> tabela = driver.findElements(By.cssSelector("#collapseExample > table > tbody"));
		List<WebElement> linhas = tabela.get(0).findElements(By.cssSelector("button[class='btn btn-xs btn-edif-primary']"));

		for (int i = 0; i < linhas.size(); i++) {			
			try {
				tempoDeEspera(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement validar = linhas.get(i);
			validar.click();
	
			try {
				tempoDeEspera(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement deAcordo = driver.findElement(By.cssSelector("#deAcordo"));
			deAcordo.click();
			
			try {
				tempoDeEspera(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement salvar = driver.findElement(By.cssSelector("#btn-salvar"));
			salvar.click();
		}
	}
}
