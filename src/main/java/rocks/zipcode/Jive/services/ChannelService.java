package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.repositories.ChannelRepository;

import java.util.List;

@Service
public class ChannelService{

    @Autowired
    ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Channel getChannelById(Long idChannel){
        return channelRepository.findById(idChannel).get();
    }

    public void saveChannel(Channel channel) {
        channelRepository.save(channel);
    }

    public void deleteChannelById(Long idChannel) {
        channelRepository.deleteById(idChannel);
    }

    public Channel update(Long id, Channel newChannelData){
        Channel originalChannel = channelRepository.findById(id).get();
        originalChannel.setName(newChannelData.getName());
        originalChannel.setDescription(newChannelData.getDescription());
        originalChannel.setId(newChannelData.getId());
        originalChannel.setCreatedAt(newChannelData.getCreatedAt());
        originalChannel.setUpdatedAt(newChannelData.getUpdatedAt());
        return channelRepository.save(originalChannel);
    }

}
