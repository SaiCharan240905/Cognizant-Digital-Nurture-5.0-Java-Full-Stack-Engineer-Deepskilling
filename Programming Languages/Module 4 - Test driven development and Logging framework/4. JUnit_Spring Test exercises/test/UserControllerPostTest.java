@Test
void testCreateUser() throws Exception {

    mockMvc.perform(
            post("/users")
                    .contentType("application/json")
                    .content("""
                    {
                        "name":"Sai"
                    }
                    """)
    )
    .andExpect(status().isOk());
}