package br.com.appium.GerenciadorPonto.page;

import org.openqa.selenium.By;

import br.com.appium.GerenciadorPonto.core.BasePage;

public class CadastrarFuncionario extends BasePage {

	public void setNomeFuncionario(String nome) {

		escrever(By.xpath("//*[@resource-id='com.exacore.gerenciadordeponto:id/editNomeCompleto']"), nome);
	}

	public void setDataNascimentoFuncionario() throws InterruptedException {

		clicar(By.xpath("//*[@resource-id='com.exacore.gerenciadordeponto:id/editDataNascimento']"));
		
		clicar(By.xpath("//*[@resource-id='android:id/button1']"));

	}

	public void setPisFuncionario(String pis) {

		escrever(By.xpath("//*[@resource-id='com.exacore.gerenciadordeponto:id/editPIS']"), pis);
	}
}
