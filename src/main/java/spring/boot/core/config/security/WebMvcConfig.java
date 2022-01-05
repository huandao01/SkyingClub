package spring.boot.core.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import spring.boot.core.msg.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

//@Configuration
public class WebMvcConfig {
//  @Bean
//  public LocaleResolver localeResolver() {
//    CookieLocaleResolver lr = new CookieLocaleResolver() {
//      @Override
//      protected Locale determineDefaultLocale(HttpServletRequest request) {
//        Locale defaultLocale = getDefaultLocale();
//        if (request.getHeader("Accept-Language") != null) {
//          defaultLocale = request.getLocale();
//        }
//        return defaultLocale;
//      }
//    };
//
//    lr.setDefaultLocale(Message.getLocaleDefault());
//    return lr;
//  }
}
