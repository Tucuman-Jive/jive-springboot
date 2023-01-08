package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.repositories.ChannelRepository;
import rocks.zipcode.Jive.services.ChannelService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/channels")

public class ChannelController {
    @Autowired
    private ChannelService channelService;



    @PostMapping("/add")
    public String addChannel(@RequestBody Channel channel){
        channelService.saveChannel(channel);
        return "Channel has been saved";
    }

    @GetMapping("/all")
    public List<Channel> getAllChannels(){
        return channelService.getAllChannels();
    }

    @GetMapping("/{idChannel}")
    public ResponseEntity<Channel> getChannelById(@PathVariable Long idChannel) {
        try {
            Channel channel = channelService.getChannelById(idChannel);
            return new ResponseEntity<Channel>(channel, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Channel>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idChannel}")
    public ResponseEntity<Channel> update(@RequestBody Channel channel, @PathVariable Long idChannel) {
        try {
            channelService.saveChannel(channel);
            return new ResponseEntity<Channel>(channel, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Channel>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idChannel}")
    public String delete(@PathVariable Long idChannel) {
        channelService.deleteChannelById(idChannel);
        return "Channel " + idChannel + " Has been deleted";
    }
}
