package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Проверка заполнения формы - Для кого самокат
    @Test
    public void checkNextButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setName("Кирилл");
        orderPage.setSurname("Семенов");
        orderPage.setAddress("Санкт-Петербург, улица тест, 10");
        orderPage.setMetroStation();
        orderPage.setPhone("89991234567");
        orderPage.clickNextButton();

        assertTrue(orderPage.isDeliveryDateDisplayed());
        orderPage.setDeliveryDate("22.11.2026");
        assertEquals("22.11.2026", orderPage.getDeliveryDate());
        orderPage.clickRentalPeriodDropdown();
        orderPage.setRentalPeriod("двое суток");
        assertEquals("двое суток", orderPage.getRentalPeriod());
        orderPage.selectBlackColor();
        assertTrue(orderPage.isBlackColorSelected());
        orderPage.setComment("Позвонить за 1 час до доставки");
        assertEquals("Позвонить за 1 час до доставки", orderPage.getComment());
        orderPage.clickOrderButton();

        orderPage.clickConfirmOrderButton();
        assertTrue(orderPage.isOrderSuccessDisplayed());
    }
}
