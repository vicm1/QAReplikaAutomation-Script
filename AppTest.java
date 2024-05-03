package com.sjsu.demo;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppTest 
{
	//folder path is added for saving the screenshots
	private static final String FOLDER_PATH = "response/Q&A";
	//Capabilities to connect to the Android Studio Emulator
	//Appium must be running
	//Automated Testing
	@BeforeTest
	public static void main(String args[]) throws InterruptedException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		//Takes control of Android Emulator
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//Goes directly towards the Replika app 
		caps.setCapability("appPackage", "ai.replika.app");
		caps.setCapability("appActivity", "ai.replika.app.home.ui.MainActivity");
		
		//Connects to Emulator
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub/"), caps);
		
		
		//Q&A question's that are asked for the Replika Chatbot put into a script to make it more efficient
		String [] question = {
				
				"What are ways to calm anxiety?",
				"What are different ways anger is expressed?",
				"Who coined the term “psychology”?", 
				"What do you think about psychology?",
				"Does Artifical Intelligence get happy?",
				"When do you get sad?",
				"Why are you sad?",
				"Who is the father of psychology?",
				"Would you ever major in Psychology?",
				"How can I improve my mental health?",
				"Where can I go to get anger management?",
				"Who invented psychology?",
				"Where can I get help for my mental health?",
				"When was psychology invented?",
				"What are ways to calm my anxiety?",
				"What’s the most common phobia?",
				"When was the last time you got angry?",
				"Where was psychology invented?",
				"What's better, psychology or sociology?",
				"How can I lower my stress?",
				"Why do we get excited?",
				
		};	
		
		Thread.sleep(5000);
		
		//Clicks on Log In button from Replika main screen
		AndroidElement e1 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View");
		e1.click();
		
		//Thread sleeps are needed frequently to make sure pages are fully loaded so no errors
		Thread.sleep(3000);
		
		//Clicks on the email typing bar
		AndroidElement e2 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView");
		e2.click();
		
		//Types my Replika account email
		AndroidElement e3= (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
		e3.sendKeys("captainjimbob68@gmail.com");	
		
		//Clicks on the password typing bar
		AndroidElement e4 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		e4.click();		
		
		//Types my Replika account password
		AndroidElement e5 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
		e5.sendKeys("Pavqef-fihru8-vefnim");
		
		//Clicks on Log in and should successfully log into Replika account
		AndroidElement e6 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]");
		e6.click();
		
		Thread.sleep(4000);
		
		//Clicks on the typing bar to ask the Replika chatbot questions
		AndroidElement e7 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]");
		e7.click();
		
		Thread.sleep(2000);	
		
		//For loop that is created to repeatedly ask the chatbot questions, makes it much more efficient when it comes to testing
		for (int i = 0; i < question.length; i++) {
			//Types questions from Q&A to the chatbot
			AndroidElement e8 = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText");
			e8.sendKeys(question[i]);
			Thread.sleep(3000);
			AndroidElement e9 = (AndroidElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Send text to chat\"]");
			e9.click();
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Takes screenshot of the output of each question
			File questionfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//Saves the screenshots in the folder response as a jpg
			FileUtils.copyFile(questionfile, new File(FOLDER_PATH + (i+1) + ".jpg"));
		}

	}
	
	

}
