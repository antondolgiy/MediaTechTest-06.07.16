package ru.dolgiy;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Anton on 06.07.2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resource"})

public class CucumberTestRunner {


}
