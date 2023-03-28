package com.rubatino.tcc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationAdminError {
    private WebDriver driver;
    @Given("I am a authenticated wrong user on website home page")
    public void i_am_on_the_website_homepage_as_an_authenticated_user() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/login");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("user@email.com");
        password.sendKeys("senha123");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
    }

    @When("I click on Home Admin button")
    public void i_click_on_the_home_admin_button() {
        WebElement admin = driver.findElement(By.name("admin"));
        admin.click();
    }

    @Then("I should see Forbidden Error")
    public void i_should_be_redirected_to_the_home_admin_page_with_error() {
        String error = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        assertThat(error).isEqualTo("Error Occurred");
        assertThat(currentUrl).isEqualTo("http://localhost:8080/home-admin");
        driver.quit();
    }
}
