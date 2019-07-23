package com.ericmulek.springthymleaf.controller

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Slf4j
@Controller
class HelloController {

    @Autowired
    ConversionService conversionService

    @GetMapping
    String getHome(Model model) {
        LocalDateTime dateTime = LocalDateTime.now()
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyy-MM-dd HH:mm:ss')
        model.addAttribute('serverTime', dateTime.format(formatter))
        log.info('HOME*****')
        'home'
    }

    @GetMapping('/feature1')
    String getFeature1(Model model) {

        'feature1'
    }

    @GetMapping('/feature2')
    String getFeature2(Model model) {

        'feature2'
    }
}
