package com.alaitp.internationalization.service.impl;

import com.alaitp.internationalization.entity.I18nContent;
import com.alaitp.internationalization.mapper.I18nContentDao;
import com.alaitp.internationalization.service.I18nService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class I18nServiceImpl implements I18nService {

    @Autowired
    private I18nContentDao i18nContentDao;

    /**
     * @param type
     * @param lang
     * @return I18nContent by type and language
     */
    @Override
    public String getContent(String type, String lang) {
        QueryWrapper<I18nContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("type", lang).lambda().eq(I18nContent::getType, type);
        I18nContent i18nContent = i18nContentDao.selectOne(queryWrapper);
        return i18nContent.getContent(lang);
    }
}
