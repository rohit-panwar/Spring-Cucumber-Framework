package com.qa.automation.helpers;

import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class SeleniumWebDriver {

    private WebDriver driver;
    private int a;

    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        return driver;
    }

    public void printMessage(){
        System.out.println("--------------- I am Autowired --------------");
    }

}
