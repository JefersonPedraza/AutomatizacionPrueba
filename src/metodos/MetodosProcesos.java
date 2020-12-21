package metodos;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MetodosProcesos {
	private static MetodosProcesos instanciaUnicaMetodosProcesos = null;
	public static Object getInstanciaUnicaMetodosProcesos;
	public ChromeDriver driver; 
	public static MetodosProcesos getInstanciaUnicaMetodosProcesos() {
		if (instanciaUnicaMetodosProcesos == null) {
			instanciaUnicaMetodosProcesos = new MetodosProcesos();
		}
		return instanciaUnicaMetodosProcesos;
	}


	public WebElement crearObjetoPorXpath(String xpath) {
		WebElement objeto;
		if (!xpath.isEmpty() &&  xpath!= null) {

			objeto = this.driver.findElement(By.xpath(xpath));
			return objeto;
		}else {
			System.out.println("El valor de Xpath es invalido");
			return null;
		}
	}

	public ChromeDriver obtenerWebDriver(){
		try{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			this.driver = new ChromeDriver();
			return driver;
		}catch(Exception e){
			return null;
		}
	}

	public boolean abrirPagina(String pagina) {
		if (!pagina.isEmpty() &&  pagina!= null) {
			obtenerWebDriver().get(pagina);
			this.driver.manage().window().maximize();
			return true;
		}else {
			return false;
		}
	}

	public boolean esperaObjetoDisponible(String xpath) {
		try {
			if (!xpath.isEmpty() &&  xpath!= null) {
				WebDriverWait myWaitVar = new WebDriverWait(this.driver, 30);
				myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				scrollObjeto(xpath);
				return true;
			}else {
				return false;
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean darClick(String elemento) {
		try {
			if ( elemento!= null) {
				crearObjetoPorXpath(elemento).click();
				return true;
			}else {
				return false;
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean escribirEnObjeto(String elemento,String texto) {
		try {
			if ( elemento!= null) {
				crearObjetoPorXpath(elemento).sendKeys(texto);
				return true;
			}else {
				return false;
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean scrollObjeto(String xpath) {
		try {
			WebElement element = this.driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public void inspeccionarPagina(int intentos) {
		try {
			if (intentos>0) {
				Robot r = new Robot();
				Thread.sleep(1000);
				for (int i = 0; i < intentos; i++) {

					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_PAGE_DOWN);
					r.keyRelease(KeyEvent.VK_PAGE_DOWN);
				}

				r.keyPress(KeyEvent.VK_HOME);
				r.keyRelease(KeyEvent.VK_HOME);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	public void cambiarFrameDeterminado(String frame){
		try{
			if(this.driver != null && frame != null){
				this.driver.switchTo().frame(crearObjetoPorXpath(frame));
			}else{
				System.out.println("el objeto no es valido");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public String generarNumeroRandom(int cantidadDitito){
		return (new Long (String.valueOf (new Random().nextLong()).replace("-","").substring(0,cantidadDitito)).toString());
	}
	
	public void opcionSelect(String xpath) {
		WebElement selectElement = crearObjetoPorXpath(xpath);
		Select selectObject = new Select(selectElement);
		selectObject.selectByIndex(1);
	}
}
