package com.example.util;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/7 19:47
 * @desc
 */
public class DateConverter implements Converter<String,Date> {

    @SneakyThrows
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(s);
    }
}
