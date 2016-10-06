package com.retail.api.data.nosql.couchbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.retail.api.entity.Price;
import com.retail.api.entity.Product;

/**
 *
 * Provides functionality to retrieve / update / insert Product Price.
 *
 */
// @Component - This is a Spring Bean, and it can be registered in the application
// context to set the configuratio details.

public class CouchbasePriceProvider {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private final String couchbaseHost = "localhost";
	private final String couchbaseUserName = "admin";
	private final String couchbasePassword = "couchbase";
	private final String couchbaseBucket = "default";

	/**
	 * Retrieves the price information of a product.
	 *
	 * @param product
	 *            The product object.
	 *
	 * @return Price The product Price object
	 * @exception CouchbaseException
	 *                is thrown
	 */
	public Price retrieveProductPrice(final Product product) throws CouchbaseException {

		try {

			// Reads pricing information from a NoSQL data store and combines it with
			// the product id, if match found on product id, if not then return null
			final Price price = new Price();
			/////////////////////////////////////////////////////////
			// Create a cluster reference
			final CouchbaseCluster cluster = CouchbaseCluster.create(couchbaseHost);

			// Connect to the bucket and open it
			final Bucket bucket = cluster.openBucket(couchbaseBucket);

			final JsonObject content = JsonObject.create().put("product_id", product.getId());
			// Read the document and print the "price" field

			final JsonDocument found = bucket
					.get(JsonDocument.create(createJsonNode("product_price", product.getId()), content));

			if (null != found && null != found.content() && found.content().getLong("product_id") == product.getId()) {
				price.setValue(found.content().getDouble("price").doubleValue());
				price.setCurrencyCode(found.content().getString("currency"));
				logger.info("*** Couchbase is my favourite database in the NoSQL world : "
						+ found.content().getDouble("price"));
				return price;
			}
			// Close all buckets and disconnect
			cluster.disconnect();

			////////////////////////////////////////////////////////
			return null;

		} catch (final Exception e) {
			throw new CouchbaseException("Error occured retrieving price for a Product:  " + product.getId(), e);
		}
	}

	/**
	 * Update or Replace the price information of a product.
	 *
	 * @param product
	 *            The product object.
	 *
	 * @return Product with the Price object
	 * @exception CouchbaseException
	 *                is thrown
	 */
	public Product updateProductPrice(final Product product) throws CouchbaseException {

		try {
			// Reads existing price information from a NoSQL data store and combines it with
			// the product id, if match found update the price, if not then return null

			// Create a cluster reference
			final CouchbaseCluster cluster = CouchbaseCluster.create(couchbaseHost);
			// Connect to the bucket and open it
			final Bucket bucket = cluster.openBucket(couchbaseBucket);
			// Create a JSON document and store it with the Json Object "product_price"
			if (null != product && null != product.getCurrentPrice()
					&& null != product.getCurrentPrice().getCurrencyCode()) {
				if (null != retrieveProductPrice(product) && retrieveProductPrice(product).getValue() >= 0.0) {

					final JsonObject content = JsonObject.create().put("product_id", product.getId());
					content.put("price", product.getCurrentPrice().getValue());
					content.put("currency", product.getCurrentPrice().getCurrencyCode());
					final JsonDocument updated = bucket
							.replace(JsonDocument.create(createJsonNode("product_price", product.getId()), content));
					logger.info("*** Price: Json Document Replaced or Updated with a Price JSON: " + updated.content());
					product.setCurrentPrice(retrieveProductPrice(product));
					return product;
				}
			}
			// Close all buckets and disconnect
			cluster.disconnect();

			return null;

		} catch (final Exception e) {
			throw new CouchbaseException("Error occured replacing / updating price for a Product:  " + product.getId(),
					e);
		}
	}

	/**
	 * Add the price information of a product.
	 *
	 * @param product
	 *            The product object.
	 *
	 * @return Product with the Price object
	 * @exception CouchbaseException
	 *                is thrown
	 */
	public Product addProductPrice(final Product product) throws CouchbaseException {

		try {
			// Reads existing price information from a NoSQL data store and combines it with
			// the product id, if match found update the price, if not then return null

			// Create a cluster reference
			final CouchbaseCluster cluster = CouchbaseCluster.create(couchbaseHost);
			// Connect to the bucket and open it
			final Bucket bucket = cluster.openBucket(couchbaseBucket);
			// Create a JSON document and store it with the Json Object "product_price"

			if (null != product && null != product.getCurrentPrice()
					&& null != product.getCurrentPrice().getCurrencyCode()) {
				final JsonObject content = JsonObject.create().put("product_id", product.getId());
				content.put("price", product.getCurrentPrice().getValue());
				content.put("currency", product.getCurrentPrice().getCurrencyCode());
				if (null == retrieveProductPrice(product)) {
					final JsonDocument inserted = bucket
							.insert(JsonDocument.create(createJsonNode("product_price", product.getId()), content));
					logger.info("*** Price: Json Document created with a Price JSON: " + inserted.content());
					product.setCurrentPrice(retrieveProductPrice(product));
					return product;
				}
			}
			// Close all buckets and disconnect
			cluster.disconnect();

			return null;

		} catch (final Exception e) {
			throw new CouchbaseException("Error occured inserting price for a Product:  " + product.getId(), e);
		}
	}

	private String createJsonNode(final String node, final long id) {
		return node + "_" + id;
	}
}
