package com.cognizant;
import org.mockito.InOrder;

// Exercise 1: Mocking and Stubbing
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("Mock Data");

        MyService service =
                new MyService(mockApi);

        String result =
                service.fetchData();

        assertEquals(
                "Mock Data",
                result
        );
    }
}
// Exercise 2: Verifying Interactions
@Test
void testVerifyInteraction() {

    ExternalApi mockApi =
            mock(ExternalApi.class);

    MyService service =
            new MyService(mockApi);

    service.fetchData();

    verify(mockApi)
            .getData();
}
// Exercise 3: Argument Matching
@Test
void testArgumentMatching() {

    ExternalApi mockApi =
            mock(ExternalApi.class);

    when(mockApi.getDataById(anyInt()))
            .thenReturn("Matched Data");

    MyService service =
            new MyService(mockApi);

    service.fetchDataById(100);

    verify(mockApi)
            .getDataById(anyInt());
}
// Exercise 4: Handling Void Methods
@Test
void testVoidMethod() {

    ExternalApi mockApi =
            mock(ExternalApi.class);

    doNothing()
            .when(mockApi)
            .sendData(anyString());

    MyService service =
            new MyService(mockApi);

    service.submitData("Hello");

    verify(mockApi)
            .sendData("Hello");
}
// Exercise 5: Multiple Return Values
@Test
void testMultipleReturns() {

    ExternalApi mockApi =
            mock(ExternalApi.class);

    when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");

    MyService service =
            new MyService(mockApi);

    assertEquals(
            "First Call",
            service.fetchData()
    );

    assertEquals(
            "Second Call",
            service.fetchData()
    );

    assertEquals(
            "Third Call",
            service.fetchData()
    );
}
// Exercise 6: Verifying Interaction Order
@Test
void testInteractionOrder() {

    ExternalApi mockApi =
            mock(ExternalApi.class);

    mockApi.getData();
    mockApi.sendData("Test");

    InOrder inOrder =
            inOrder(mockApi);

    inOrder.verify(mockApi)
            .getData();

    inOrder.verify(mockApi)
            .sendData("Test");
}
// Exercise 7: Void Method Throwing Exception
@Test
void testVoidMethodException() {

    ExternalApi mockApi =
            mock(ExternalApi.class);

    doThrow(
            new RuntimeException(
                    "Process Failed"
            )
    )
    .when(mockApi)
    .process();

    MyService service =
            new MyService(mockApi);

    RuntimeException exception =
            assertThrows(
                    RuntimeException.class,
                    service::executeProcess
            );

    assertEquals(
            "Process Failed",
            exception.getMessage()
    );

    verify(mockApi)
            .process();
}