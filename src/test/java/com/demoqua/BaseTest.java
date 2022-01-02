package com.demoqua;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class BaseTest {

    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    public static void before() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = credentials.baseUrl();
        System.out.println(format("https://%s:%s@%s", credentials.login(), credentials.password(),credentials.removeUrl()));
        Configuration.remote = format("https://%s:%s@%s", credentials.login(), credentials.password(),credentials.removeUrl());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
