package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.ChannelMessage;
import rocks.zipcode.Jive.repositories.ChannelMessageRepository;

import java.util.List;

@Service
public class ChannelMessageService {

    @Autowired
    ChannelMessageRepository channelMessageRepository;


    public ChannelMessageService(ChannelMessageRepository channelMessageRepository) {
        this.channelMessageRepository = channelMessageRepository;
    }

    public List<ChannelMessage> getAllChannelMessages() {
        return channelMessageRepository.findAll();
    }

    public ChannelMessage getChannelMessageById(Long idChannelMessage) {
        return channelMessageRepository.findById(idChannelMessage).get();
    }

    public void saveChannelMessage(ChannelMessage channelMessage) {
        channelMessageRepository.save(channelMessage);
    }

    public void deleteChannelMessageById(Long idChannelMessage) {
        channelMessageRepository.deleteById(idChannelMessage);
    }


}
