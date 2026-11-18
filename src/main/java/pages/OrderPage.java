package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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

    // Поле «Когда привезти самокат»
    private By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Выпадающий список «Срок аренды»
    private By rentalPeriodDropdown = By.xpath(".//*[@class='Dropdown-control']");

    // Варианты срока аренды
    private By rentalPeriodOptions = By.xpath(".//*[@class='Dropdown-option']");

    // Чекбокс «чёрный жемчуг»
    private By blackColorCheckbox = By.xpath(".//input[@id='black']");

    // Чекбокс «серая безысходность»
    private By greyColorCheckbox = By.xpath(".//input[@id='grey']");

    // Поле «Комментарий для курьера»
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка «Назад»
    private By backButton = By.xpath(".//button[text()='Назад']");

    // Кнопка «Заказать» на втором шаге формы
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

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

        driver.findElement(By.xpath(".//*[text()='Чистые пруды']")).click();
    }

    // Метод ввода телефона
    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    // Метод нажатия на кнопку «Далее»
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // Проверка отображения поля даты доставки
    public boolean isDeliveryDateDisplayed() {
        return driver.findElement(deliveryDateInput).isDisplayed();
    }

    // Метод ввода даты доставки
    public void setDeliveryDate(String date) {
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDateInput).sendKeys(Keys.ENTER);
    }

    // Метод нажатия на кнопку «Заказать»
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
