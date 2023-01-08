package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.ThreadDirectMessage;
import rocks.zipcode.Jive.services.ThreadDirectMessageService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/dmthreads")
public class ThreadDirectMessageController {
    @Autowired
    ThreadDirectMessageService threadDirectMessageService;

    @PostMapping("/add")
    public String addDirectMessage(@RequestBody ThreadDirectMessage threadDirectMessage) {
        threadDirectMessageService.saveThreadDirectMessage(threadDirectMessage);
        return "Thread has been saved";
    }

    @GetMapping("/all")
    public List<ThreadDirectMessage> getAllThreadDirectMessages(){
        return threadDirectMessageService.getAllThreadDirectMessage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThreadDirectMessage> getThreadDirectMessageById(@PathVariable Long id){
        try{
            ThreadDirectMessage threadDirectMessage = threadDirectMessageService.getThreadDirectMessageById(id);
            return new ResponseEntity<ThreadDirectMessage>(threadDirectMessage, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ThreadDirectMessage>(HttpStatus.NOT_FOUND);
        }
    }

    // Why isn't ID in the top? TODO test in postman
    @PutMapping("/{id}")
    public ResponseEntity<ThreadDirectMessage> updateThreadDirectMessage(@RequestBody ThreadDirectMessage threadDirectMessage, @PathVariable Long id){
        try {
            threadDirectMessageService.saveThreadDirectMessage(threadDirectMessage);
            return new ResponseEntity<ThreadDirectMessage>(threadDirectMessage, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ThreadDirectMessage>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteThreadDirectMessage(@PathVariable Long id) {
        threadDirectMessageService.deleteThreadDirectMessageById(id);
        return "Thread " + id + " has been deleted.";
    }
}
