package com.josemorenoesteban.benchmack.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Unmashaler {
    private final static ObjectMapper MAPPER = new ObjectMapper();
    
    static Entity unmarshal(byte[] wpcEntityContent) throws IOException {
        return MAPPER.readValue(wpcEntityContent, Entity.class);
    }
}
