package tests;

import components.VerifyUrlComponent;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.QaGuruPage;

import java.util.stream.Stream;


@Tag("fast")
public class QaGuruTests extends TestBase {
    QaGuruPage qaGuruPage = new QaGuruPage();
    VerifyUrlComponent verify = new VerifyUrlComponent();

    @CsvSource(value = {
            "Курсы Java+, https://qa.guru/java-advanced",
            "Курсы Python, https://qa.guru/python"
    })
    @ParameterizedTest(name = "При нажатии на {0}, переход на страницу {1}")
    @Tags({@Tag("UI"), @Tag("Smoke")})
    void checkAllCoursesTest(String clickLink, String currentUrl) {
        qaGuruPage.openPage();
        qaGuruPage.clickNavibarLink(clickLink);
        verify.verifyUrl(currentUrl);
    }

    @CsvFileSource(resources = "/test_data.csv")
    @ParameterizedTest(name = "При нажатии на {0}, переход на страницу {1} и проверка наличия {2} стек технологии")
    @Tags({@Tag("UI"), @Tag("Stack")})
    void checkStackOnCoursesTest(String clickLink, String courseStack, String currentUrl) {

        qaGuruPage.openPage();
        qaGuruPage.clickNavibarLink(clickLink);
        qaGuruPage.searchStack(courseStack);
        verify.verifyUrl(currentUrl);
    }

    static Stream<Arguments> checkStackTest() {
        return Stream.of(
                Arguments.of("Курсы Java+", "gRPC", "https://qa.guru/java-advanced"),
                Arguments.of("Курсы Python", "Pytest", "https://qa.guru/python")
        );
    }

    @MethodSource("checkStackTest")
    @ParameterizedTest(name = "При нажатии на {0}, переход на страницу {1} и проверка наличия {2} стек технологии")
    @Tags({@Tag("Stack"), @Tag("Arguments")})
    void checkStackOnCoursesWithStreamTest(String clickLink, String courseStack, String currentUrl) {
        qaGuruPage.openPage();
        qaGuruPage.clickNavibarLink(clickLink);
        qaGuruPage.searchStack(courseStack);
        verify.verifyUrl(currentUrl);
    }


}
