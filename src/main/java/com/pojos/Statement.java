package com.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "accessionNumber",
        "collapsedStatements",
        "content",
        "context",
        "page",
        "recurring",
        "snippetCount",
        "snippetOffset",
        "statementId",
        "statementIndex",
        "statementIndexOffset"
})
@Generated("jsonschema2pojo")
public class Statement {

    @JsonProperty("accessionNumber")
    private String accessionNumber;
    @JsonProperty("collapsedStatements")
    private List<String> collapsedStatements = null;
    @JsonProperty("content")
    private String content;
    @JsonProperty("context")
    private Boolean context;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("recurring")
    private Boolean recurring;
    @JsonProperty("snippetCount")
    private Integer snippetCount;
    @JsonProperty("snippetOffset")
    private Integer snippetOffset;
    @JsonProperty("statementId")
    private String statementId;
    @JsonProperty("statementIndex")
    private Integer statementIndex;
    @JsonProperty("statementIndexOffset")
    private Integer statementIndexOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accessionNumber")
    public String getAccessionNumber() {
        return accessionNumber;
    }

    @JsonProperty("accessionNumber")
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    @JsonProperty("collapsedStatements")
    public List<String> getCollapsedStatements() {
        return collapsedStatements;
    }

    @JsonProperty("collapsedStatements")
    public void setCollapsedStatements(List<String> collapsedStatements) {
        this.collapsedStatements = collapsedStatements;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("context")
    public Boolean getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(Boolean context) {
        this.context = context;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("recurring")
    public Boolean getRecurring() {
        return recurring;
    }

    @JsonProperty("recurring")
    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    @JsonProperty("snippetCount")
    public Integer getSnippetCount() {
        return snippetCount;
    }

    @JsonProperty("snippetCount")
    public void setSnippetCount(Integer snippetCount) {
        this.snippetCount = snippetCount;
    }

    @JsonProperty("snippetOffset")
    public Integer getSnippetOffset() {
        return snippetOffset;
    }

    @JsonProperty("snippetOffset")
    public void setSnippetOffset(Integer snippetOffset) {
        this.snippetOffset = snippetOffset;
    }

    @JsonProperty("statementId")
    public String getStatementId() {
        return statementId;
    }

    @JsonProperty("statementId")
    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    @JsonProperty("statementIndex")
    public Integer getStatementIndex() {
        return statementIndex;
    }

    @JsonProperty("statementIndex")
    public void setStatementIndex(Integer statementIndex) {
        this.statementIndex = statementIndex;
    }

    @JsonProperty("statementIndexOffset")
    public Integer getStatementIndexOffset() {
        return statementIndexOffset;
    }

    @JsonProperty("statementIndexOffset")
    public void setStatementIndexOffset(Integer statementIndexOffset) {
        this.statementIndexOffset = statementIndexOffset;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}