package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.get("https://qa-scooter.education-services.ru/");
        // Для запуска тестов в Firefox выполни команду:
        // mvn "-Dtest=pages.OrderPageTest" "-Dbrowser=firefox" test
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of("Кирилл", "Семенов", "Санкт-Петербург, улица тест, 10", "89991234567", "header"),
                Arguments.of("Иван", "Иванов", "Санкт-Петербург, улица тест, 20", "89998765432", "bottom")
        );
    }

    // Проверка заполнения формы - Для кого самокат
    @ParameterizedTest
    @MethodSource("orderData")
    public void checkOrder(String name, String surname, String address, String phone, String button) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();

        if (button.equals("header")) {
            mainPage.clickOrderButtonHeader();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetroStation();
        orderPage.setPhone(phone);
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
