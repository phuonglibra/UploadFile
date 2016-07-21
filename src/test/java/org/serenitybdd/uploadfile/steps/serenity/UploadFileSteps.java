package org.serenitybdd.uploadfile.steps.serenity;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.serenitybdd.uploadfile.pages.UploadFilePages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UploadFileSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UploadFilePages uploadPage;

	@Step
	public void openLink(String linkPage) {
		uploadPage.openAt(linkPage);
		getDriver().manage().window().maximize();
	}

	@Step
	public void clickButtonAddFile(String element) {
		uploadPage.getElement(element).click();
	}

	@Step
	public void closeWindow() {
		uploadPage.getDriver().close();
	}

	@Step
	public void uploadFile(String filePath) throws Exception {
		try {
			StringSelection ss = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard()
					.setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
		}
	}

	@Step
	public void getAnyTextPresent(String elementTetx) {
		uploadPage.getDriver().getPageSource().contentEquals(elementTetx);
	}

	@Step
	public void getTextPresent(String elementTetx) {
		uploadPage.getDriver().getPageSource().contentEquals(elementTetx);
	}
}
