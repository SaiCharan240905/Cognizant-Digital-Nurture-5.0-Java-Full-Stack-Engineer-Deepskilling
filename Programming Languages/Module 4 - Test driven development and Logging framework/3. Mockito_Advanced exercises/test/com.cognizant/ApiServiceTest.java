package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApiServiceTest {

    @Test
    void testServiceWithMockRestClient() {

        RestClient mockClient =
                mock(RestClient.class);

        when(mockClient.getResponse())
                .thenReturn("Mock Response");

        ApiService apiService =
                new ApiService(mockClient);

        String result =
                apiService.fetchData();

        assertEquals(
                "Fetched Mock Response",
                result
        );
    }
}