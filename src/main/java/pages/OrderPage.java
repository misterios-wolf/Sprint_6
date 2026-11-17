package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class OrderPage {

    private WebDriver driver;

    // Поле «Имя»
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");

    // Поле «Фамилия»
    private By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле «Адрес доставки»
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле «Станция метро»
    private By metroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");

    // Поле «Телефон»
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка «Далее»
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ввода имени
    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    // Метод ввода фамилии
    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    // Метод ввода адреса доставки
    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    // Метод выбора станции метро
    public void setMetroStation() {
        driver.findElement(metroStationInput).click();
        driver.findElement(metroStationInput).sendKeys("Чистые пруды");
    }

    // Метод получения выбранной станции метро
    public String getMetroStation() {
        return driver.findElement(metroStationInput).getAttribute("value");
    }

    // Метод ввода телефона
    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    // Метод нажатия на кнопку «Далее»
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}
