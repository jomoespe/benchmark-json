package com.josemorenoesteban.benchmack.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {
    @JsonProperty("id_Ext")           public String   idExt;
    @JsonProperty("entryContainerID") public String   containerId;
    @JsonProperty("id")               public String   id;
    @JsonProperty("movement")         public String   movement;
    @JsonProperty("coreAttribs")      public Attrib[] coreAttribs;
}
