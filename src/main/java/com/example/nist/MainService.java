package com.example.nist;

import com.example.nist.model.cve.CveItem;
import com.example.nist.model.cve.Root;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class MainService {

    @Async
    public void getDetails(Map<String, List<Object>> requestParams) throws InterruptedException {
        int startIndex = 0;
        int resultsPerPage = 2000;
        int remainingCount = 0;
        boolean firstCall = true;
        String url = "https://services.nvd.nist.gov/rest/json/cves/1.0?apiKey=&resultsPerPage=2000&startIndex=";

        do {
            //Thread.sleep(1000);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<Root> responseEntity;
            String completeUrl = url + startIndex;
            System.out.println("url is : " + completeUrl);
            try {
                responseEntity = restTemplate.exchange(completeUrl, HttpMethod.GET, requestEntity, Root.class);
            }
            catch (final HttpClientErrorException e) {
                System.out.println(e.getStatusCode());
                System.out.println(e.getResponseBodyAsString());
                System.out.println("Got error...retrying in 5 secs.....");
                Thread.sleep(5000);
                continue;
            }



            if(firstCall){
                //System.out.println("Total count" + remainingCount);
                firstCall = false;
                remainingCount = responseEntity.getBody().totalResults;
                System.out.println("Total count..." + remainingCount);
            }
            remainingCount = remainingCount  - resultsPerPage;
            System.out.println("page " + startIndex + "..processed..." + "remaing.." + remainingCount);
            startIndex = startIndex + resultsPerPage;

        }while(remainingCount > 0 );

        /*if(requestParams != null){
            for(Map.Entry<String, List<Object>> requestParam: requestParams.entrySet()){
                for(Object object: requestParam.getValue()){
                    //builder.queryParam(requestParam.getKey(), object);
                }
            }
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Root> responseEntity;

            responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, Root.class);
        System.out.println("call made");*/

    }
}
