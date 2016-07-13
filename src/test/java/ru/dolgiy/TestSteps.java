package ru.dolgiy;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


/**
 * Created by Anton on 06.07.2016.
 */
public class TestSteps {

        @Before
        public void setUp(){
              googlePage.setUp();}

        @After
        public void closeDawn() {
               googlePage.close();
    }



        GooglePage googlePage= new GooglePage();

        @Given("^Open page by url \"([^\"]*)\" in browser$")
        public void open_page_by_url_in_browser (String arg1)throws Throwable {

               googlePage.open_url(arg1);

    }

        @Given("^Type to search input \"([^\"]*)\"$")
        public void type_to_search_input (String arg1)throws Throwable {
               googlePage.search_input(arg1);


    }

        @When("^Press button search$")
        public void press_button_search ()throws Throwable {
               googlePage.press_search();


    }

        @Then("^Header search snippet \"([^\"]*)\" text equals \"([^\"]*)\"$")
        public void header_search_snippet_text_equals (String arg1, String arg2)throws Throwable {

               googlePage.wait_for_smthng();

               assertEquals(arg2,googlePage.get_snippet(arg1).getText());

    }


}
