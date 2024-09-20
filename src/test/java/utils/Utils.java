package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.util.Scanner;

public class Utils {
    public static String input(String text){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(text);
        return  myObj.nextLine();
    }

    public static Object exececuteJS(WebDriver driver, String jsScript){
        return ((JavascriptExecutor)driver).executeScript(jsScript);
    }

    public static void wait(int mills){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
