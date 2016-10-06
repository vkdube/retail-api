package com.retail.api.rs.v1.resources.products;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.retail.api.entity.Product;
import com.retail.api.rs.v1.resources.BaseResource;
import com.retail.api.service.transformer.product.ProductTransformer;
import com.retail.business.service.response.ResponseHeader;

/**
 * @author vinod dube
 *
 */

@Path(BaseResource.RETAIL_V1_PRODUCTS)
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@org.springframework.stereotype.Component
public class RetailProductResource {

	private final ProductTransformer productTransformer;
	private final String defaultTimezone;
	private static final String ID_PATH = "/{id}";
	private static final String SUCCESS = "0";
	private static final String FAILURE = "1";
	final static String centralTimezone = "CST";

	public RetailProductResource(final ProductTransformer productTransformer, final String defaultTimezone) {
		this.productTransformer = productTransformer;
		this.defaultTimezone = defaultTimezone;
	}

	@GET
	@com.wordnik.swagger.annotations.ApiOperation(httpMethod = "GET", value = "Retrieve All Products", response = Product.class, nickname = "productInfo")
	@Timed(name = "/products")
	public List<Product> getProducts() {
		try {
			if (!productTransformer.getAllProducts().isEmpty()) {
				return productTransformer.getAllProducts();
			} else {
				Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(getStatusHeader(FAILURE))
						.type(MediaType.APPLICATION_JSON).build();
				return null;
			}
		} catch (final Exception e) {
			Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(getStatusHeader(FAILURE))
					.type(MediaType.APPLICATION_JSON).build();
			return null;
		}
	}

	@GET
	@com.wordnik.swagger.annotations.ApiOperation(httpMethod = "GET", value = "Retrieve A Product Information", response = Product.class, nickname = "productInfo")
	@Timed(name = "/products")
	@Path(ID_PATH)
	public Response getProduct(@PathParam("id") final Long id) {
		try {
			final Product product = productTransformer.getById(id);
			if (null != product) {
				Response.status(Response.Status.OK.getStatusCode()).entity(getStatusHeader(SUCCESS))
						.type(MediaType.APPLICATION_JSON).build();
				return Response.status(Response.Status.OK).entity(product).header("statusCode", "0").build();
			} else {
				Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(getStatusHeader(FAILURE))
						.type(MediaType.APPLICATION_JSON).build();
				return Response.status(Response.Status.BAD_REQUEST).header("statusCode", "1").build();
			}
		} catch (final Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).header("statusCode", "1").build();
		}
	}

	@PUT
	@com.wordnik.swagger.annotations.ApiOperation(httpMethod = "PUT", value = "Update A Product Information", response = Product.class, nickname = "productUpdate")
	@Timed(name = "/products")
	@Path(ID_PATH)
	public Response modifyProduct(@PathParam("id") final Long id, final Product product) {
		try {
			if (id == product.getId()) {
				final Product modifiedProduct = productTransformer.modify(product);
				Response.status(Response.Status.OK.getStatusCode()).entity(getStatusHeader(SUCCESS))
						.type(MediaType.APPLICATION_JSON).build();
				return Response.status(Response.Status.ACCEPTED).entity(modifiedProduct).header("statusCode", "0")
						.build();
			} else {
				Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(getStatusHeader(FAILURE))
						.type(MediaType.APPLICATION_JSON).build();
				return Response.status(Response.Status.BAD_REQUEST).header("statusCode", "1").build();
			}
		} catch (final Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).header("statusCode", "1").build();
		}
	}

	@POST
	@com.wordnik.swagger.annotations.ApiOperation(httpMethod = "POST", value = "Add A Product Information", response = Product.class, nickname = "productAdd")
	@Timed(name = "/products")
	public Response addProduct(final Product product) {
		try {
			if (null != product) {
				final Product addedProduct = productTransformer.add(product);
				Response.status(Response.Status.OK.getStatusCode()).entity(getStatusHeader(SUCCESS))
						.type(MediaType.APPLICATION_JSON).build();
				return Response.status(Response.Status.ACCEPTED).entity(addedProduct).header("statusCode", "0").build();
			} else {
				Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(getStatusHeader(FAILURE))
						.type(MediaType.APPLICATION_JSON).build();
				return Response.status(Response.Status.BAD_REQUEST).header("statusCode", "1").build();
			}
		} catch (final Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).header("statusCode", "1").build();
		}
	}

	private String getTimeStamp(final String timezone) {
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final TimeZone timeZone = TimeZone.getTimeZone(timezone != null ? timezone : defaultTimezone);
		formatter.setTimeZone(timeZone);
		final String formatted = formatter.format(new Date());
		return formatted;
	}

	private ResponseHeader getStatusHeader(final String statusCode) {
		final ResponseHeader header = new ResponseHeader();
		header.setStatusCode(statusCode);
		header.setTimestamp(getTimeStamp(centralTimezone));
		return header;
	}

}