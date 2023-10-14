package components;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class VerifyUrlComponent {
    public VerifyUrlComponent verifyUrl(String pageUrl) {
        webdriver().shouldHave(url(pageUrl));
        return this;
    }
}
