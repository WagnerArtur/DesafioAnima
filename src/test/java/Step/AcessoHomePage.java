package Step;

import cucumber.api.java.pt.Dado;
import utils.GeradorDriver;

public class AcessoHomePage extends GeradorDriver {
	
	@Dado("^que o usuário está no site \"([^\"]*)\"$")
	public void que_o_usuário_está_no_site(String url) {
		getDriver().get(url);
	}
}
