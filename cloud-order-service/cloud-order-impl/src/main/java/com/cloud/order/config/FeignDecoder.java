package com.cloud.order.config;

import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.nio.charset.StandardCharsets;

/**
 * feign 请求解码
 */
@Slf4j
public class FeignDecoder implements Decoder {

    @Override
    public Object decode(final Response response, Type type) throws IOException, FeignException {
        if (type instanceof Class || type instanceof ParameterizedType || type instanceof WildcardType) {
            var res = response.body().asReader(StandardCharsets.UTF_8).toString();
            log.info("---- res : " + res);
        }
        return response;
    }

}
