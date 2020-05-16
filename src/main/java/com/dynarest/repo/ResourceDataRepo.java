package com.dynarest.repo;

import java.util.UUID;

import com.dynarest.documents.ResourceData;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceDataRepo extends MongoRepository<ResourceData,ObjectId>{
    
}