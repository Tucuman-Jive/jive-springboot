package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.Message;
import rocks.zipcode.Jive.services.MessageService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/add")
    public String addMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
        return "Channel message has been saved";
    }

    @GetMapping("/all")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        try {
            Message message = messageService.getMessageById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@RequestBody Message message, @PathVariable Long id) {
        try {
            messageService.update(id , message); // why no id?
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        messageService.deleteMessageById(id);
        return "Channel Message " + id + " has been deleted.";
    }

    @PostMapping("/add/user/{userId}/channel/{channelId}")
    public String addMessageByChannelAndUser(@RequestBody Message message, @PathVariable Long channelId,@PathVariable Long userId) {
        messageService.addMessageByChannelAndUser(message, channelId, userId);
        return "message has been added to message repository";
    }

    @GetMapping("/all/channel/{channelId}")
    public List<Message> getMessagesByChannelId(@PathVariable Long channelId){
        return messageService.findByChannelId(channelId);
    }
}
