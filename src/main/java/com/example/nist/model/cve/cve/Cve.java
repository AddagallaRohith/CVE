package com.example.nist.model.cve.cve;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cve{
    public String data_type;
    public String data_format;
    public String data_version;
    @JsonProperty("CVE_data_meta")
    public CVEDataMeta cVE_data_meta;
    public Description description;
    public References references;
    public Problemtype problemtype;
}