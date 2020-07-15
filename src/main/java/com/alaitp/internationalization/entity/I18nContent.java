package com.alaitp.internationalization.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class I18nContent implements Serializable {
    private static final long serialVersionUID = 4718471040318110975L;

    private String type;

    private String en;

    private String cn;

    public String getContent(String lang) {
        if ("cn".equals(lang)) {
            return cn;
        }
        return en;
    }
}