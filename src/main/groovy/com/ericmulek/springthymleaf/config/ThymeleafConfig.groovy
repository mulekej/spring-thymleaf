package com.ericmulek.springthymleaf.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver

@Configuration
class ThymeleafConfig {

    @Bean
    ResourceBundleMessageSource messageSource() {
        new ResourceBundleMessageSource().tap {
            basename = 'messages'
        }
    }

    @Bean
    SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver, ResourceBundleMessageSource messageSource) {
        new SpringTemplateEngine().tap {
            it.templateResolver = templateResolver
            it.templateEngineMessageSource = messageSource
        }
    }

    @Bean
    ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        def viewResolver = new ThymeleafViewResolver()
        viewResolver.templateEngine = templateEngine
        viewResolver
    }
}
