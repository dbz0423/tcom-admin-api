package top.zhu.tcomadminapi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ScreenServiceImplTest {

    @Autowired
    ScreenServiceImpl screenService;

    @Test
    void getExamination() {
        log.info(screenService.getExamination(3).toString());
    }

    @Test
    void getExamination2() {log.info(screenService.getExaminees(3).toString());}
}