package com.rethinkdb.rethinkdbdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePersonResponse implements Serializable {
    private Person new_val;
    private Person old_val;
}
