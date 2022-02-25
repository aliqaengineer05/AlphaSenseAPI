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
        "topics",
        "searchResults"
})
@Generated("jsonschema2pojo")
public class PojoAlphaSense {

    @JsonProperty("topics")
    private List<Object> topics = null;
    @JsonProperty("searchResults")
    private SearchResults searchResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("topics")
    public List<Object> getTopics() {
        return topics;
    }

    @JsonProperty("topics")
    public void setTopics(List<Object> topics) {
        this.topics = topics;
    }

    @JsonProperty("searchResults")
    public SearchResults getSearchResults() {
        return searchResults;
    }

    @JsonProperty("searchResults")
    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
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