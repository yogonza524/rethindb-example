package com.rethinkdb.rethinkdbdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private String id;
    private String name;
    private String lastName;
    private String address;
    private String dni;
    private String mobile;
}
