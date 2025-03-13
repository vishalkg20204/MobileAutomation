package com.Notes.utils;

import com.Notes.pages.OnboardingPage;
import com.Notes.pages.TextNoteCreatePage;
import com.Notes.pages.ToDoListCreationPage;
import io.appium.java_client.AppiumDriver;

public class PageObjectManager {

    public static OnboardingPage onboardingPage;
    public static TextNoteCreatePage textNoteCreatePage;
    public static ToDoListCreationPage toDoListCreationPage;

    private final AppiumDriver driver;

    public PageObjectManager() {
        this.driver = DriverManager.getDriver();
        if (driver == null) {
            throw new RuntimeException("Driver is null in PageObjectManager");
        }
        toDoListCreationPage = new ToDoListCreationPage(driver);
    }

    public OnboardingPage getOnboardingPage() {
        if (onboardingPage == null) {
            onboardingPage = new OnboardingPage(driver);
        }
        return onboardingPage;
    }

    public TextNoteCreatePage getTextNoteCreatePage() {
        if (textNoteCreatePage == null) {
            textNoteCreatePage = new TextNoteCreatePage(driver);
        }
        return textNoteCreatePage;
    }
}