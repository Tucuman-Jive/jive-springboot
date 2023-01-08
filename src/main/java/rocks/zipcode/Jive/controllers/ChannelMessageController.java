package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.ChannelMessage;
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
    public String addChannelMessage(@RequestBody ChannelMessage channelMessage) {
        channelMessageService.saveChannelMessage(channelMessage);
        return "Channel message has been saved";
    }

    @GetMapping("/all")
    public List<ChannelMessage> getAllChannelMessages() {
        return channelMessageService.getAllChannelMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChannelMessage> getChannelMessageById(@PathVariable Long id) {
        try {
            ChannelMessage channelMessage = channelMessageService.getChannelMessageById(id);
            return new ResponseEntity<>(channelMessage, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChannelMessage> update(@RequestBody ChannelMessage channelMessage, @PathVariable Long id) {
        try {
            channelMessageService.saveChannelMessage(channelMessage); // why no id?
            return new ResponseEntity<ChannelMessage>(channelMessage, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ChannelMessage>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        channelMessageService.deleteChannelMessageById(id);
        return "Channel Message " + id + " has been deleted.";
    }
}
