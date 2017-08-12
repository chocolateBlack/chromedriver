

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class PageViewRefresh {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
//		System.setProperty("webdriver.firefox.bin",
//				"E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//		System.setProperty("webdriver.firefox.marionette",
//				"D:\\新建文件夹\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        String url = "http://10120275.blog.51cto.com//10110275/1954601";
        ArrayList<String> urls = new ArrayList(Arrays.asList("http://10120275.blog.51cto.com/10110275/1954601",
                "http://10120275.blog.51cto.com/10110275/1954598",
                "http://10120275.blog.51cto.com/10110275/1953406",
                "http://10120275.blog.51cto.com/10110275/1951929",
                "http://10120275.blog.51cto.com/10110275/1951711",
                "http://10120275.blog.51cto.com/10110275/1919698",
                "http://10120275.blog.51cto.com/10110275/1915562",
                "http://10120275.blog.51cto.com/10110275/1908363",
                "http://10120275.blog.51cto.com/10110275/1866856",
                "http://10120275.blog.51cto.com/10110275/1865792",
                "http://10120275.blog.51cto.com/10110275/1865479",
                "http://10120275.blog.51cto.com/10110275/1855801",
                "http://10120275.blog.51cto.com/10110275/1851106",
                "http://10120275.blog.51cto.com/10110275/1845383",
                "http://10120275.blog.51cto.com/10110275/1844461",
                "http://10120275.blog.51cto.com/10110275/1830831",
                "http://10120275.blog.51cto.com/10110275/1793736",
                "http://10120275.blog.51cto.com/10110275/1792600",
                "http://10120275.blog.51cto.com/10110275/1783506",
                "http://10120275.blog.51cto.com/10110275/1764536",
                "http://10120275.blog.51cto.com/10110275/1764526",
                "http://10120275.blog.51cto.com/10110275/1752503",
                "http://10120275.blog.51cto.com/10110275/1748513",
                "http://10120275.blog.51cto.com/10110275/1744763",
                "http://10120275.blog.51cto.com/10110275/1744648",
                "http://10120275.blog.51cto.com/10110275/1907275",
                "http://10120275.blog.51cto.com/10110275/1905936",
                "http://10120275.blog.51cto.com/10110275/1905930",
                "http://10120275.blog.51cto.com/10110275/1898335",
                "http://10120275.blog.51cto.com/10110275/1879569",
                "https://www.meipian.cn/nyugqpg?from=timeline&isappinstalled=0"));

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
