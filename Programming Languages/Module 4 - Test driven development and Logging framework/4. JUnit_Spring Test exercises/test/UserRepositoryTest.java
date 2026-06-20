@Test
void testFindByName() {

    User user = new User();
    user.setName("Sai");

    repository.save(user);

    List<User> users =
            repository.findByName("Sai");

    assertEquals(
            1,
            users.size()
    );
}