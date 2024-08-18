package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testCaseLogin {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("buka browser");

        // Mengambil title web
        String txtTitle = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        System.out.println(txtTitle);

        // input login
        System.out.println("\ninput username");
        delay(3);
        // input username
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        String userName = username.getAttribute("value");

        // validasi username
        delay(3);
        String expectedUsername = "standard_user";
        validasi(userName,expectedUsername);

        System.out.println("\ninput password");
        //input password
        delay(3);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys( "secret_sauce");
        String passWord = password.getAttribute("value");

        //validasi password
        String expectedPassword = "secret_sauce";
        validasi(passWord,expectedPassword);

        //klik login
        delay(3);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();


        delay(5);
        driver.quit();
        System.out.println("\nKeluar browser");
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void validasi(String actual,String expected){
        if (actual.equals(expected)){
            System.out.println("Hasil : berhasil");
        }else {
            System.out.println("Hasil : gagal");
        }
    }
}
