package org.javaacademy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.javaacademy.dto.StatusDto;
import org.javaacademy.dto.UpdateGoodPriceDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private static final String URL_ONE = "http://localhost:8081/application/status";
    private static final String URL_TWO = "http://localhost:8082/application/status";

    @SneakyThrows
    public List<StatusDto> getStatus() {
        return List.of(getShopStatus(URL_ONE), getShopStatus(URL_TWO));
    }

    @SneakyThrows
    public StatusDto getShopStatus(String url) {
        Request request = new Request.Builder().get().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return mapper.readValue(response.body().string(), StatusDto.class);
            } else {
                throw new RuntimeException("Не удалось получить статус по ссылке: " + url);
            }
        }
    }

    @SneakyThrows
    public void updateGoodPrice(UpdateGoodPriceDto dto) {
        byte[] body = mapper.writeValueAsBytes(dto);
        RequestBody requestBody = RequestBody.create(body, MediaType.parse("application/json"));
        updatePrice(URL_ONE, requestBody);
        updatePrice(URL_TWO, requestBody);
    }

    @SneakyThrows
    public void updatePrice(String url, RequestBody body) {
        Request request = new Request.Builder()
                .patch(body)
                .url(url)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println("Продукт изменен!");
        }
    }
}
