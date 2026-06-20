@Test
void testUserNotFound() {

    when(userRepository.findById(100L))
            .thenReturn(Optional.empty());

    User result =
            userService.getUserById(100L);

    assertNull(result);
}