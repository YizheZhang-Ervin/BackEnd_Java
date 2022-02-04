package com.ervin.XML_JSON;

import java.io.InputStream;
import java.util.List;

//import com.fasterxml.jackson.dateformat.xml.JacksonXmlModule;
//import com.fasterxml.jackson.dateformat.xml.XmlMapper;

public class XML_Jackson {
//    public static void main(String[] args) throws Exception {
//        InputStream input = XML_Jackson.class.getResourceAsStream("/Data/book.xml");
//        JacksonXmlModule module = new JacksonXmlModule();
//        XmlMapper mapper = new XmlMapper(module);
//        Book book = mapper.readValue(input, Book.class);
//        System.out.println(book.id);
//        System.out.println(book.name);
//        System.out.println(book.author);
//        System.out.println(book.isbn);
//        System.out.println(book.tags);
//        System.out.println(book.pubDate);
//    }
}

class Book {
    public long id;
    public String name;
    public String author;
    public String isbn;
    public List<String> tags;
    public String pubDate;
}