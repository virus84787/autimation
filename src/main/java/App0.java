import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App0 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.name("q")).clear();

        driver.findElement(By.name("q")).sendKeys("trololo");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        Thread.sleep(1000);
        driver.quit();
    }
}
