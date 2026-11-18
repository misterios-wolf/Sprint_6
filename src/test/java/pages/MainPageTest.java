package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.education-services.ru/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Проверка первого вопроса и отображение текста ответа
    @Test
    public void checkFirstAccordionQuestion() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickCookieButton();
        mainPage.clickAccordionQuestion(0);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> mainPage.isAccordionAnswerVisible(0));

        assertTrue(mainPage.isAccordionAnswerVisible(0));
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                mainPage.getAccordionAnswer(0));
    }
}
