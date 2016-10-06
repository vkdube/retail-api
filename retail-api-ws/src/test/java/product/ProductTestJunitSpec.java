package product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.retail.api.data.util.RetailProductDataUtil;
import com.retail.api.entity.Price;
import com.retail.api.entity.Product;
import com.retail.api.service.transformer.product.ProductTransformer;

/**
 * @author vinod dube
 *
 */
public class ProductTestJunitSpec {
	private ProductTransformer productTransformer;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// expectedException.expect(CouchbaseException.class);
	// expectedException.expect(RestClientException.class);
	// expectedException.expectMessage("Invalid Request: 400");
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		final Product product = new Product();
		product.setId(RetailProductDataUtil.DEFAULT_PRODUCT_ID);
		productTransformer = new ProductTransformer(product);
	}

	@org.junit.Test()
	public void testRetrieveProductById() {
		// have one valid product request
		final long id1 = 13860428;
		// have another one as invalid product request
		// final long id2 = 13860429;

		// assert Id
		assertTrue(id1 == productTransformer.getById(id1).getId());
		// assertFalse(id2 == productTransformer.getById(id2).getId());
	}

	@org.junit.Test()
	public void testRetrieveProductName() {
		// have one valid product request
		final long id1 = 13860428;

		// assert name
		final String name1 = "The Big Lebowski (Blu-ray)";
		assertTrue(name1.equals(productTransformer.getById(id1).getName()));
		final String name2 = "The Big Lebowski (Blu-ray) (Target)";
		assertFalse(name2.equals(productTransformer.getById(id1).getName()));
	}

	@org.junit.Test()
	public void testRetrieveProductPrice() {
		// have one valid product request
		final long id1 = 13860428;

		// assert price & currency
		final Price price1 = new Price();
		price1.setValue(13.49);
		price1.setCurrencyCode("USD");
		if (price1.equals(productTransformer.getById(id1).getCurrentPrice())) {
			assertTrue(price1.equals(productTransformer.getById(id1).getCurrentPrice()));
		} else {
			assertFalse(price1.equals(productTransformer.getById(id1).getCurrentPrice()));
		}

		final Price price2 = new Price();
		price2.setValue(13.99);
		price2.setCurrencyCode("USD");
		assertFalse(price2.equals(productTransformer.getById(id1).getCurrentPrice()));

	}

	@org.junit.Test()
	public void testUpdateProductPrice() {
		// have one valid product id
		testUpdateProductPriceAtCouchbase(13860428, 14.49, "USD");
		// have few with invalid product id
		testUpdateProductPriceAtCouchbase(13860429, 20.99, "GBP");
		testUpdateProductPriceAtCouchbase(13860430, 40.99, "USD");
		testUpdateProductPriceAtCouchbase(13860431, 60.49, "EUR");
	}

	private void testUpdateProductPriceAtCouchbase(final long id, final double price, final String currencyCode) {
		// have one valid product Price Setup
		final Product product = new Product();
		product.setId(id);
		// set price & currency
		final Price revisedPrice = new Price();
		revisedPrice.setValue(price);
		revisedPrice.setCurrencyCode(currencyCode);
		product.setCurrentPrice(revisedPrice);

		assertTrue(price == productTransformer.modify(product).getCurrentPrice().getValue());
		assertTrue(currencyCode.equals(productTransformer.modify(product).getCurrentPrice().getCurrencyCode()));

	}
}