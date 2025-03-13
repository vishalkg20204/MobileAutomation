package com.Notes.stepdef;

import com.Notes.pages.TextNoteCreatePage;
import com.Notes.utils.Constants;
import com.Notes.utils.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TextNoteCreateStepDef {

    private final PageObjectManager pageObjectManager;
    private final TextNoteCreatePage textNoteCreatePage;
    private String actualNoteTitle;
    private String actualNoteParagraph;

    public TextNoteCreateStepDef() {
        this.pageObjectManager = new PageObjectManager();
        this.textNoteCreatePage = pageObjectManager.getTextNoteCreatePage();
    }

    @Given("user is on launcher page")
    public void userIsOnLauncherPage() throws InterruptedException {
        textNoteCreatePage.clickOnNotesFloatingWidget();
    }

    @And("user clicks on plus icon")
    public void userClicksOnPlusIcon() {
        textNoteCreatePage.dismissAppRatingPopupIfVisible();
        Assert.assertTrue("Plus Icon should be visible", textNoteCreatePage.isPlusIconDisplayed());
        textNoteCreatePage.clickOnPlusIcon();
    }

    @And("tap on create a text note from menu options shown")
    public void tapOnCreateATextNoteFromMenuOptionsShown() {
        Assert.assertTrue("Create a text Note Label should be visible", textNoteCreatePage.isCreateTextNoteLabelDisplayed());
        Assert.assertEquals(Constants.CREATE_A_TEXT_NOTE, textNoteCreatePage.getCreateTextNoteLabel());
        textNoteCreatePage.clickOnCreateTextNoteBtn();
    }

    @And("create a note with title and paragraph")
    public void createANoteWithTitleAndParagraph() throws InterruptedException {
        Assert.assertTrue("Note Title Placeholder should be visible", textNoteCreatePage.isNoteTitlePlaceholderDisplayed());
        Assert.assertEquals(Constants.TITLE_PLACEHOLDER_LABEL, textNoteCreatePage.getNoteTitlePlaceholderLabel());
        textNoteCreatePage.clickOnNoteTitlePlaceholder();
        textNoteCreatePage.addTitleToNote();
        actualNoteTitle = textNoteCreatePage.getNoteTitlePlaceholderLabel();
        Assert.assertTrue("Note Paragraph Placeholder should be visible", textNoteCreatePage.isNoteParagraphPlaceholderDisplayed());
        Assert.assertEquals(Constants.CREATE_A_TEXT_NOTE_PARAGRAPH_PLACEHOLDER_LABEL, textNoteCreatePage.getNoteParagraphPlaceholderLabel());
        textNoteCreatePage.addParagraphToNote();
        actualNoteParagraph = textNoteCreatePage.getNoteParagraphPlaceholderLabel();
    }

    @And("click on save button")
    public void clickOnSaveButton() {
        Assert.assertTrue("Save Button should be visible", textNoteCreatePage.isSaveButtonDisplayed());
        Assert.assertEquals(Constants.SAVE_BUTTON, textNoteCreatePage.getSaveButtonLabel());
        textNoteCreatePage.clickOnSaveButton();
    }

    @Then("verify the saved notes is shown on My Notes page")
    public void verifyTheSavedNotesIsShownOnMyNotesPage() {
        Assert.assertTrue("Note Content Preview should be visible", textNoteCreatePage.isNoteContentPreviewDisplayed());
        Assert.assertTrue("All (1) should be visible", textNoteCreatePage.isAllCountDisplayed());
        Assert.assertEquals(Constants.ALL, textNoteCreatePage.getAllCountLabel());
        String contentPreviewNoteTitle = textNoteCreatePage.getNoteTitlePlaceholderLabel();
        System.out.println("content preview note title: " + contentPreviewNoteTitle);
        Assert.assertEquals("Input and Preview Note title should be same", actualNoteTitle, contentPreviewNoteTitle);
        String contentPreviewNoteParagraph = textNoteCreatePage.getNotePreviewParagraphLabel();
        System.out.println("content preview note paragraph: " + contentPreviewNoteTitle);
        Assert.assertEquals("Input and Preview Note paragraph should be same", actualNoteParagraph, contentPreviewNoteParagraph);
    }
}