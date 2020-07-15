package com.alaitp.internationalization.service;

public interface I18nService {
    /**
     * @param type
     * @return I18nContent by type and language
     */
    String getContent(String type, String lang);
}
