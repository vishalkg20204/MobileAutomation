package com.Notes.stepdef;

import com.Notes.utils.Constants;
import com.Notes.utils.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.Notes.utils.PageObjectManager.textNoteCreatePage;
import static com.Notes.utils.PageObjectManager.toDoListCreationPage;

public class ToDoListCreationStepDef {

    private String addedTitle;
    private int allTabCountBefore;

    public ToDoListCreationStepDef() {
        new PageObjectManager();
    }

    @Given("user clicks on floating widget of Notes app")
    public void userClicksOnFloatingWidgetOfNotesApp() throws InterruptedException {
        textNoteCreatePage.clickOnNotesFloatingWidget();
        allTabCountBefore = Integer.parseInt(toDoListCreationPage.getAllCategoryTabLabel());
    }

    @When("taps on create a to-do list from menu options shown")
    public void tapsOnCreateAToDoListFromMenuOptionsShown() {
        Assert.assertTrue("To-Do List text should be visible", toDoListCreationPage.isToDoListLabelDisplayed());
        Assert.assertEquals(Constants.CREATE_A_TO_DO_LIST, toDoListCreationPage.getToDoListLabel());
        toDoListCreationPage.clickOnToDoListIcon();
    }

    @And("create a to-do list with title")
    public void createAToDoListWithTitle() {
        Assert.assertTrue("Title Placeholder should be visible", toDoListCreationPage.isTitlePlaceholderDisplayed());
        Assert.assertEquals(Constants.TITLE_PLACEHOLDER_LABEL, toDoListCreationPage.getTodoListTitlePlaceholderLabel());
        toDoListCreationPage.clickOnTitle();
        toDoListCreationPage.addTitle();
        addedTitle = toDoListCreationPage.getTodoListTitlePlaceholderLabel();
    }

    @And("add list of items")
    public void addListOfItems() {
        toDoListCreationPage.addFirstListItem();
        toDoListCreationPage.clickOnAddListItem();
        toDoListCreationPage.addSecondListItem();
        toDoListCreationPage.clickOnAddListItem();
        toDoListCreationPage.addThirdListItem();
    }

    @And("click on color change icon")
    public void clickOnColorChangeIcon() {
        Assert.assertTrue("Color change button should be visible", toDoListCreationPage.isColorChangeBtnDisplayed());
        toDoListCreationPage.clickOnColorChangeBtn();
    }

    @And("change color to green")
    public void changeColorToGreen() {
        Assert.assertTrue("Green Color Option should be visible", toDoListCreationPage.isColorOptionsDisplayed());
        toDoListCreationPage.clickOnGreenColorOption();
    }

    @Then("verify the saved To-Do List shown on My Notes page")
    public void verifyTheSavedToDoListShownOnMyNotesPage() {
        Assert.assertTrue("To-Do List Content Preview card should be visible", toDoListCreationPage.isContentPreviewCardDisplayed());
        String titleInPreviewContent = toDoListCreationPage.getTodoListTitlePlaceholderLabel();
        Assert.assertEquals("Title should be same", addedTitle, titleInPreviewContent);
        String[] expectedTasks = {Constants.TASK_1, Constants.TASK_2, Constants.TASK_3};
        for (int i = 0; i < expectedTasks.length; i++) {
            int index = i + 1;
            Assert.assertTrue("To-Do Task " + index + " should be visible", toDoListCreationPage.isToDoTaskDisplayed(index));
            Assert.assertEquals("To-Do Task " + index + " should have correct label", expectedTasks[i], toDoListCreationPage.getToDoTaskLabel(index));
        }
        int allTabCountAfter = Integer.parseInt(toDoListCreationPage.getAllCategoryTabLabel());
        Assert.assertEquals(allTabCountAfter - allTabCountBefore, 1);
    }
}

