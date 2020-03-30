package com.huae.ch4.springmvc.converter;

import com.huae.ch4.springmvc.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpMessageConverter extends AbstractHttpMessageConverter {

    public HttpMessageConverter() {
        // 自定义媒体类型(处理request和response中x-huae类型的message)
        super(new MediaType("application", "x-huae", Charset.forName("UTF-8")));
    }

    /**
     * 表明本MessageConverter只处理DemoObj这个类
     *
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports(Class clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    /**
     * 处理请求的数据 将数据转换为DemoObj对象
     *
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String s = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] split = s.split("-");
        return new DemoObj(new Long(split[0]), split[1]);
    }

    /**
     * 处理数据如何输出到Response中
     *
     * @param o
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        DemoObj o1 = (DemoObj) o;
        String out = "Hello:" + o1.getId() + "-" + o1.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}