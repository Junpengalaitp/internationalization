package com.alaitp.internationalization.service.impl;

import com.alaitp.internationalization.BaseJunitTest;
import com.alaitp.internationalization.service.I18nService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class I18nServiceImplTest extends BaseJunitTest {

    @Autowired
    private I18nService i18nService;

    @Test
    void getContentCN() {
        String res = i18nService.getContent("test", "cn");
        System.out.println(res);
        assertEquals("测试", res);
    }

    @Test
    void getContentEN() {
        String res = i18nService.getContent("test", "en");
        System.out.println(res);
        assertEquals("test", res);
    }
}