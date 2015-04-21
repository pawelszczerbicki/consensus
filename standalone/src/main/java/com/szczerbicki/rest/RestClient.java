package com.szczerbicki.rest;

import com.szczerbicki.json.JsonResponse;
import com.szczerbicki.json.SuccessResponse;
import com.szczerbicki.task.TaskDto;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
public class RestClient {

    @SuppressWarnings("unchecked")
    public Optional<TaskDto> get(String url) {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        JsonResponse res = rt.getForObject(url, JsonResponse.class);
        if (res instanceof SuccessResponse)
            return ofNullable((res.getData()));
        return empty();
    }



    public String fileAsString(String url) {
        RestTemplate r = new RestTemplate();
        r.setMessageConverters(singletonList(new StringHttpMessageConverter()));
        return r.getForObject(url, String.class);
    }

    public void finish(TaskDto t) {
        try {
            String json = new ObjectMapper().writer().writeValueAsString(t);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            new RestTemplate().exchange(String.format(TASK_FINISHED_URL, t.getId()), POST, entity, String.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
