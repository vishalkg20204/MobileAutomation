package com.Notes.stepdef;

import com.Notes.pages.OnboardingPage;
import com.Notes.utils.Constants;
import com.Notes.utils.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OnboardingStepDef {
    private final OnboardingPage onboardingPage;

    public OnboardingStepDef(PageObjectManager pageObjectManager) {
        this.onboardingPage = pageObjectManager.getOnboardingPage();
    }

    @Given("the app is launched")
    public void theAppIsLaunched() {
        Assert.assertTrue("Get Started button should be visible", onboardingPage.isGetStartedButtonDisplayed());
    }

    @Then("the Get Started button should be visible")
    public void verifyGetStartedButtonVisibility() {
        Assert.assertTrue(Constants.ERROR_BUTTON_NOT_VISIBLE, onboardingPage.isGetStartedButtonDisplayed());
    }

    @Then("the Get Started button should have the correct text")
    public void verifyGetStartedButtonText() {
        Assert.assertEquals(Constants.ERROR_BUTTON_TEXT_MISMATCH,
                Constants.GET_STARTED_BUTTON_TEXT,
                onboardingPage.getGetStartedButtonText());
    }

    @When("the user taps on Get Started Button")
    public void theUserTapsOnGetStartedButton() {
        onboardingPage.tapGetStarted();
    }

    @And("selects Notes Launcher from settings")
    public void selectsNotesLauncherFromSettings() {
        Assert.assertTrue("Notes Launcher Radio Button should be visible", onboardingPage.isNotesLauncherRadioBtnDisplayed());
        Assert.assertEquals(Constants.NOTES_LAUNCHER,
                onboardingPage.getNotesLauncherLabel());
        onboardingPage.clickOnNotesLauncherRadioBtn();
    }

    @And("Notes floating widgets should appear with right swipe instructions")
    public void notesFloatingWidgetsShouldAppearWithRightSwipeInstructions() {
        Assert.assertTrue("Notes Floating Widget should be visible", onboardingPage.isNotesFloatingWidgetDisplayed());
        Assert.assertTrue("Arrow Button should be visible", onboardingPage.isArrowBtnDisplayed());
        Assert.assertTrue("Swipe Right Info should be visible", onboardingPage.isSwipeRightInfoDisplayed());
    }

    @And("click on floating widget")
    public void clickOnFloatingWidget() {
        onboardingPage.clickOnFloatingWidget();
    }

    @Then("the minus one screen should be displayed")
    public void theMinusOneScreenShouldBeDisplayed() {
        Assert.assertTrue("Create Note (+) Button should be visible", onboardingPage.isCreateNoteBtnDisplayed());
    }
}
