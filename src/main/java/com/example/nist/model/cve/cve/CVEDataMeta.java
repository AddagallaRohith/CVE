package com.example.nist.model.cve.cve;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CVEDataMeta{
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("ASSIGNER")
    public String aSSIGNER;
}