package new_package;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;	

public class WeightWatchers {
	static List<WebElement> meetingsList; 
	
	 public static void main(String[] args) {
	        // declaration and instantiation of objects/variables
	    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	    	File gecko = new File("C:\\Users\\npai\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");    
	    	System.setProperty("webdriver.gecko.driver", gecko.getAbsolutePath());
	    	
			WebDriver driver = new FirefoxDriver();
				    	
	        String baseUrl = "https://www.weightwatchers.com/us/";
	        String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
	        String actualTitle = "";

	        // launch Fire fox and direct it to the Base URL
	        driver.get(baseUrl);

	        // get the actual value of the title
	        actualTitle = driver.getTitle();

	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!, Verified that the Title matches “WW (Weight Watchers): Weight Loss & Wellness Help");
	        } else {
	            System.out.println("Test Failed, The title does not match");
	        }
	        	        
	        
	        String actualStudioTitle = "";
	        String expectedStudioTitle = "Find WW Studios & Meetings Near You | WW USA";
	        driver.findElement(By.linkText("Find a Studio")).click();
	               
	        actualStudioTitle = driver.getTitle();
	        System.out.println(actualStudioTitle);
	        if (actualStudioTitle.contains(expectedStudioTitle)){
	            System.out.println("Test Passed!, The title matches");
	        } else {
	            System.out.println("Test Failed");
	        }

	        driver.findElement(By.id("meetingSearch")).sendKeys("10011");
	        driver.findElement(By.cssSelector("button[class='btn spice-translated']")).click();
	       
	        System.out.println("Title of the first result is "+driver.findElement(By.className("location__name")).getText());
	        System.out.println("Distance from first studio is "+driver.findElement(By.className("location__distance")).getText());
	        System.out.println(driver.getTitle());
	       driver.findElement(By.className("location__name")).click();
	       System.out.println(driver.getTitle());
	       
	       
	     
	       System.out.println("Todays date of operation " + driver.findElement(By.className("hours-list--currentday")).getText());
	       	     	     
	       meetingsList = driver.findElements(By.className("schedule-detailed-day"));
	          	
	       printMeeting ("THU");
	       	
	        driver.close();
	       	        
	    }
	 public static void printMeeting(String day){
		 for(WebElement we : meetingsList){
	    	
	    	   String meetingDay = we.findElement(By.className("schedule-detailed-day-label")).getText();
	    	   if(meetingDay.equalsIgnoreCase(day)){
	    	   List<WebElement> meetingDetails = we.findElements(By.className("schedule-detailed-day-meetings-item"));
	    	   HashMap<String,Integer> leaderMeetingCount = new HashMap<String,Integer>();
	    	   for(WebElement meeting : meetingDetails){
	    		   String leaderName = meeting.findElement(By.className("schedule-detailed-day-meetings-item-leader")).getText();
	    		  
	    		  Integer count = leaderMeetingCount.get(leaderName);
	    		  leaderMeetingCount.put(leaderName, (count == null) ? 1 : count + 1);
	    	   }
	    	   System.out.println("Number of meeting the each person(under the scheduled time) has a particular day of the week");
	    	   for (Map.Entry<String, Integer> val : leaderMeetingCount.entrySet()) { 
	               System.out.println(val.getKey() + " - "
	                                   + val.getValue() + " times"); 
	           } 
	    	   }
	    	   
	    		    	}
		 System.out.println("________");
	 }

}
