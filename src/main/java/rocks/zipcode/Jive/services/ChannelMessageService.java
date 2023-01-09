package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Message;
import rocks.zipcode.Jive.repositories.ChannelMessageRepository;

import java.util.List;

@Service
public class ChannelMessageService {

    @Autowired
    ChannelMessageRepository channelMessageRepository;


    public ChannelMessageService(ChannelMessageRepository channelMessageRepository) {
        this.channelMessageRepository = channelMessageRepository;
    }

    public List<Message> getAllChannelMessages() {
        return channelMessageRepository.findAll();
    }

    public Message getChannelMessageById(Long idChannelMessage) {
        return channelMessageRepository.findById(idChannelMessage).get();
    }

    public void saveChannelMessage(Message message) {
        channelMessageRepository.save(message);
    }

    public void deleteChannelMessageById(Long idChannelMessage) {
        channelMessageRepository.deleteById(idChannelMessage);
    }

    public Message update(Long id, Message newMessageData){
        Message originalMessage = channelMessageRepository.findById(id).get();
        originalMessage.setId(newMessageData.getId());
        originalMessage.setIdUser(newMessageData.getIdUser());
        originalMessage.setIdChannel(newMessageData.getIdChannel());
        originalMessage.setMessage(newMessageData.getMessage());
        return channelMessageRepository.save(originalMessage);
    }
}
