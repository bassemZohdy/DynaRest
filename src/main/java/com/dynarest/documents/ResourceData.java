package com.dynarest.documents;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

import lombok.Data;

@Document
@Data
public class ResourceData {

    @Id
    private ObjectId id;
    private Long resourceId;
    private String resourceName;
    private String resourceVersion;
    @JsonIgnore
    private Map<String,String> data=new HashMap<>();
    @Version
    private String dataVersion;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return data;
    }
    @JsonAnySetter
    public void add(String key, String value) {
        data.put(key, value);
    }

}