package com.mongo.crud.application.javaDriver;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoJavaDriveApp {

    private MongoClient mongo;

    public MongoJavaDriveApp() {}

    public static void main(String[] args) {
        new MongoJavaDriveApp().start();
    }

    public void start() {

        try {
            mongo = new MongoClient("localhost", 27017);

            MongoDatabase db = mongo.getDatabase("sampleDb");

            MongoCollection<Document> employeeCollection = db.getCollection("student");

//            Insert in collection
//            Document document  = new Document();
//            document.put("firstName","Yogesh");
//            document.put("lastName","Patil");
//            document.put("company","XYZ");
//            document.put("designation","Software Developer");
//            employeeCollection.insertOne(document);

//            Read from collection
            FindIterable<Document> documents = employeeCollection.find();
            MongoCursor<Document> iterator = documents.iterator();
            while (iterator.hasNext()){
                Document document1 = iterator.next();
                System.out.println("Document :: "+document1);
            }

        }catch (Exception e){
            e.printStackTrace();
            return;
        }
    }

}
