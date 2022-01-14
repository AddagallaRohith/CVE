package com.example.nist.model.cve.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class Configurations{
    @JsonProperty("CVE_data_version")
    public String cVE_data_version;
    public ArrayList<Node> nodes;
}