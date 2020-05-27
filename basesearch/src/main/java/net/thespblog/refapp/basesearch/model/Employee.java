package net.thespblog.refapp.basesearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName= "ducat")
public class Employee {
    @Id
    private String id;
    private String name;
    private String designation;
}