package rocks.zipcode.Jive.entities;//

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ChannelTest {

    @Test
    public void testId() {
        Channel channel = new Channel();
        Long id = 1L;
        channel.setId(id);
        assertEquals(id, channel.getId());
    }

    @Test
    public void testName() {
        Channel channel = new Channel();
        String name = "channel1";
        channel.setName(name);
        assertEquals(name, channel.getName());
    }

    @Test
    public void testDescription() {
        Channel channel = new Channel();
        String description = "channel for test";
        channel.setDescription(description);
        assertEquals(description, channel.getDescription());
    }

    // @Test
    // public void testCreatedAt() {
    // Channel channel = new Channel();
    // Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    // channel.setCreatedAt(createdAt);
    // assertEquals(createdAt, channel.getCreatedAt());
    // }
    //
    // @Test
    // public void testUpdatedAt() {
    // Channel channel = new Channel();
    // Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
    // channel.setUpdatedAt(updatedAt);
    // assertEquals(updatedAt, channel.getUpdatedAt());
    // }

    @Test
    public void testMemberships() {
        Channel channel = new Channel();
        Set<Membership> memberships = new HashSet<>();
        channel.setMemberships(memberships);
        assertEquals(memberships, channel.getMemberships());
    }

    @Test
    public void testMessages() {
        Channel channel = new Channel();
        Set<Message> messages = new HashSet<>();
        channel.setMessages(messages);
        assertEquals(messages, channel.getMessages());
    }
}

// @Test
// public void testId() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// Long id = 1L;
// when(channel.getId()).thenReturn(id);
// assertEquals(id, channel.getId());
// //verify if getId is called
// verify(channel).getId();
// }
//
// @Test
// public void testName() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// String name = "channel1";
// when(channel.getName()).thenReturn(name);
// channel.setName(name);
// assertEquals(name, channel.getName());
// //verify if setName and getName are called
// verify(channel).setName(name);
// verify(channel).getName();
// }
//
// @Test
// public void testDescription() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// String description = "channel for test";
// when(channel.getDescription()).thenReturn(description);
// channel.setDescription(description);
// assertEquals(description, channel.getDescription());
// //verify if setDescription and getDescription are called
// verify(channel).setDescription(description);
// verify(channel).getDescription();
// }
//
// @Test
// public void testCreatedAt() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// Timestamp createdAt = new Timestamp(System.currentTimeMillis());
// when(channel.getCreatedAt()).thenReturn(createdAt);
// channel.setCreatedAt(createdAt);
// assertEquals(createdAt, channel.getCreatedAt());
// //verify if setCreatedAt and getCreatedAt are called
// verify(channel).setCreatedAt(createdAt);
// verify(channel).getCreatedAt();
// }
//
// @Test
// public void testUpdatedAt() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
// when(channel.getUpdatedAt()).thenReturn(updatedAt);
// channel.setUpdatedAt(updatedAt);
// assertEquals(updatedAt, channel.getUpdatedAt());
// //verify if setUpdatedAt and getUpdatedAt are called
// verify(channel).setUpdatedAt(updatedAt);
// verify(channel).getUpdatedAt();
// }
//
//
// @Test
// public void testMemberships() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// Set<Membership> memberships = new HashSet<>();
// when(channel.getMemberships()).thenReturn(memberships);
// channel.setMemberships(memberships);
// assertEquals(memberships, channel.getMemberships());
// //verify if setMemberships and getMemberships are called
// verify(channel).setMemberships(memberships);
// verify(channel).getMemberships();
// }
//
// @Test
// public void testMessages() {
// //mock the Channel
// Channel channel = mock(Channel.class);
// Set<Message> messages = new HashSet<>();
// when(channel.getMessages()).thenReturn(messages);
// channel.setMessages(messages);
// assertEquals(messages, channel.getMessages());
// //verify if setMessages and getMessages are called
// verify(channel).setMessages(messages);
// verify(channel).getMessages();
// }
// }
