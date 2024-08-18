package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addProduct {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String url = "https://www.saucedemo.com/inventory.html";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("buka browser");

        System.out.println("\ninput username");
        delay(3);
        // input username
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        System.out.println("\ninput password");
        //input password
        delay(3);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys( "secret_sauce");

        //klik login
        delay(3);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Mengambil title web
        delay(3);
        String txtTitle = driver.findElement(By.className("app_logo")).getText();
        System.out.println(txtTitle);

        //validasi teks backpack di halaman produk
        delay(3);
        System.out.println("\nProduk Backpack");
        String backpackProduct = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
        String expected = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
        validasi(backpackProduct,expected);

        //klik add to cart
        delay(3);
        System.out.println("\nTambah produk Backpack");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        //klik logo cart
        delay(3);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //validasi teks backpack di cart
        delay(3);
        System.out.println("\nKonfirmasi Backpack");
        String confirmBackpack = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        validasi(confirmBackpack,expected);

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
