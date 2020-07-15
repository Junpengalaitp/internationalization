package com.alaitp.internationalization.mapper;

import com.alaitp.internationalization.BaseJunitTest;
import com.alaitp.internationalization.entity.I18nContent;
import com.alaitp.internationalization.util.Builder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class I18nContentDaoTest extends BaseJunitTest {
    @Autowired
    private I18nContentDao i18nContentDao;

    @Test
    @Order(1)
    void testInsert() {
        I18nContent i18nContent = Builder.of(I18nContent::new)
                .with(I18nContent::setType, "test")
                .with(I18nContent::setEn, "test")
                .with(I18nContent::setCn, "测试")
                .build();
        int res = i18nContentDao.insert(i18nContent);
        assertTrue(res != 0);
    }

    @Test
    @Order(2)
    void testSelectOne() {
        QueryWrapper<I18nContent> queryWrapper = new QueryWrapper<>();
        I18nContent res = i18nContentDao.selectOne(queryWrapper.lambda().eq(I18nContent::getType, "test"));
        System.out.println(res);
        assertNotNull(res);
    }

    @Test
    @Order(3)
    void testSelectList() {
        List<I18nContent> res = i18nContentDao.selectList(null);
        System.out.println(res);
        assertTrue(res.size() != 0);
    }

    @Test
    @Order(4)
    void testSelectDelete() {
        QueryWrapper<I18nContent> queryWrapper = new QueryWrapper<>();
        int res = i18nContentDao.delete(queryWrapper.lambda().eq(I18nContent::getType, "test"));
        System.out.println(res);
        assertTrue(res != 0);
    }
}