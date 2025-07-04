package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class SearchPage {
    private SelenideElement buttonSearch = $("[data-target='qbsearch-input.inputButton']");
    private SelenideElement searchInput = $("#query-builder-test");
    private SelenideElement allureJavaHref = $(byLinkText("allure-framework/allure-java"));
    private SelenideElement issuesTab = $("#issues-tab");
    private SelenideElement projectsTab = $("#projects-tab");

}
