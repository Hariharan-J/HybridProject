package hybridDesign;

import org.openqa.selenium.WebElement;

public interface Element {
	
	public WebElement locateElement(String ele, String Value);
	
	public void clearandtype(String ele, String elevalue, String value);
	
	public void click(String ele, String value);
	
	public void verifyEleText(String ele,String value,String text);
	
	public void sleep() throws InterruptedException;
	
	public String fetchText(String ele,String value);
	
	public boolean stringCompare(String s1,String s2);
	
	public String regexPickText(String s);

}
