package com.josemorenoesteban.benchmack.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attrib {
    @JsonProperty("id")       public String   id;
    @JsonProperty("type")     public String   type;
    @JsonProperty("value")    public String   value;
    @JsonProperty("children") public Attrib[] children;
}
