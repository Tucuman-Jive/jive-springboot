package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.DirectMessage;
import rocks.zipcode.Jive.repositories.DirectMessageRepository;

import java.util.List;

@Service
public class DirectMessageService {

    @Autowired
    DirectMessageRepository directMessageRepository;

    public DirectMessageService(DirectMessageRepository directMessageRepository) {
        this.directMessageRepository = directMessageRepository;
    }

    public void saveDirectMessage(DirectMessage directMessage){
        directMessageRepository.save(directMessage);
    }

    public List<DirectMessage> getAllDirectMessage(){
        return directMessageRepository.findAll();
    }

    public DirectMessage getDirectMessageById(Long id){
        return directMessageRepository.findById(id).get();
    }

    public void deleteDirectMessageById(Long id){
        directMessageRepository.deleteById(id);
    }

    public DirectMessage update(Long id, DirectMessage newDirectMessage){
        DirectMessage originalDirectMessage = directMessageRepository.findById(id).get();
        originalDirectMessage.setIdDirectMessage(newDirectMessage.getIdDirectMessage());
        originalDirectMessage.setIdThreadDirectMessage(newDirectMessage.getIdThreadDirectMessage());
        originalDirectMessage.setIdUser(newDirectMessage.getIdUser());
        originalDirectMessage.setToUserID(newDirectMessage.getToUserID());
        originalDirectMessage.setMessage(newDirectMessage.getMessage());
        originalDirectMessage.setCreatedAt(newDirectMessage.getCreatedAt());
        return directMessageRepository.save(originalDirectMessage);
    }
}
