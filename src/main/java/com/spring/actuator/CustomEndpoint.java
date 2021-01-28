package com.spring.actuator;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
/*this is creating the custom endpoint for spring actuator */
@Component
@Endpoint(id="release-notes")
public class CustomEndpoint {

    Map<String, List<String>>  releaseNotes = new LinkedHashMap<>();

    @PostConstruct
    public void initNotes() {
        releaseNotes.put("v1.0", Arrays.asList("home page created","adding new item"));
        releaseNotes.put("v2.0", Arrays.asList("title page created","adding new item"));

    }
    //act as getmapping
    @ReadOperation
    public Map<String, List<String>> realseNotes(){
        return releaseNotes;
    }
    @ReadOperation
    public List<String> readRealeseNotes(@Selector String version){
        return releaseNotes.get(version);
    }

    //act as a postMapping
    @WriteOperation
    public String addReleaseNotes(@Selector String version,String releaseNotesData){
        releaseNotes.put(version,
                Arrays.stream(releaseNotesData.split(",")).collect(Collectors.toList()));
        return "release Notes added";
    }
    // act as a deleteMapping
    @DeleteOperation
    public void deleteReleaseNotes(@Selector String version){
        releaseNotes.remove(version);
    }
}
