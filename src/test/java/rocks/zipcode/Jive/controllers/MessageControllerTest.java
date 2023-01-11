package rocks.zipcode.Jive.controllers;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rocks.zipcode.Jive.entities.Message;
import rocks.zipcode.Jive.services.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @Test
    void testAddMessage() {
        messageController.addMessage(new Message());
        verify(messageService, times(1)).saveMessage(any(Message.class));
    }

    @Test
    void testGetAllMessages() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message());
        when(messageService.getAllMessages()).thenReturn(messages);
        List<Message> result = messageController.getAllMessages();
        assertEquals(messages, result);
    }

    @Test
    void testGetMessageByIdSuccess() {
        Message message = new Message();
        when(messageService.getMessageById(anyLong())).thenReturn(message);
        ResponseEntity<Message> result = messageController.getMessageById(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(message, result.getBody());
    }

    @Test
    void testGetMessageByIdNotFound() {
        when(messageService.getMessageById(anyLong())).thenThrow(NoSuchElementException.class);
        ResponseEntity<Message> result = messageController.getMessageById(1L);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    // @Test
    // void testUpdateSuccess() {
    // Message message = new Message();
    // when(messageService.getMessageById(anyLong())).thenReturn(message);
    // messageController.update(new Message(), 1L);
    // verify(messageService, times(1)).update(anyLong(), any(Message.class));
    // }
    //
    // @Test
    // void testUpdateNotFound() {
    // when(messageService.getMessageById(anyLong())).thenThrow(NoSuchElementException.class);
    // ResponseEntity<Message> result = messageController.update(new Message(), 1L);
    // assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    // assertEquals(null, result.getBody());
    // }

    @Test
    void testDelete() {
        messageController.delete(1L);
        verify(messageService, times(1)).deleteMessageById(1L);
    }

    @Test
    void testAddMessageByChannelAndUser() {
        messageController.addMessageByChannelAndUser(new Message(), 1L, 2L);
        verify(messageService, times(1)).addMessageByChannelAndUser(any(Message.class), anyLong(), anyLong());
    }

//    @Test
//    void testGetMessagesByChannelId() {
//        List<Message> messages = new ArrayList<>();
//        messages.add(new Message());
//        when(messageService.findByChannelName(anyString())).thenReturn(messages);
//        List<Message> result = messageController.getMessagesByChannelId("channelId");
//        assertEquals(messages, result);
//    }
}
