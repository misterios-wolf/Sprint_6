package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
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

    // Проверка ввода и отображения названия станции метро в форме заказа
    @Test
    public void checkMetroStation() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setMetroStation();

        assertEquals("Чистые пруды", orderPage.getMetroStation());
    }
}
