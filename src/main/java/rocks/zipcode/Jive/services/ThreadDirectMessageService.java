package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.DirectMessage;
import rocks.zipcode.Jive.entities.ThreadDirectMessage;
import rocks.zipcode.Jive.repositories.DirectMessageRepository;
import rocks.zipcode.Jive.repositories.ThreadDirectMessageRepository;

import java.util.List;

@Service
public class ThreadDirectMessageService {
    @Autowired
    ThreadDirectMessageRepository threadDirectMessageRepository;

    public ThreadDirectMessageService(ThreadDirectMessageRepository threadDirectMessageRepository) {
        this.threadDirectMessageRepository = threadDirectMessageRepository;
    }

    public void saveThreadDirectMessage(ThreadDirectMessage threadDirectMessage){
        threadDirectMessageRepository.save(threadDirectMessage);
    }

    public List<ThreadDirectMessage> getAllThreadDirectMessage(){
        return threadDirectMessageRepository.findAll();
    }

    public ThreadDirectMessage getThreadDirectMessageById(Long id){
        return threadDirectMessageRepository.findById(id).get();
    }

    public void deleteThreadDirectMessageById(Long id){
        threadDirectMessageRepository.deleteById(id);
    }
}
