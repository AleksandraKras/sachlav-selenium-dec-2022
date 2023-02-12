package lesson_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;

public class Homework_selenium_02 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.next();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://devexpress.github.io/testcafe/example/");
        driver.findElement(By.id("developer-name")).sendKeys(name);
        driver.findElement(By.id("remote-testing")).click();
        driver.findElement(By.id("reusing-js-code")).click();
        driver.findElement(By.id("background-parallel-testing")).click();
        driver.findElement(By.id("continuous-integration-embedding")).click();
        driver.findElement(By.id("traffic-markup-analysis")).click();
        driver.findElement(By.id("tried-test-cafe")).click();


        WebElement slider = driver.findElement(By.id("slider"));
        Actions action = new Actions(driver);
        Action action1 = action.dragAndDropBy(slider, 100, 0).build();
        action1.perform();

        driver.findElement(By.id("comments")).sendKeys("Hello World");
        Thread.sleep(2000);
        driver.findElement(By.id("submit-button")).click();
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals("https://devexpress.github.io/testcafe/example/thank-you.html")) {
            String Hello = driver.findElement(By.id("article-header")).getText();
            if (Hello.equals("Thank you, " + name + "!")) {
                String title = driver.getTitle();
                if (title.equals("Thank you!")) {
                    System.out.println("All correct, goodbye!");
                } else {
                    System.out.println("Title is incorrect");
                }
            } else {
                System.out.println("Greeting is incorrect");
            }
        } else {
            System.out.println("Invalid URL");
        }
        Thread.sleep(5000);
        scanner.close();
        driver.quit();
    }
}

