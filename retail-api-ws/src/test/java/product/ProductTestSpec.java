package product;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author vinod dube
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:build/cucumber/product" })
// , features = { "classpath:src/test/resources/product/productSpec.feature" })
public class ProductTestSpec {
}