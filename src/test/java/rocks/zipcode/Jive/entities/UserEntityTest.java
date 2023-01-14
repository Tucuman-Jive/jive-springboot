//package rocks.zipcode.Jive.entities;
//import static org.hamcrest.Matchers.hasItems;
//import static org.junit.Assert.assertThat;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.hamcrest.Matcher;
//import org.junit.Test;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//
//public class UserEntityTest {
//    @Test
//    public void testThreeArgumentConstructor() {
//        UserEntity user = new UserEntity(1L, "john", "password");
//        assertEquals(1L, user.getId().longValue());
//        assertEquals("john", user.getUserName());
//        assertEquals("password", user.getPassword());
//    }
//
//}
//    @Test
//    public void testMembershipsGettersAndSetters() {
//        UserEntity user = new UserEntity();
//        Set<Membership> memberships = new HashSet<>();
//        memberships.add(new Membership());
//        user.setMemberships(memberships);
//
//        assertThat(user.getMemberships(), hasItems(memberships.toArray()));
//    }
//
//    private void assertThat(Set<Membership> memberships, Matcher<Iterable<Object>> hasItems) {
//    }
//
//    @Test
//    public void testMessagesGettersAndSetters() {
//        UserEntity user = new UserEntity();
//        Set<Message> messages = new HashSet<>();
//        messages.add(new Message());
//        user.setMessages(messages);
//
//        assertEquals(messages, user.getMessages());
//    }
//
//
//
//
//
////    @Test
////    public void testGettersAndSetters() {
////        UserEntity user = new UserEntity();
////        Long testId = 1L;
////        String testUsername = "testuser";
////        String testPassword = "password";
////        Set<Membership> testMemberships = new HashSet<>();
////
////        user.setId(testId);
////        user.setUserName(testUsername);
////        user.setPassword(testPassword);
////        user.setMemberships(testMemberships);
////
////        assertEquals(testId, user.getId());
////        assertEquals(testUsername, user.getUserName());
////        assertEquals(testPassword, user.getPassword());
////        assertEquals(testMemberships, user.getMemberships());
////    }
////
////    @Test
////    public void testDefaultConstructor() {
////        UserEntity user = new UserEntity();
////        assertNotNull(user);
////    }
////
////    @Test
////    public void testEquals() {
////        UserEntity user1 = new UserEntity();
////        user1.setId(1L);
////        user1.setUserName("testuser");
////        user1.setPassword("password");
////        user1.setMemberships(new HashSet<>());
////
////        UserEntity user2 = new UserEntity();
////        user2.setId(1L);
////        user2.setUserName("testuser");
////        user2.setPassword("password");
////        user2.setMemberships(new HashSet<>());
////
////        assertTrue(user1.equals(user2));
////        user2.setId(2L);
////        assertFalse(user1.equals(user2));
////    }
////
////    @Test
////    public void testHashCode() {
////        UserEntity user1 = new UserEntity();
////        user1.setId(1L);
////        user1.setUserName("testuser");
////        user1.setPassword("password");
////        user1.setMemberships(new HashSet<>());
////
////        UserEntity user2 = new UserEntity();
////        user2.setId(1L);
////        user2.setUserName("testuser");
////        user2.setPassword("password");
////        user2.setMemberships(new HashSet<>());
////
////        assertEquals(user1.hashCode(), user2.hashCode());
////    }
////}
////
////    @Test
////    public void testNullFields() {
////        UserEntity user = new UserEntity();
////        assertNull(user.getId());
////        assertNull(user.getUserName());
////        assertNull(user.getPassword());
////        assertNotNull(user.getMemberships());
////        assertTrue(user.getMemberships().isEmpty());
////    }
//}