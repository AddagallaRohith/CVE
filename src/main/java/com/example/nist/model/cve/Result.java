package com.example.nist.model.cve;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result{
    @JsonProperty("CVE_data_type")
    public String cVE_data_type;
    @JsonProperty("CVE_data_format")
    public String cVE_data_format;
    @JsonProperty("CVE_data_version")
    public String cVE_data_version;
    @JsonProperty("CVE_data_timestamp")
    public String cVE_data_timestamp;
    @JsonProperty("CVE_Items")
    public List<CveItem> cVE_Items;
}
