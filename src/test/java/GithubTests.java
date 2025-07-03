import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import steps.GitHubSearchSteps;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubTests extends BaseTest {

    SearchPage searchPage = new SearchPage();
    GitHubSearchSteps step = new GitHubSearchSteps(searchPage);

    @Test
    @DisplayName("Проверка табика issue на проекте allure - тест с лямбда")
    void checkIssueTabTest() {
        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Набираем в поиске allure и поиск", () -> {
            searchPage.getButtonSearch().click();
            searchPage.getSearchInput().setValue("allure").submit();
        });
        step("Переходим на allure-java", () -> {
            searchPage.getAllureJavaHref().click();
        });
        step("Проверка наличия issues", () -> {
            searchPage.getIssuesTab().should(Condition.exist);
        });
    }


    @Test
    @DisplayName("Проверка табика projects на своём проекте qa_quru35_lesson9 - тест с аннотацией Step")
    void checkProjectsTabTest() {
        step.openGithub();
        step.searchByLettersAndSubmit("qa_quru35_lesson9");
        step.goByLink(searchPage.getQaGuru35Lesson9Link());
        step.checkElementExists(searchPage.getProjectsTab());
    }

    @Test
    @DisplayName("Проверка табика issue на проекте allure с простыми шагами селенид")
    void checkSimpleSeleniedStepsTest(){
        open("");
        searchPage.getButtonSearch().click();
        searchPage.getSearchInput().setValue("allure").submit();
        searchPage.getAllureJavaHref().click();
        searchPage.getIssuesTab().should(Condition.exist);
    }

}
