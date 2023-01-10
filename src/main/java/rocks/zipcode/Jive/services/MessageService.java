package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.Message;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.repositories.MessageRepository;
import rocks.zipcode.Jive.repositories.ChannelRepository;
import rocks.zipcode.Jive.repositories.UserRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChannelRepository channelRepository;


    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long idMessage) {
        return messageRepository.findById(idMessage).get();
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessageById(Long idMessage) {
        messageRepository.deleteById(idMessage);
    }

    public Message update(Long id, Message newMessageData) {
        Message originalMessage = messageRepository.findById(id).get();
        originalMessage.setId(newMessageData.getId());
        originalMessage.setChannel(newMessageData.getChannel());
        originalMessage.setMessage(newMessageData.getMessage());
        return messageRepository.save(originalMessage);
    }

    public Message addMessageByChannelAndUser(Message message, Long channelId, Long userId) {
        Channel channel = channelRepository.findById(channelId).get();
        UserEntity userEntity = userRepository.findById(userId).get();
        message.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        message.setUserEntity(userEntity);
        message.setChannel(channel);
        return messageRepository.save(message);
    }

    public List<Message> findByChannelId(Long channelId) {
        return messageRepository.findByChannelId(channelId);
    }
}
