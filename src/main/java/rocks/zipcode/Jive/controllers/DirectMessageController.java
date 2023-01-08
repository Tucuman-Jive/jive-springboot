package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.DirectMessage;
import rocks.zipcode.Jive.services.DirectMessageService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/dms")
public class DirectMessageController {
    @Autowired
    DirectMessageService directMessageService;

    @PostMapping("/add")
    public String addDirectMessage(@RequestBody DirectMessage directMessage) {
        directMessageService.saveDirectMessage(directMessage);
        return "Direct message has been saved";
    }

    @GetMapping("/all")
    public List<DirectMessage> getAllDirectMessages(){
        return directMessageService.getAllDirectMessage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectMessage> getDirectMessageById(@PathVariable Long id){
        try{
            DirectMessage directMessage = directMessageService.getDirectMessageById(id);
            return new ResponseEntity<DirectMessage>(directMessage, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DirectMessage>(HttpStatus.NOT_FOUND);
        }
    }

    // Why isn't ID in the top? TODO test in postman
    @PutMapping("/{id}")
    public ResponseEntity<DirectMessage> updateDirectMessage(@RequestBody DirectMessage directMessage, @PathVariable Long id){
        try {
            directMessageService.saveDirectMessage(directMessage);
            return new ResponseEntity<DirectMessage>(directMessage, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DirectMessage>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDirectMessage(@PathVariable Long id) {
        directMessageService.deleteDirectMessageById(id);
        return "Direct Message " + id + " has been deleted.";
    }
}
