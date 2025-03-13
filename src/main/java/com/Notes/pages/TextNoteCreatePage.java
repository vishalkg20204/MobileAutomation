package com.Notes.pages;

import com.Notes.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TextNoteCreatePage extends BasePage {


    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/iv_icon']")
    private WebElement notesFloatingWidget;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/right_arrow']")
    private WebElement swipeLeftArrow;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/up_arrow']")
    private WebElement swipeUpArrow;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_create_note']")
    private WebElement plusIcon;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/tv_like']")
    private WebElement appRatingLike;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/touch_outside']")
    private WebElement appRatingOutsideView;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_text_note']")
    private WebElement createTextNoteLabel;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_text_note']")
    private WebElement createTextNoteButton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title']")
    private WebElement noteTitlePlaceholder;
    @AndroidFindBy(xpath = "//*[@resource-id='editor']")
    private WebElement noteParagraphPlaceholder;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_save']")
    private WebElement saveButton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_content_preview']")
    private WebElement noteContentPreview;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/category_text']")
    private WebElement allCount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='this is a new note']")
    private WebElement notePreviewParagraph;

    public TextNoteCreatePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnDirectionalArrowsOnLauncher() throws InterruptedException {
        waitForVisibility(swipeLeftArrow);
        swipeLeftArrow.click();
        swipeRight();
        waitForVisibility(swipeUpArrow);
        swipeUpArrow.click();
        swipeDown();
    }

    public void clickOnNotesFloatingWidget() throws InterruptedException {
        if (shouldClickDirectionalArrows()) {
            clickOnDirectionalArrowsOnLauncher();
        }

        if (!isElementVisible(notesFloatingWidget)) {
            swipeRight();
            Thread.sleep(1000);
        }

        waitForVisibility(notesFloatingWidget);
        notesFloatingWidget.click();
    }

    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean shouldClickDirectionalArrows() {
        try {
            return swipeLeftArrow.isDisplayed() || swipeUpArrow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void dismissAppRatingPopupIfVisible() {
        try {
            if (appRatingLike.isDisplayed()) {
                appRatingOutsideView.click();
                System.out.println("App rating popup dismissed.");
            }
        } catch (Exception e) {
            System.out.println("App rating popup not displayed. Skipping.");
        }
    }

    public boolean isPlusIconDisplayed() {
        return plusIcon.isDisplayed();
    }

    public void clickOnPlusIcon() {
        plusIcon.click();
    }

    public boolean isCreateTextNoteLabelDisplayed() {
        return createTextNoteLabel.isDisplayed();
    }

    public String getCreateTextNoteLabel() {
        return createTextNoteLabel.getText();
    }

    public void clickOnCreateTextNoteBtn() {
        createTextNoteButton.click();
    }

    public boolean isNoteTitlePlaceholderDisplayed() {
        return noteTitlePlaceholder.isDisplayed();
    }

    public String getNoteTitlePlaceholderLabel() {
        return noteTitlePlaceholder.getText();
    }

    public void clickOnNoteTitlePlaceholder() {
        noteTitlePlaceholder.click();
    }

    public void addTitleToNote() {
        noteTitlePlaceholder.sendKeys(Constants.CREATE_A_TEXT_NOTE_TITLE);
    }

    public boolean isNoteParagraphPlaceholderDisplayed() {
        return noteParagraphPlaceholder.isDisplayed();
    }

    public String getNoteParagraphPlaceholderLabel() {
        return noteParagraphPlaceholder.getText();
    }

    public void addParagraphToNote() {
        enterTextWithKeyPress((AndroidDriver) driver, Constants.CREATE_A_TEXT_NOTE_PARAGRAPH);
    }

    public boolean isSaveButtonDisplayed() {
        return saveButton.isDisplayed();
    }

    public String getSaveButtonLabel() {
        return saveButton.getText();
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public boolean isNoteContentPreviewDisplayed() {
        return noteContentPreview.isDisplayed();
    }

    public boolean isAllCountDisplayed() {
        return allCount.isDisplayed();
    }

    public String getAllCountLabel() {
        return allCount.getText();
    }

    public String getNotePreviewParagraphLabel() {
        return notePreviewParagraph.getText();
    }
}