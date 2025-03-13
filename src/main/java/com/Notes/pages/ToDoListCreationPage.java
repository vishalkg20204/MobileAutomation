package com.Notes.pages;

import com.Notes.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ToDoListCreationPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_todo_note']")
    private WebElement toDoListIcon;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_todo_note']")
    private WebElement toDoListLabel;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title']")
    private WebElement todoListTitlePlaceholder;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/add_item']")
    private WebElement addListItem;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/delete_todo']")
    private WebElement crossBtn;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id']")
    private WebElement addFirstItemF;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id'])[2]")
    private WebElement addSecondItemF;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id'])[3]")
    private WebElement addThirdItemF;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_color_change']")
    private WebElement colorChangeBtn;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/color_list']")
    private WebElement colorList;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/color_item']")
    private List<WebElement> colorOption;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/title']")
    private WebElement changeBackgroundHeader;
    private String toDoTaskXpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/todo_%d']";
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/category_text']")
    private WebElement allCategoryTab;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_content_preview']")
    private WebElement contentPreviewCard;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='To-do lists'])[2]")
    private WebElement toDoListContentPreviewHeader;

    public ToDoListCreationPage(AppiumDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isToDoListLabelDisplayed() {
        waitForVisibility(toDoListIcon);
        return toDoListLabel.isDisplayed();
    }

    public String getToDoListLabel() {
        return toDoListLabel.getText();
    }

    public void clickOnToDoListIcon() {
        toDoListIcon.click();
    }

    public boolean isTitlePlaceholderDisplayed() {
        waitForVisibility(crossBtn);
        return todoListTitlePlaceholder.isDisplayed();
    }

    public String getTodoListTitlePlaceholderLabel() {
        return todoListTitlePlaceholder.getText();
    }

    public void clickOnTitle() {
        todoListTitlePlaceholder.click();
    }

    public void addTitle() {
        sendKeys(todoListTitlePlaceholder, Constants.CREATE_A_TO_DO_LIST_TITLE);
    }

    public void addFirstListItem() {
        sendKeys(addFirstItemF, Constants.TASK_1);
    }

    public void addSecondListItem() {
        sendKeys(addSecondItemF, Constants.TASK_2);
    }

    public void addThirdListItem() {
        sendKeys(addThirdItemF, Constants.TASK_3);
    }

    public void clickOnAddListItem() {
        addListItem.click();
    }

    public boolean isColorChangeBtnDisplayed() {
        return colorChangeBtn.isDisplayed();
    }

    public void clickOnColorChangeBtn() {
        colorChangeBtn.click();
    }

    public boolean isColorOptionsDisplayed() {
        waitForVisibility(changeBackgroundHeader);
        return colorList.isDisplayed();
    }

    public void clickOnGreenColorOption() {
        colorOption.get(3).click();
    }

    public boolean isToDoTaskDisplayed(int index) {
        try {
            WebElement taskElement = driver.findElement(By.xpath(String.format(toDoTaskXpath, index)));
            return taskElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getToDoTaskLabel(int index) {
        return driver.findElement(By.xpath(String.format(toDoTaskXpath, index))).getText();
    }

    public boolean isContentPreviewCardDisplayed() {
        waitForVisibility(toDoListContentPreviewHeader);
        return contentPreviewCard.isDisplayed();
    }

    public String getAllCategoryTabLabel() {
        String text = allCategoryTab.getText();
        return text.substring(text.indexOf('(') + 1, text.indexOf(')')); // Extracts Count from All Tab
    }

}
