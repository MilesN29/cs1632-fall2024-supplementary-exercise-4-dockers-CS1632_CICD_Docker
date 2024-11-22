// Generated by Selenium IDE
package edu.pitt.cs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@SuppressWarnings("unused")
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  // @SuppressWarnings("deprecation")
  // @Test
  // public void dEFECT1FUNGREETACAT() {
  // driver.get("http://localhost:8080");
  // driver.findElement(By.linkText("Rent-A-Cat")).click();
  // driver.findElement(By.id("rentID")).click();
  // driver.findElement(By.id("rentID")).sendKeys("1");
  // driver.findElement(By.xpath("//button[@onclick=\'rentSubmit()\']")).click();
  // driver.findElement(By.linkText("Greet-A-Cat")).click();
  // assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(),
  // is("Meow!Moew!"));
  // }

  // @SuppressWarnings("deprecation")
  // @Test
  // public void dEFECT2FUNFEED() {
  // driver.get("http://localhost:8080");
  // js.executeScript("document.cookie = \"1=false\";document.cookie =
  // \"2=false\";document.cookie = \"3=false\";");
  // driver.findElement(By.linkText("Feed-A-Cat")).click();
  // driver.findElement(By.id("catnips")).click();
  // driver.findElement(By.id("catnips")).sendKeys("0");
  // driver.findElement(By.xpath("//button[contains(.,\'Feed\')]")).click();
  // assertThat(driver.findElement(By.id("feedResult")).getText(), is("Cat
  // fight!"));
  // }

  // @SuppressWarnings("deprecation")
  // @Test
  // public void dEFECT3FUNFEED() {
  // driver.get("http://localhost:8080");
  // js.executeScript("document.cookie = \"1=false\";document.cookie =
  // \"2=false\";document.cookie = \"3=false\";");
  // driver.findElement(By.linkText("Feed-A-Cat")).click();
  // driver.findElement(By.id("catnips")).sendKeys("-6");
  // driver.findElement(By.xpath("//button[contains(.,\'Feed\')]")).click();
  // assertThat(driver.findElement(By.id("feedResult")).getText(), is("Cat
  // fight!"));
  // }

  // @SuppressWarnings("deprecation")
  // @Test
  // public void dEFECT4FUNGREETACATWITHNAME() {
  // driver.get("http://localhost:8080");
  // driver.findElement(By.linkText("Rent-A-Cat")).click();
  // driver.findElement(By.id("rentID")).click();
  // driver.findElement(By.id("rentID")).sendKeys("3");
  // driver.findElement(By.xpath("//button[@onclick=\'rentSubmit()\']")).click();
  // driver.get("https://cs1632.appspot.com/greet-a-cat/Mistoffelees");
  // assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(),
  // is("Mistoffelees is not here."));
  // }

  @Test
  public void tEST1LINKS() {
    driver.get("http://localhost:8080");
    {
      WebElement element = driver.findElement(By.xpath("//a[text()=\'Reset\']"));
      String attribute = element.getAttribute("href");
      vars.put("reset", attribute);
    }
    assertEquals(vars.get("reset").toString(), "https://cs1632.appspot.com/reset");
  }

  @SuppressWarnings("deprecation")
  @Test
  public void tEST2RESET() {
    driver.get("https://cs1632.appspot.com/");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=true\";");
    driver.findElement(By.linkText("Reset")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
  }

  @Test
  public void tEST3CATALOG() {
    driver.get("http://localhost:8080");
    {
      WebElement element = driver.findElement(By.xpath("(//img)[2]"));
      String attribute = element.getAttribute("src");
      vars.put("image", attribute);
    }
    assertEquals(vars.get("image").toString(), "https://cs1632.appspot.com/images/cat2.jpg");
  }

  @Test
  public void tEST4LISTING() {
    driver.get("https://cs1632.appspot.com/");

    driver.findElement(By.linkText("Catalog")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("listing")));

    List<WebElement> cats = driver.findElements(By.cssSelector("[id^='cat-id']"));
    assertEquals("Expected 3 cats in the listing", 3, cats.size());

    String thirdCatText = cats.get(2).getText();
    assertEquals("ID 3. Mistoffelees", thirdCatText);
  }

  @Test
  public void tEST5RENTACAT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button"));
      assert (elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[3]/div[3]/button"));
      assert (elements.size() > 0);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void tEST6RENT() {
    driver.get("https://cs1632.appspot.com");

    driver.manage().deleteAllCookies();

    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.xpath("//button[@onclick='rentSubmit()']")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.textToBe(By.id("rentResult"), "Success!"));

    WebElement result = driver.findElement(By.id("rentResult"));
    String resultText = result.getText();
    assertEquals("Success!", resultText);

    System.out.println("Rent result: " + resultText);
    System.out.println("Page source after renting: " + driver.getPageSource());

    driver.findElement(By.linkText("Catalog")).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cat-id1")));

    String cat1Status = driver.findElement(By.id("cat-id1")).getText();
    String cat2Status = driver.findElement(By.id("cat-id2")).getText();
    String cat3Status = driver.findElement(By.id("cat-id3")).getText();
    // System.out.println("Cat 1 Status: " + cat1Status);
    // System.out.println("Cat 2 Status: " + cat2Status);
    // System.out.println("Cat 3 Status: " + cat3Status);

    assertThat(cat1Status, is("Rented out"));
    assertThat(cat2Status, is("ID 2. Old Deuteronomy"));
    assertThat(cat3Status, is("ID 3. Mistoffelees"));

    js.executeScript("document.cookie = \"1=false\"; document.cookie = \"2=false\"; document.cookie = \"3=false\";");
  }

  @SuppressWarnings("deprecation")
  @Test
  public void tEST7RETURN() {
    driver.get("http://localhost:8080");
    js.executeScript("document.cookie = \"2=true\";");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.xpath("//button[@onclick=\'returnSubmit()\']")).click();
    {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("returnResult")));
    }
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
  }

  @Test
  public void tEST8FEEDACAT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Feed\')]"));
      assert (elements.size() > 0);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void tEST9FEED() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    driver.findElement(By.xpath("//input[@id=\'catnips\']")).sendKeys("6");
    driver.findElement(By.xpath("//button[contains(.,\'Feed\')]")).click();
    {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("feedResult"), "Nom, nom, nom."));
    }
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
  }

  @SuppressWarnings("deprecation")
  @Test
  public void tEST10GREETACAT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(.,\'Meow!Meow!Meow!\')]")));
    }
    assertThat(driver.findElement(By.xpath("//h4[contains(.,\'Meow!Meow!Meow!\')]")).getText(), is("Meow!Meow!Meow!"));
  }

  @SuppressWarnings("deprecation")
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("http://localhost:8080greet-a-cat/Jennyanydots");
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\'greeting\']/h4")));
    }
    assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(), is("Meow! from Jennyanydots."));
  }
}
