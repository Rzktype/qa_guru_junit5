package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QaGuruPage {
    SelenideElement titleLabel = $(".title"),
            naviBar = $(".main-header__menu"),
            stackIcons = $(".icons");

    public QaGuruPage openPage() {
        open("");
        titleLabel.shouldHave(Condition.text("Школа инженеров по автоматизации тестирования на Java"));
        return this;
    }

    public QaGuruPage clickNavibarLink(String value) {
        naviBar.$(byText(value)).click();
        return this;
    }

    public QaGuruPage searchStack(String value) {
        stackIcons.$(byText(value)).shouldHave();
        return this;
    }


}