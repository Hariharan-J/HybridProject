package hybridDesign;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Browser {
	
	public RemoteWebDriver startApp(String browser, String url);
	
	public void close();
	
	public String fetchtitle();
	
	public List<String> getWindows();
	
	public void switchToWindows(int index);
	
	public void alertAccept();
	
}
