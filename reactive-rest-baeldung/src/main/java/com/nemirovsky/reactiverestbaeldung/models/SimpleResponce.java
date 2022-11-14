package com.nemirovsky.reactiverestbaeldung.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponce {
    private String id;
    private String message;
}