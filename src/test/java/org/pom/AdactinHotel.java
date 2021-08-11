package org.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class AdactinHotel extends BaseClass {

		public static void main(String[] args) throws IOException, InterruptedException {

			getDriver();
			getUrl("https://adactinhotelapp.com/");
			
			// Login Page
			
			PojoLocatorsLoginPage locatorsLoginPage = new PojoLocatorsLoginPage();
			locatorsLoginPage.maximize();
			
			WebElement txtUserName = locatorsLoginPage.getTxtUserName();
			locatorsLoginPage.typeInput(txtUserName, locatorsLoginPage.getdata(1, 0));
			
			WebElement txtPassWord = locatorsLoginPage.getTxtPassword();
			locatorsLoginPage.typeInput(txtPassWord, locatorsLoginPage.getdata(1, 1));
			
			WebElement clkBtnLogin = locatorsLoginPage.getBtnLogin();
			locatorsLoginPage.buttonClick(clkBtnLogin);
			
			// Booking Page
			
			HotelBookingDetailsPage bookingDetails = new HotelBookingDetailsPage();
			
			WebElement locations = bookingDetails.getLocation();
			bookingDetails.selectByVisibleText(locations, bookingDetails.getdata(1, 2));
			
			WebElement hotel = bookingDetails.getHotels();
			bookingDetails.selectByVisibleText(hotel, bookingDetails.getdata(1, 3));
			
			WebElement roomtype = bookingDetails.getRoom_type();
			bookingDetails.selectByVisibleText(roomtype, bookingDetails.getdata(1, 4));
			
			WebElement noofroom = bookingDetails.getRoom_nos();
			bookingDetails.selectByVisibleText(noofroom, bookingDetails.getdata(1, 5));
			
			WebElement checkin = bookingDetails.getDatepick_in();
			bookingDetails.clear(checkin);
			bookingDetails.typeInput(checkin, bookingDetails.getdata(1, 6));
			bookingDetails.threadWait(1000);
			
			WebElement checkout = bookingDetails.getDatepick_out();
			bookingDetails.clear(checkout);
			bookingDetails.typeInput(checkout, bookingDetails.getdata(1, 7));
			
			WebElement personin = bookingDetails.getAdult_room();
			bookingDetails.selectByVisibleText(personin, bookingDetails.getdata(1, 8));
			
			WebElement children = bookingDetails.getChild_room();
			bookingDetails.selectByVisibleText(children, bookingDetails.getdata(1, 9));
			
			WebElement sumit = bookingDetails.getSubmit();
			bookingDetails.buttonClick(sumit);
			
			// Select Hotel Page
			
			SelectHotelPage hotelPage = new SelectHotelPage();
			WebElement selectHotel = hotelPage.getSelectHotel();
			hotelPage.buttonClick(selectHotel);
			WebElement continueclk = hotelPage.getContinueBtn();
			hotelPage.buttonClick(continueclk);

			// Booking Page

			PaymentPage PaymentPage = new PaymentPage();
			WebElement firstName = PaymentPage.getFirst_name();
			PaymentPage.typeInput(firstName, PaymentPage.getdata(1, 10));
			WebElement lastName = PaymentPage.getLast_name();
			PaymentPage.typeInput(lastName, PaymentPage.getdata(1, 11));
			WebElement billingAddress = PaymentPage.getAddress();
			PaymentPage.typeInput(billingAddress, PaymentPage.getdata(1, 12));
			WebElement creditCard = PaymentPage.getCardNum();
			PaymentPage.typeInput(creditCard, PaymentPage.getdata(1, 13));
			WebElement cardType = PaymentPage.getCardType();
			PaymentPage.selectByVisibleText(cardType, PaymentPage.getdata(1, 14));
			WebElement expiryMonth = PaymentPage.getExpMonth();
			PaymentPage.selectByVisibleText(expiryMonth, PaymentPage.getdata(1, 15));
			WebElement expiryDate = PaymentPage.getExpYear();
			PaymentPage.selectByVisibleText(expiryDate, PaymentPage.getdata(1, 16));
			WebElement cvvnumber = PaymentPage.getCvvNum();
			PaymentPage.typeInput(cvvnumber, PaymentPage.getdata(1, 17));
			WebElement bookClk = PaymentPage.getBook_now();
			PaymentPage.buttonClick(bookClk);
			Thread.sleep(6000);

			// OrderId Page
			
			OrderIdPage orderIdPage=new OrderIdPage();
			
			WebElement orderNo = orderIdPage.getOrderNo();
			orderIdPage.insertDataIntoExcel(1, 18, orderNo);
			orderIdPage.closeAllWindow();
		}

}
	
