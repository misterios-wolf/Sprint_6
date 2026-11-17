package pages;

import org.openqa.selenium.By;

public class MainPage {

    // Кнопка «Заказать» вверху страницы
    private By orderButtonHeader = By.xpath(".//button[@class='Button_Button__ra12g']");

    // Кнопка «Заказать» внизу страницы
    private By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    // Заголовки вопросов в разделе «Вопросы о важном»
    private By accQuestions = By.xpath(".//*[@class='accordion__button']");

    // Блоки с ответами на вопросы
    private By accAnswers = By.xpath(".//*[@class='accordion__panel']");
}
