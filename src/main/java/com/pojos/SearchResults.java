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
        "cursorToken",
        "originalStatementCount",
        "statements"
})
@Generated("jsonschema2pojo")
public class SearchResults {

    @JsonProperty("cursorToken")
    private Object cursorToken;
    @JsonProperty("originalStatementCount")
    private Integer originalStatementCount;
    @JsonProperty("statements")
    private List<Statement> statements = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cursorToken")
    public Object getCursorToken() {
        return cursorToken;
    }

    @JsonProperty("cursorToken")
    public void setCursorToken(Object cursorToken) {
        this.cursorToken = cursorToken;
    }

    @JsonProperty("originalStatementCount")
    public Integer getOriginalStatementCount() {
        return originalStatementCount;
    }

    @JsonProperty("originalStatementCount")
    public void setOriginalStatementCount(Integer originalStatementCount) {
        this.originalStatementCount = originalStatementCount;
    }

    @JsonProperty("statements")
    public List<Statement> getStatements() {
        return statements;
    }

    @JsonProperty("statements")
    public void setStatements(List<Statement> statements) {
        this.statements = statements;
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