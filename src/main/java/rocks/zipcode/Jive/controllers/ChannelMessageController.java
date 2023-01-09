package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.Message;
import rocks.zipcode.Jive.services.ChannelMessageService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/channelmessages")
public class ChannelMessageController {
    @Autowired
    ChannelMessageService channelMessageService;

    @PostMapping("/add")
    public String addChannelMessage(@RequestBody Message message) {
        channelMessageService.saveChannelMessage(message);
        return "Channel message has been saved";
    }

    @GetMapping("/all")
    public List<Message> getAllChannelMessages() {
        return channelMessageService.getAllChannelMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getChannelMessageById(@PathVariable Long id) {
        try {
            Message message = channelMessageService.getChannelMessageById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@RequestBody Message message, @PathVariable Long id) {
        try {
            channelMessageService.update(id , message); // why no id?
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        channelMessageService.deleteChannelMessageById(id);
        return "Channel Message " + id + " has been deleted.";
    }
}
