package rocks.zipcode.Jive.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.Message;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.repositories.MessageRepository;
import rocks.zipcode.Jive.repositories.ChannelRepository;
import rocks.zipcode.Jive.repositories.UserRepository;

@SpringBootTest
public class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ChannelRepository channelRepository;

    private Message message;
    private UserEntity userEntity;
    private Channel channel;
    private List<Message> messages;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        message = new Message();
        message.setId(1L);
        message.setMessage("Test message");

        userEntity = new UserEntity();
        userEntity.setId(1L);

        channel = new Channel();
        channel.setId(1L);
        channel.setName("Test channel");

        messages = new ArrayList<>();
        messages.add(message);
    }

    @Test
    public void testGetAllMessages() {
        when(messageRepository.findAll()).thenReturn(messages);
        List<Message> result = messageService.getAllMessages();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test message", result.get(0).getMessage());
    }

    @Test
    public void testGetMessageById() {
        when(messageRepository.findById(1L)).thenReturn(Optional.of(message));
        Message result = messageService.getMessageById(1L);
        assertNotNull(result);
        assertEquals("Test message", result.getMessage());
    }

    // @Test
    // public void testSaveMessage() {
    // Message inputMessage = new Message();
    // inputMessage.setMessage("Test message");
    // when(messageRepository.save(inputMessage)).thenReturn(inputMessage);
    // Message result = messageService.saveMessage(inputMessage);
    // assertNotNull(result);
    // assertEquals("Test message", result.getMessage());
    // }

    @Test
    public void testDeleteMessageById() {
        messageService.deleteMessageById(1L);
    }

    @Test
        public void testUpdate() {
            when(messageRepository.findById(1L)).thenReturn(Optional.of(message));
            when(messageRepository.save(any(Message.class))).thenReturn(message);
            Message newMessageData = new Message();
            newMessageData.setId(2L);
            newMessageData.setMessage("Updated message");
            Message result = messageService.update(1L, newMessageData);
            assertNotNull(result);
            assertEquals(2L, result.getId());
            assertEquals("Updated message", result.getMessage());
        }

    @Test
        public void testAddMessageByChannelAndUser() {
            when(channelRepository.findById(1L)).thenReturn(Optional.of(channel));
            when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
            when(messageRepository.save(any(Message.class))).thenReturn(message);
            Message result = messageService.addMessageByChannelAndUser(message, 1L, 1L);
            assertNotNull(result);
            assertNotNull(result.getCreatedAt());
            assertEquals(userEntity, result.getUserEntity());
            assertEquals(channel, result.getChannel());
        }

    @Test
    public void testFindByChannelId() {
        // Create a test channel
        Channel channel = new Channel();
        channel.setName("Test channel");
        when(channelRepository.findById(channel.getId())).thenReturn(Optional.of(channel));

        // Create a test message and add it to the test channel
        Message message1 = new Message();
        message1.setMessage("Test message 1");
        message1.setChannel(channel);

        // Create another test message and add it to the test channel
        Message message2 = new Message();
        message2.setMessage("Test message 2");
        message2.setChannel(channel);

        // mock the repository to return messages
        when(messageRepository.findByChannelId(channel.getId())).thenReturn(Arrays.asList(message1, message2));

        // Find the messages by the test channel's ID
        List<Message> messages = messageService.findByChannelId(channel.getId());

        // Assert that the correct messages have been found
        assertEquals(2, messages.size());
        assertTrue(messages.contains(message1));
        assertTrue(messages.contains(message2));
    }



}