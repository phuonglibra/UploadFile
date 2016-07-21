package org.serenitybdd.uploadfile.steps;

import org.serenitybdd.uploadfile.steps.serenity.UploadFileSteps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadFileDefs {
	@Steps
	UploadFileSteps uploadStep;

	@Given("^the page \"([^\"]*)\" is visited$")
	public void the_page_is_visited(String linkPage) throws Throwable {
		uploadStep.openLink(linkPage);
	}

	@When("^\"([^\"]*)\" element is clicked$")
	public void element_is_clicked(String element) throws Throwable {
		uploadStep.clickButtonAddFile(element);
	}

	@When("^\"([^\"]*)\" file is uploaded$")
	public void file_is_uploaded(String filePath) throws Throwable {
		uploadStep.uploadFile(filePath);
	}

	@When("^wait for any \"([^\"]*)\" text to be present$")
	public void wait_for_any_text_to_be_present(String elementTetx)
			throws Throwable {
		uploadStep.getAnyTextPresent(elementTetx);
	}

	@Then("^assert that the \"([^\"]*)\" text is present$")
	public void assert_that_the_text_is_present(String elementTetx)
			throws Throwable {
		uploadStep.getTextPresent(elementTetx);
	}

	@When("^close current window$")
	public void close_current_window() throws Throwable {
		uploadStep.closeWindow();
	}
}
