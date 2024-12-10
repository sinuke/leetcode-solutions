package com.sinuke.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseTestData {

    private boolean enabled = true;
    private String title;
    private int number;

    @Override
    public String toString() {
        return title;
    }

}
