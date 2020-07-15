package com.alaitp.internationalization.controller;

import com.alaitp.internationalization.service.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class I18nController {
    @Autowired
    private I18nService i18nService;

    @GetMapping("/i18n-content/{type}/{lang}")
    public String getContent(@PathVariable String type, @PathVariable String lang) {
        log.info("received PathVariable, type: {}, lang: {}", type, lang);
        return i18nService.getContent(type, lang);
    }
}
