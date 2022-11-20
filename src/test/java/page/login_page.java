package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usertextbox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passtextbox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement LognButton;

	public login_page(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void takecred(String user, String pass) {
		usertextbox.clear();
		passtextbox.clear();

		usertextbox.sendKeys(user);

		passtextbox.sendKeys(pass);
		LognButton.click();

	}

}
