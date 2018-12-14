

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageViewRefresh {

    public static void main(String[] args) throws Exception {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
//		System.setProperty("webdriver.firefox.bin",
//				"E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//		System.setProperty("webdriver.firefox.marionette",
//				"D:\\新建文件夹\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        String url = "http://10120275.blog.51cto.com//10110275/1954601";


        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        ArrayList<String> pageUrl = new ArrayList();
        pageUrl.add("http://blog.51cto.com/10120275/p1");
        pageUrl.add("http://blog.51cto.com/10120275/p2");
        pageUrl.add("http://blog.51cto.com/10120275/p3");
        pageUrl.add("http://blog.51cto.com/10120275/p4");

        ArrayList<String> urls = new ArrayList<String>();

        for (String page : pageUrl) {
            driver.get(page);
            List<WebElement> list1 = ((ChromeDriver) driver).findElementsByClassName("tit");
            for (int i = 0; i < list1.size(); i++) {
                String url = list1.get(i).getAttribute("href");
                urls.add(url);
            }
        }

        for(int i = 0; i < 4000; i++){
            try {
                Thread.sleep(1000);
                int id = (int) (Math.random() * urls.size());
                String url = urls.get(id);
                System.out.println(i + " " + url);
                driver.get(url);

            } catch (Exception e) {

            }
        }
        driver.close();
    }
}
