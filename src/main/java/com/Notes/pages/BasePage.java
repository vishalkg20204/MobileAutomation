package com.Notes.pages;

import com.Notes.utils.DriverManager;
import com.Notes.utils.GlobalParams;
import com.Notes.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BasePage {
    AppiumDriver driver;
    TestUtils utils = new TestUtils();

    public BasePage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }


    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void closeApp() {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                        getCapability("bundleId").toString());
        }
    }

    public void launchApp() {
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                        getCapability("bundleId").toString());
        }
    }

    public void swipeRight() throws InterruptedException {
        Thread.sleep(2000);
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        int startX = (int) (screenWidth * 0.2);  // 20% of screen width
        int endX = (int) (screenWidth * 0.65);   // Move to 85% to extend swipe more
        int y = screenHeight / 2;                // Mid-screen height

        // Create Pointer Input for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),  // Increased duration for smoother swipe
                PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeUp() {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        int startY = (int) (screenHeight * 0.8);  // Start from 80% of screen height (lower part)
        int endY = (int) (screenHeight * 0.2);    // Move up to 20% (higher up for extended movement)
        int x = screenWidth / 2;                  // Keep swipe in center of screen

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),  // Increased duration for smoother swipe
                PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeDown() {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        int startY = (int) (screenHeight * 0.2);  // Start from 20% of screen height (higher up)
        int endY = (int) (screenHeight * 0.8);    // Move down to 80% (lower part)
        int x = screenWidth / 2;                  // Keep swipe in center of screen

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),  // Smooth swipe
                PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeLeft() throws InterruptedException {
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;

        int startX = (int) (screenWidth * 0.8);
        int endX = (int) (screenWidth * 0.2);
        int y = screenHeight / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void enterTextWithKeyPress(AndroidDriver driver, String text) {
        for (char c : text.toCharArray()) {
            AndroidKey key = getAndroidKey(c);
            if (key != null) {
                driver.pressKey(new KeyEvent(key));
            }
        }
    }

    // Helper method to map characters to AndroidKey
    private AndroidKey getAndroidKey(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
                return AndroidKey.A;
            case 'b':
                return AndroidKey.B;
            case 'c':
                return AndroidKey.C;
            case 'd':
                return AndroidKey.D;
            case 'e':
                return AndroidKey.E;
            case 'f':
                return AndroidKey.F;
            case 'g':
                return AndroidKey.G;
            case 'h':
                return AndroidKey.H;
            case 'i':
                return AndroidKey.I;
            case 'j':
                return AndroidKey.J;
            case 'k':
                return AndroidKey.K;
            case 'l':
                return AndroidKey.L;
            case 'm':
                return AndroidKey.M;
            case 'n':
                return AndroidKey.N;
            case 'o':
                return AndroidKey.O;
            case 'p':
                return AndroidKey.P;
            case 'q':
                return AndroidKey.Q;
            case 'r':
                return AndroidKey.R;
            case 's':
                return AndroidKey.S;
            case 't':
                return AndroidKey.T;
            case 'u':
                return AndroidKey.U;
            case 'v':
                return AndroidKey.V;
            case 'w':
                return AndroidKey.W;
            case 'x':
                return AndroidKey.X;
            case 'y':
                return AndroidKey.Y;
            case 'z':
                return AndroidKey.Z;
            case '0':
                return AndroidKey.DIGIT_0;
            case '1':
                return AndroidKey.DIGIT_1;
            case '2':
                return AndroidKey.DIGIT_2;
            case '3':
                return AndroidKey.DIGIT_3;
            case '4':
                return AndroidKey.DIGIT_4;
            case '5':
                return AndroidKey.DIGIT_5;
            case '6':
                return AndroidKey.DIGIT_6;
            case '7':
                return AndroidKey.DIGIT_7;
            case '8':
                return AndroidKey.DIGIT_8;
            case '9':
                return AndroidKey.DIGIT_9;
            case ' ':
                return AndroidKey.SPACE;
            default:
                return null;
        }
    }
}