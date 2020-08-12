package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AutomationSignupPageObject {

	WebDriver driver=null;
	
	String cartInfoText= "Faded Short Sleeve T-shirts\r\n" + 
			"Orange, S\r\n" + 
			"Quantity 1\r\n" + 
			"Total $16.51";

	By link_signin=By.className("login");
	By textbox_email=By.name("email");
	By textbox_password=By.id("passwd");
	By button_signin=By.name("SubmitLogin");
	By button_tshirt=By.linkText("T-SHIRTS");		
	By image_tshirt=By.partialLinkText("Faded Short Sleeve T");
	By button_addtocart=By.id("add_to_cart");
	By button_proceedtocheckout=By.cssSelector("body.product.product-1.product-faded-short-sleeve-tshirts.category-5.category-tshirts.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div:nth-child(4) div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.button-container:nth-child(5) > a.btn.btn-default.button.button-medium");
	@FindBy(css="body.product.product-1.product-faded-short-sleeve-tshirts.category-5.category-tshirts.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div:nth-child(4) div.clearfix div.layer_cart_product.col-xs-12.col-md-6 > h2:nth-child(2)")
	WebElement text;
	By text_cartInfo=By.className("layer_cart_product_info");

	//	@FindBy (className="layer_cart_product_info")
	//	WebElement cartInfo;

	public AutomationSignupPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void AutomationSignIn() {
		driver.findElement(link_signin).click();
	}

	public void setEmailAddress(String text) {
		driver.findElement(textbox_email).click();
		driver.findElement(textbox_email).sendKeys(text);
	}

	public void setPassword(String text) {
		driver.findElement(textbox_password).click();
		driver.findElement(textbox_password).sendKeys(text);
	}

	public void clickOnSignIn() {
		driver.findElement(button_signin).click();
	}

	public void clickTshirt() {
		driver.findElement(button_tshirt).click();
	}

	public void selectTshirt() {
		driver.findElement(image_tshirt).click();
	}

	public void clickaddtocart() {
		driver.findElement(button_addtocart).click();
	}

	public void clickproceedtocheckout() {
		driver.findElement(button_proceedtocheckout).click();
	}

	public String verifytitleproductadded() {
		String actualText = text.getText();
		System.out.println(actualText);
		return actualText;
	}

	public void verifyProductDetails() {
		String TitleShirt= ((WebElement) text_cartInfo).getText();
		TitleShirt.trim();
		cartInfoText.trim();
		System.out.println(TitleShirt)
		;System.out.println(cartInfoText);

		if(cartInfoText.equalsIgnoreCase(TitleShirt)) {
			Assert.assertTrue(true, "Texts are identical");
		}else {
			Assert.assertTrue(false, "Texts are mismatch");
		}


	}
}

