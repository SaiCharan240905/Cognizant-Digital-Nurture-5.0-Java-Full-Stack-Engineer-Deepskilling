@Test
void testHandleNotFound() {

    GlobalExceptionHandler handler =
            new GlobalExceptionHandler();

    ResponseEntity<String> response =
            handler.handleNotFound(
                    new NoSuchElementException()
            );

    assertEquals(
            404,
            response.getStatusCodeValue()
    );

    assertEquals(
            "User not found",
            response.getBody()
    );
}