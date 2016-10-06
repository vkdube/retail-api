package product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.retail.api.entity.Price;
import com.retail.api.entity.Product;
import com.retail.api.service.transformer.product.ProductTransformer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author vinod dube
 *
 */
public class ProductSteps {
	private Product product = new Product();
	private Price productPrice;
	private boolean result;

	// scenarios 1 : for retrieving product information
	private final ProductTransformer productTransformer = new ProductTransformer(product);

	@Given(".+a external API to retrieve the product by Id (.+), for a product name '(.+)', read pricing information from a NoSQL data source")
	public void retrieveProductById(final long id) {
		product = productTransformer.getById(id);
		assertThat(product.getId(), equalTo(id));
	}

	@When("^the customer searches for the product name '(.+)'$")
	public void searchProductName(final String name, final long id) {
		final Product product = productTransformer.getById(id);
		assertThat(product.getName(), equalTo(name));
	}

	@Then("A product id (\\d+) should have been found$")
	public void verifyProductIdFound(final long id) {
		assertThat(product.getId(), equalTo(id));
	}

	@Then("A product name '(.+)' should be shown$")
	public void verifyProductNameFound(final String name) {
		assertThat(product.getName(), equalTo(name));
	}

	@Then("A product price (.+) should be shown$")
	public void verifyProductPrice(final double price) {
		assertThat(product.getCurrentPrice().getValue(), equalTo(price));
	}

	@Then("A product currency '(.+)' should be shown$")
	public void verifyProductCurrency(final String currency) {
		assertThat(product.getCurrentPrice().getCurrencyCode(), equalTo(currency));
	}

	// scenarios 2 : for updating product price

	@Given("^  a product id = (\\d+), price = (\\d+) and currency = (\\d+)$")
	public void initializeProductPrice(final long id, final double price, final String currency) throws Throwable {
		productPrice = new Price();
		productPrice.setValue(price);
		productPrice.setCurrencyCode(currency);
	}

	@When("^the product's price is updated$")
	public void updateProductPrice() throws Throwable {
		product.setCurrentPrice(productPrice);
		assertThat(productTransformer.modify(product).getCurrentPrice().getValue(),
				equalTo(product.getCurrentPrice().getValue()));
		if (productTransformer.modify(product).getCurrentPrice().getValue() == product.getCurrentPrice().getValue()) {
			result = true;
		}
	}

	@Then("^the result should be true$")
	public void the_result_should_be_true() throws Throwable {
		assertTrue(result);
	}

	@Then("^the result should be false$")
	public void the_result_should_be_false() throws Throwable {
		assertFalse(result);
	}
}
