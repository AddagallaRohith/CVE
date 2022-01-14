package com.example.nist.model.cve.configurations;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String operator;
    public ArrayList<Child> children;
    public List<CpeMatch> cpe_match;
}
