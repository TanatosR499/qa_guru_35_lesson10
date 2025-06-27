package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;

public class GitHubSearchSteps {

    SearchPage page;

    public GitHubSearchSteps(SearchPage page) {
        this.page = page;
    }

    @Step("Открыть главную страницу гитхаб")
    public void openGithub() {
        open("");
    }

    @Step("Набираем текст \"{letters}\" в поиске и осуществляем поиск")
    public void searchByLettersAndSubmit(String letters) {
        page.getButtonSearch().click();
        page.getSearchInput().setValue(letters).submit();
    }

    @Step("Переходим по клику на элемент {element}")
    public void goByLink(SelenideElement element) {
        element.click();
    }

    @Step("Проверка существования элемента {element}")
    public void checkElementExists(SelenideElement element) {
        element.should(Condition.exist);
    }

}
