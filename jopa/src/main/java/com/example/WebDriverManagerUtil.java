package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class WebDriverManagerUtil {
    public static void openWebpage(String url, boolean checkTextInput, boolean checkEmailField, boolean checkPasswordField) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String login = "sharipovi2002@mail.ru";
        String password = "Pantelis7!!7";
        String chatUrl = "https://vk.com/im/convo/325568350?entrypoint=list_all";
        String imagePath = "Text_input.png";

        try {
            // Открытие веб-страницы
            driver.get(url);

            // Проверка заголовка
            // Заполнение текстового поля
            if (checkTextInput) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement textInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Text input']")));
                    String actualTextInput = textInputElement.getText();
                    if (actualTextInput.equals("Text input")) {
                        JOptionPane.showMessageDialog(null, "Совпадает Text input");
                        ScreenshotUtil.takeScreenshot("Text_input.png"); // Скриншот после заполнения поля
                    } else {
                        JOptionPane.showMessageDialog(null, "Текстовое поле не совпадает: " + actualTextInput);
                    }
                } catch (NoSuchElementException e) {
                    JOptionPane.showMessageDialog(null, "Элемент 'Text input' не найден.");
                }
            }
            if (checkEmailField) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement textInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Email field']")));
                    String actualTextInput = textInputElement.getText();
                    if (actualTextInput.equals("Email field")) {
                        JOptionPane.showMessageDialog(null, "Совпадает Email field");
                        ScreenshotUtil.takeScreenshot("Email_field.png"); // Скриншот после заполнения поля
                    } else {
                        JOptionPane.showMessageDialog(null, "Текстовое поле не совпадает: " + actualTextInput);
                    }
                } catch (NoSuchElementException e) {
                    JOptionPane.showMessageDialog(null, "Элемент 'Email field' не найден.");
                }
            }
            if (checkPasswordField) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement textInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Password field']")));
                    String actualTextInput = textInputElement.getText();
                    if (actualTextInput.equals("Password field")) {
                        JOptionPane.showMessageDialog(null, "Совпадает Password field");
                        ScreenshotUtil.takeScreenshot("Password_field.png"); // Скриншот после заполнения поля
                    } else {
                        JOptionPane.showMessageDialog(null, "Текстовое поле не совпадает: " + actualTextInput);
                    }
                } catch (NoSuchElementException e) {
                    JOptionPane.showMessageDialog(null, "Элемент 'Password field' не найден.");
                }
            }

            // Аналогично для других полей...

            sendImageToVk( login, password, chatUrl, imagePath);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка при открытии URL: " + url);
        } finally {
            driver.quit();
        }
    }

}