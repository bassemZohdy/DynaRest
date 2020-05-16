package com.dynarest.converters;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dynarest.documents.ResourceData;

@Component
public class ResourceDataToDocumentConverter implements Converter<ResourceData, Document> {

	@Override
	public Document convert(ResourceData source) {
		System.out.println("ResourceDataToDocumentConverter");
		Document doc = new Document();
		// doc.put(key, value)
		doc.put("_id", source.getId());
		doc.put("_resourceId", source.getResourceId());
		doc.put("_resourceName", source.getResourceName());
		doc.put("_resourceVersion", source.getResourceVersion());
		doc.putAll(source.getData());
		doc.put("_class", ResourceData.class.getName());
		doc.put("_version", source.getDataVersion());
		return doc;
	}

}
