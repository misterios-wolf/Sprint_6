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

    // Выбранный срок аренды
    private By selectedRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder is-selected']");

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

    // Кнопка подтверждения заказа «Да»
    private By confirmOrderButton = By.xpath(".//div[contains(@class, 'Order_Modal')]//button[text()='Да']");

    // Заголовок успешного оформления заказа
    private By orderSuccessHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

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

    // Получение введённой даты доставки
    public String getDeliveryDate() {
        return driver.findElement(deliveryDateInput).getAttribute("value");
    }

    // Открытие списка «Срок аренды»
    public void clickRentalPeriodDropdown() {
        driver.findElement(rentalPeriodDropdown).click();
    }

    // Выбор срока аренды
    public void setRentalPeriod(String period) {
        driver.findElements(rentalPeriodOptions).stream()
                .filter(option -> option.getText().equals(period))
                .findFirst()
                .get()
                .click();
    }

    // Получение выбранного срока аренды
    public String getRentalPeriod() {
        return driver.findElement(selectedRentalPeriod).getText();
    }

    // Выбор чёрного цвета самоката
    public void selectBlackColor() {
        driver.findElement(blackColorCheckbox).click();
    }

    // Проверка выбора чёрного цвета самоката
    public boolean isBlackColorSelected() {
        return driver.findElement(blackColorCheckbox).isSelected();
    }

    // Ввод комментария для курьера
    public void setComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    // Получение введённого комментария
    public String getComment() {
        return driver.findElement(commentInput).getAttribute("value");
    }

    // Метод нажатия на кнопку «Заказать»
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // Метод подтверждения заказа
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    // Проверка успешного оформления заказа
    public boolean isOrderSuccessDisplayed() {
        return driver.findElement(orderSuccessHeader).getText().contains("Заказ оформлен");
    }
}
