package com.dynarest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynarest.converters.DocumentToResourceDataConverter;
import com.dynarest.converters.ResourceDataToDocumentConverter;

@SpringBootApplication
public class DynarestApplication {
	@Autowired
	ResourceDataToDocumentConverter inConverter;
	@Autowired
	DocumentToResourceDataConverter outConverter;
	
	public static void main(String[] args) {
		SpringApplication.run(DynarestApplication.class, args);
	}
	
	@Bean
    public MongoCustomConversions customConversions(){
        List<Converter<?,?>> converters = new ArrayList<>();
        converters.add(inConverter);
        converters.add(outConverter);
        return new MongoCustomConversions(converters);
    }

}