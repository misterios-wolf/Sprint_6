package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    // Кнопка «Заказать» вверху страницы
    private By orderButtonHeader = By.xpath(".//button[@class='Button_Button__ra12g']");

    // Кнопка «Заказать» внизу страницы
    private By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    // Заголовки вопросов в разделе «Вопросы о важном»
    private By accQuestions = By.xpath(".//*[@class='accordion__button']");

    // Блоки с ответами на вопросы
    private By accAnswers = By.xpath(".//*[@class='accordion__panel']");

    // Кнопка закрытия плашки cookies
    private By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод закрытия плашки cookies
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // Метод нажатия на верхнюю кнопку «Заказать»
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    // Метод нажатия на нижнюю кнопку «Заказать»
    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    // Метод нажатия на вопрос по его индексу
    public void clickAccordionQuestion(int index) {
        driver.findElements(accQuestions).get(index).click();
    }

    // Метод получения текста ответа по его индексу
    public String getAccordionAnswer(int index) {
        return driver.findElements(accAnswers).get(index).getText();
    }
    // Метод для проверки отображения ответа
    public boolean isAccordionAnswerVisible(int index) {
        return driver.findElements(accAnswers).get(index).isDisplayed();
    }
}
