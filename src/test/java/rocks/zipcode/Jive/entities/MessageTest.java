package rocks.zipcode.Jive.entities;

import java.security.Timestamp;
import static org.junit.Assert.*;
import org.junit.Test;

public class MessageTest {




//    @Test
//    public void testGettersAndSetters() {
//        Message message = new Message();
//        Long testId = 1L;
//        Long testIdUser = 2L;
//        Long testIdChannel = 3L;
//        String testMessage = "Test message";
//        Timestamp testTimestamp = new Timestamp(System.currentTimeMillis());
//        Channel testChannel = new Channel();
//
//        message.setId(testId);
//        message.setIdUser(testIdUser);
//        message.setIdChannel(testIdChannel);
//        message.setMessage(testMessage);
//        message.setCreatedAt(testTimestamp);
//        message.setChannel(testChannel);
//
//        assertEquals(testId, message.getId());
//        assertEquals(testIdUser, message.getIdUser());
//        assertEquals(testIdChannel, message.getIdChannel());
//        assertEquals(testMessage, message.getMessage());
//        assertEquals(testTimestamp, message.getCreatedAt());
//        assertEquals(testChannel, message.getChannel());
//    }

    @Test
    public void testDefaultConstructor() {
        Message message = new Message();
        assertNotNull(message);
    }

//    @Test
//    public void testEquals() {
//        Message message1 = new Message();
//        message1.setId(1L);
//        message1.setIdUser(2L);
//        message1.setIdChannel(3L);
//        message1.setMessage("Test message");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        message1.setCreatedAt(timestamp);
//        message1.setChannel(new Channel());
//        Message message2 = new Message();
//        message2.setId(1L);
//        message2.setIdUser(2L);
//        message2.setIdChannel(3L);
//        message2.setMessage("Test message");
//        message2.setCreatedAt(timestamp);
//        message2.setChannel(new Channel());
//        assertTrue(message1.equals(message2));
//        message2.setId(2L);
//        assertFalse(message1.equals(message2));
//    }

//    @Test
//    public void testHashCode() {
//        Message message1 = new Message();
//        message1.setId(1L);
//        message1.setIdUser(2L);
//        message1.setIdChannel(3L);
//        message1.setMessage("Test message");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        message1.setCreatedAt(timestamp);
//        message1.setChannel(new Channel());
//        Message message2 = new Message();
//        message2.setId(1L);
//        message2.setIdUser(2L);
//        message2.setIdChannel(3L);
//        message2.setMessage("Test message");
//        message2.setCreatedAt(timestamp);
//        message2.setChannel(new Channel());
//        assertEquals(message1.hashCode(), message2.hashCode());
//    }

//    @Test
//    public void testNullFields() {
//        Message message = new Message();
//        assertNull(message.getId());
//        assertNull(message.getIdUser());
//        assertNull(message.getIdChannel());
//        assertNull(message.getMessage());
//        assertNull(message.getCreatedAt());
//        assertNull(message.getChannel());
//    }

}
