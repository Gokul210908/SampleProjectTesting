package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(id="first_name")
	private WebElement first_name;
	
	@FindBy(id="last_name")
	private WebElement last_name;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement cardNum;
	
	@FindBy(id="cc_type")
	private WebElement cardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement expMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement expYear;
	
	@FindBy(id="cc_cvv")
	private WebElement cvvNum;
	

	@FindBy(id="book_now")
	private WebElement book_now;


	public WebElement getFirst_name() {
		return first_name;
	}


	public WebElement getLast_name() {
		return last_name;
	}


	public WebElement getAddress() {
		return address;
	}


	public WebElement getCardNum() {
		return cardNum;
	}


	public WebElement getCardType() {
		return cardType;
	}


	public WebElement getExpMonth() {
		return expMonth;
	}


	public WebElement getExpYear() {
		return expYear;
	}


	public WebElement getCvvNum() {
		return cvvNum;
	}


	public WebElement getBook_now() {
		return book_now;
	}
	
	
}
