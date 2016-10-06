package com.retail.business.domain.product;

/**
 * @author vinod dube
 *
 */
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Item {
	@JsonProperty("identifier")
	private List<Identifier> identifier;
	@JsonProperty("relation")
	private String relation;
	@JsonProperty("relation_description")
	private String relationDescription;
	@JsonProperty("data_page_link")
	private String dataPageLink;
	@JsonProperty("imn_identifier")
	private long imnIdentifier;
	@JsonProperty("is_orderable")
	private boolean isOrderable;
	@JsonProperty("is_sellable")
	private boolean isSellable;
	@JsonProperty("general_description")
	private String generalDescription;
	@JsonProperty("is_circular_publish")
	private boolean isCircularPublish;
	@JsonProperty("business_process_status")
	private List<BusinessProcessStatus> businessProcessStatus;
	@JsonProperty("dpci")
	private String dpci;
	@JsonProperty("department_id")
	private int departmentId;
	@JsonProperty("class_id")
	private int classId;
	@JsonProperty("item_id")
	private int itemId;
	@JsonProperty("online_description")
	private Description onlineDescription;
	@JsonProperty("store_description")
	private Description storeDescription;
	@JsonProperty("alternate_description")
	private List<AlternateDescription> alternateDescription;
	@JsonProperty("features")
	private List<Feature> features;

	public List<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(final List<Identifier> identifier) {
		this.identifier = identifier;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(final String relation) {
		this.relation = relation;
	}

	public String getRelationDescription() {
		return relationDescription;
	}

	public void setRelationDescription(final String relationDescription) {
		this.relationDescription = relationDescription;
	}

	public String getDataPageLink() {
		return dataPageLink;
	}

	public void setDataPageLink(final String dataPageLink) {
		this.dataPageLink = dataPageLink;
	}

	public long getImnIdentifier() {
		return imnIdentifier;
	}

	public void setImnIdentifier(final long imnIdentifier) {
		this.imnIdentifier = imnIdentifier;
	}

	public boolean isOrderable() {
		return isOrderable;
	}

	public void setOrderable(final boolean isOrderable) {
		this.isOrderable = isOrderable;
	}

	public boolean isSellable() {
		return isSellable;
	}

	public void setSellable(final boolean isSellable) {
		this.isSellable = isSellable;
	}

	public String getGeneralDescription() {
		return generalDescription;
	}

	public void setGeneralDescription(final String generalDescription) {
		this.generalDescription = generalDescription;
	}

	public boolean isCircularPublish() {
		return isCircularPublish;
	}

	public void setCircularPublish(final boolean isCircularPublish) {
		this.isCircularPublish = isCircularPublish;
	}

	public List<BusinessProcessStatus> getBusinessProcessStatus() {
		return businessProcessStatus;
	}

	public void setBusinessProcessStatus(final List<BusinessProcessStatus> businessProcessStatus) {
		this.businessProcessStatus = businessProcessStatus;
	}

	public String getDpci() {
		return dpci;
	}

	public void setDpci(final String dpci) {
		this.dpci = dpci;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(final int departmentId) {
		this.departmentId = departmentId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(final int classId) {
		this.classId = classId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(final int itemId) {
		this.itemId = itemId;
	}

	public Description getOnlineDescription() {
		return onlineDescription;
	}

	public void setOnlineDescription(final Description onlineDescription) {
		this.onlineDescription = onlineDescription;
	}

	public Description getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(final Description storeDescription) {
		this.storeDescription = storeDescription;
	}

	public List<AlternateDescription> getAlternateDescription() {
		return alternateDescription;
	}

	public void setAlternateDescription(final List<AlternateDescription> alternateDescription) {
		this.alternateDescription = alternateDescription;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(final List<Feature> features) {
		this.features = features;
	}

}
