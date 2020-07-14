package br.com.appium.GerenciadorPonto.core;

import static br.com.appium.GerenciadorPonto.core.DriverFactory.getDrive;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;

public class BasePage {

	public void clicar(By by) {

		getDrive().findElement(by).click();

	}

	public void clicarPorTexto(String texto) {

		clicar(By.xpath("//*[@text='" + texto + "']"));

	}

	public void escrever(By by, String texto) {

		getDrive().findElement(by).sendKeys(texto);
	}

	public String getTexto(By by) {

		return getDrive().findElement(by).getText();

	}

	public boolean contemTexto(By by, String funcionario) {

		String texto = getDrive().findElement(by).getText();

		return texto.startsWith(funcionario);

	}

	public String retornaDate() {

		Date date = new Date();
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String stringData = data.format(date);

		return stringData;
	}

	public String retornaDia() {
		Calendar cal = new GregorianCalendar();
		Integer dia = cal.get(Calendar.DAY_OF_MONTH);

		return dia.toString();

	}
}
