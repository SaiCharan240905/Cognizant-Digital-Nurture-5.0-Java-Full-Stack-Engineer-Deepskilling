package com.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NetworkServiceTest {

    @Test
    void testServiceWithMockNetworkClient() {

        NetworkClient mockClient =
                mock(NetworkClient.class);

        when(mockClient.connect())
                .thenReturn(
                        "Mock Connection"
                );

        NetworkService service =
                new NetworkService(mockClient);

        String result =
                service.connectToServer();

        assertEquals(
                "Connected to Mock Connection",
                result
        );
    }
}