package com.retail.api.service.product;

import com.retail.api.entity.Product;
import com.retail.api.rs.config.TimezoneConfiguration;
import com.retail.api.rs.v1.resources.products.RetailProductResource;
import com.retail.api.service.transformer.product.ProductTransformer;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author vinod dube
 *
 */
public class RetailProductService extends Service<TimezoneConfiguration> {
	private final ProductTransformer productTransformer = new ProductTransformer(new Product());

	public static void main(final String[] args) throws Exception {
		// new RestReimbService().run(new String[] { "server" });
		// new RestReimbService().run(new String[] { "server", "./src/main/resources/re-service.yml"
		// });
		new RetailProductService().run(args); // through command line or gradle run
	}

	@Override
	public void initialize(final Bootstrap<TimezoneConfiguration> timezoneConfigurationBootstrap) {
		timezoneConfigurationBootstrap.setName("retail");
	}

	@Override
	public void run(final TimezoneConfiguration configuration, final Environment environment) throws Exception {

		// TODO Auto-generated method stub
		final String defaultTimezone = configuration.getDefaultTimezone();
		System.out.println("--defaultTimezone-Retail Restful-" + defaultTimezone);
		final RetailProductResource productResource = new RetailProductResource(productTransformer, defaultTimezone);
		environment.addResource(productResource);
		// final TimeResource timeResource = new TimeResource(defaultTimezone);
		// environment.addResource(timeResource);
	}

}