import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class newbr {

	public static void main(String[] args) {
		WebDriver w = new ChromeDriver();
		System.setProperty("WebDriver.chrome.driver", "./driver/chromedriver.exe");
		w.get("https://www.facebook.com/");
		w.close();
	}
}
