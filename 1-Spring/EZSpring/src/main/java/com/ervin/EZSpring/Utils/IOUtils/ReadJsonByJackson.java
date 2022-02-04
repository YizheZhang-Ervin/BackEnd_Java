package com.ervin.EZSpring.Utils.IOUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class ReadJsonByJackson {
    public static void main(String[] args) throws Exception {
        InputStream input = ReadJsonByJackson.class.getResourceAsStream("classpath:/IOTest.json");
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        // 反序列化时忽略不存在的JavaBean属性:
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        XXXML2 xxxml2 = mapper.readValue(input, XXXML2.class);
        System.out.println(xxxml2.id);
        System.out.println(xxxml2.name);
        System.out.println(xxxml2.isbn);
        // 序列化为JSON:
        String json = mapper.writeValueAsString(xxxml2);
        System.out.println(json);
    }
}

class IsbnDeserializer extends JsonDeserializer<BigInteger> {

    @Override
    public BigInteger deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        String s = p.getValueAsString();
        if (s != null) {
            try {
                return new BigInteger(s.replace("-", ""));
            } catch (NumberFormatException e) {
                throw new JsonParseException(p, s, e);
            }
        }
        return null;
    }
}

class XXXML2 {
    public long id;
    public String name;
    @JsonDeserialize(using = IsbnDeserializer.class)
    public BigInteger isbn;
}