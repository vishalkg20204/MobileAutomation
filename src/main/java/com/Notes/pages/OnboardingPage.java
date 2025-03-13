package com.Notes.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn']")
    private WebElement getStartedBtn;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/arrowIcon']")
    private WebElement getStartedArrowBtn;
    @AndroidFindBy(xpath = "//*[@resource-id='com.android.permissioncontroller:id/icon_frame']")
    private WebElement notesLauncherIcon;
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/title']")
    private WebElement notesLauncherLabel;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/ivIcon']")
    private WebElement notesLauncherFloatingWidget;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/left_arrow']")
    private WebElement notesLauncherArrowBn;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/title']")
    private WebElement swipeRightInfoLabel;
    @AndroidFindBy(xpath = "//*[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_create_note']")
    private WebElement createNoteBtn;

    public OnboardingPage(AppiumDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isGetStartedButtonDisplayed() {
        waitForVisibility(getStartedArrowBtn);
        return getStartedBtn.isDisplayed();
    }

    public String getGetStartedButtonText() {
        return getStartedBtn.getText();
    }

    public void tapGetStarted() {
        waitForVisibility(getStartedBtn);
        getStartedBtn.click();
    }

    public boolean isNotesLauncherRadioBtnDisplayed() {
        waitForVisibility(notesLauncherIcon);
        return notesLauncherLabel.isDisplayed();
    }

    public String getNotesLauncherLabel() {
        return notesLauncherLabel.getText();
    }

    public void clickOnNotesLauncherRadioBtn() {
        notesLauncherLabel.click();
    }

    public boolean isNotesFloatingWidgetDisplayed() {
        waitForVisibility(notesLauncherFloatingWidget);
        return notesLauncherFloatingWidget.isDisplayed();
    }

    public boolean isArrowBtnDisplayed() {
        return notesLauncherArrowBn.isDisplayed();
    }

    public boolean isSwipeRightInfoDisplayed() {
        return swipeRightInfoLabel.isDisplayed();
    }

    public void clickOnFloatingWidget() {
        notesLauncherFloatingWidget.click();
    }

    public boolean isCreateNoteBtnDisplayed() {
        return createNoteBtn.isDisplayed();
    }
}
