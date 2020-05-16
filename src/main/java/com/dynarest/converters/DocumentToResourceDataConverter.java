package com.dynarest.converters;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dynarest.documents.ResourceData;

@Component
public class DocumentToResourceDataConverter implements Converter<Document, ResourceData> {

	@Override
	public ResourceData convert(Document source) {
		System.out.println("DocumentToResourceDataConverter");
		ResourceData data = new ResourceData();
		source.forEach((k,v)->{
			if(k.equals("_id"))
				data.setId((ObjectId) v);
			else if(k.equals("_resourceId"))
				data.setResourceId((Long) v);
			else if(k.equals("_resourceName"))
				data.setResourceName((String) v);
			else if(k.equals("_resourceVersion"))
				data.setResourceVersion((String) v);
			else if(k.equals("_version"))
				data.setDataVersion((String) v);
			else
				data.add(k, (String) v);
		});
		return data;
	}

}
