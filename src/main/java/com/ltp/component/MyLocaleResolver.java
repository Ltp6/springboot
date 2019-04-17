package com.ltp.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * @ClassName MyLocaleResolver
 * @Auther Ltp
 * @Date 2019/4/18 00:08
 * @Description //TODO
 * @Version 1.0
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        System.out.println(language);
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}