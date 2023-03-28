package com.rubatino.tcc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class RedirectLoginSteps {
    private WebDriver driver;

    @Given("I am on the website homepage")
    public void i_am_on_the_website_homepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
    }
    @When("I click on the login page button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("http://localhost:8080/login");
        driver.quit();
    }
}
