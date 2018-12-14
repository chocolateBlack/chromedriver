import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chocolate on 2017/8/12.
 * 检查博客内容是否包含了 敏感内容，比如 IP地址等
 */
public class DetectBokeKeyWord {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        ArrayList<String> pageUrl = new ArrayList();
        pageUrl.add("http://blog.51cto.com/10120275/p1");
        pageUrl.add("http://blog.51cto.com/10120275/p2");
        pageUrl.add("http://blog.51cto.com/10120275/p3");
        pageUrl.add("http://blog.51cto.com/10120275/p4");

        ArrayList<String> urls = new ArrayList<String>();

        try {
            for(String page : pageUrl){
                driver.get(page);
                List<WebElement> list1 = ((ChromeDriver) driver).findElementsByClassName("tit");
                for (int i = 0; i < list1.size(); i++){
                    String url = list1.get(i).getAttribute("href");
                    urls.add(url);
                }
            }

            for (int i = 0; i < urls.size(); i++){
                String url = urls.get(i);
                System.out.println("check url = [" + url + "]");
                driver.get(url);
                WebElement result = driver.findElement(By.className("con"));
                String text = result.getText();

                if(checkIP(text)){
                    System.out.println("No." +i + ",有IP地址： [" + url + "]");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public static boolean checkIP(String pageSource){
        String ip = "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(pageSource);
        while(matcher.find()){
            if(!StringUtils.equals(matcher.group(0), "10.10.10.10") && !StringUtils.equals(matcher.group(0), "127.0.0.1")){
                System.out.println(matcher.group(0));
                return true;
            }
        }
        return false;
    }
}
