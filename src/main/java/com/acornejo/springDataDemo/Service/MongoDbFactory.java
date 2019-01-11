package com.acornejo.springDataDemo.Service;

import com.mongodb.client.MongoDatabase;
import org.springframework.dao.DataAccessException;

public interface MongoDbFactory {
    MongoDatabase getDb() throws DataAccessException;

    MongoDatabase getDb(String dbName) throws DataAccessException;
}
