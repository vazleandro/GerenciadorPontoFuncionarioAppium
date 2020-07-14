package br.com.appium.GerenciadorPonto.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.appium.GerenciadorPonto.core.DriverFactory;
import br.com.appium.GerenciadorPonto.page.CadastrarFuncionario;

public class BaterPontoTest {

	@After
	public void encerraAppium() {

		DriverFactory.killDriver();
	}

	CadastrarFuncionario cadastrar = new CadastrarFuncionario();

	@Test
	public void validarCadastroFuncionario() throws InterruptedException {

		cadastrar.clicarPorTexto("CADASTRAR");
		cadastrar.setNomeFuncionario("Leandro Vaz");
		cadastrar.setDataNascimentoFuncionario();
		cadastrar.setPisFuncionario("12345678");
		cadastrar.clicarPorTexto("CADASTRAR");

		Assert.assertEquals("Cadastro realizado com sucesso!",
				cadastrar.getTexto((By.xpath("//android.widget.LinearLayout/android.widget.TextView"))));
		cadastrar.clicarPorTexto("VOLTAR");
	}

	@Test
	public void VerificarBaterPontoFuncionario() throws InterruptedException {

		cadastrar.clicarPorTexto("CADASTRAR");
		cadastrar.setNomeFuncionario("Leandro Vaz");
		cadastrar.setDataNascimentoFuncionario();
		cadastrar.setPisFuncionario("12345678");
		cadastrar.clicarPorTexto("CADASTRAR");
		cadastrar.clicarPorTexto("VOLTAR");

		cadastrar.clicarPorTexto("BATER PONTO");
		cadastrar.clicarPorTexto("L");

		cadastrar.clicarPorTexto(cadastrar.retornaDia());

		Assert.assertEquals("Batida registrada com sucesso!",
				cadastrar.getTexto((By.xpath("//android.widget.LinearLayout/android.widget.TextView"))));

		cadastrar.clicarPorTexto("VOLTAR");

	}

	@Test
	public void VerificarBatidasFuncionario() throws InterruptedException {

		cadastrar.clicarPorTexto("CADASTRAR");
		cadastrar.setNomeFuncionario("Leandro Vaz");
		cadastrar.setDataNascimentoFuncionario();
		cadastrar.setPisFuncionario("12345678");
		cadastrar.clicarPorTexto("CADASTRAR");
		cadastrar.clicarPorTexto("VOLTAR");

		cadastrar.clicarPorTexto("BATER PONTO");
		cadastrar.clicarPorTexto("L");
		cadastrar.clicarPorTexto(cadastrar.retornaDia());

		cadastrar.clicarPorTexto("VOLTAR");

		cadastrar.clicarPorTexto("VISUALIZAR BATIDAS");

		Assert.assertTrue(cadastrar.contemTexto(By.xpath("//android.widget.RelativeLayout/android.widget.TextView"),"Leandro Vaz " +cadastrar.retornaDate()));
		
		cadastrar.clicarPorTexto("VOLTAR");

	}

}
