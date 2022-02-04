package com.ervin.EZSpring.Utils.IOUtils;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.InputStream;

public class ReadXmlByJackson {
    public static void main(String[] args) throws Exception {
        InputStream input = ReadXmlByJackson.class.getResourceAsStream("classpath:/IOTest.xml");
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(module);
        XXXML xxxml = mapper.readValue(input, XXXML.class);
        System.out.println(xxxml.id);
        System.out.println(xxxml.name);
    }
}

class XXXML {
    public long id;
    public String name;
}