package com.szczerbicki.rest;

import com.szczerbicki.json.JsonResponse;
import com.szczerbicki.json.SuccessResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

import static com.szczerbicki.utils.Keys.TASK_FINISHED_URL;
import static java.util.Collections.singletonList;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpMethod.POST;

/**
 * Created by pawel on 20.04.15.
 */
public class RestClient<T> {

    @SuppressWarnings("unchecked")
    public Optional<T> get(String url) {
        JsonResponse<T> res = new RestTemplate().getForObject(url, JsonResponse.class);
        if (res instanceof SuccessResponse)
            return ofNullable((res.getData()));
        return empty();
    }

    public String fileAsString(String url) {
        RestTemplate r = new RestTemplate();
        r.setMessageConverters(singletonList(new StringHttpMessageConverter()));
        return r.getForObject(url, String.class);
    }

    public void finish(T t) {
        try {
            String json = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(t);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            new RestTemplate().exchange(TASK_FINISHED_URL, POST, entity, String.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
