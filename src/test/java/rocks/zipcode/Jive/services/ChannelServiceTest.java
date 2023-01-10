package rocks.zipcode.Jive.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.repositories.ChannelRepository;
import rocks.zipcode.Jive.repositories.MemberRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ChannelServiceTest {




        @Mock
        private ChannelRepository channelRepository;

        @Mock
        private MemberRepository memberRepository;

        private ChannelService channelService;

        private final Channel channel1 = new Channel(); //1L, "channel1", "description1"
        private final Channel channel2 = new Channel(); //2L, "channel2", "description2"
        private final Channel newChannelData = new Channel(); //3L, "channel3", "description3"

        @Before
        public void setUp() {
            channelService = new ChannelService(channelRepository);
        }

        @Test
        public void getAllChannels_shouldReturnAllChannels() {
            List<Channel> expectedChannels = Arrays.asList(channel1, channel2);
            when(channelRepository.findAll()).thenReturn(expectedChannels);

            List<Channel> result = channelService.getAllChannels();

            verify(channelRepository, times(1)).findAll();
            assertThat(result).isEqualTo(expectedChannels);
        }

        @Test
        public void getChannelById_shouldReturnChannel() {
            when(channelRepository.findById(1L)).thenReturn(Optional.of(channel1));

            Channel result = channelService.getChannelById(1L);

            verify(channelRepository, times(1)).findById(1L);
            assertThat(result).isEqualTo(channel1);
        }

        @Test
        public void saveChannel_shouldSaveChannel() {
            when(channelRepository.save(channel1)).thenReturn(channel1);

            channelService.saveChannel(channel1);

            verify(channelRepository, times(1)).save(channel1);
        }

        @Test
        public void deleteChannelById_shouldDeleteChannel() {
            channelService.deleteChannelById(1L);

            verify(channelRepository, times(1)).deleteById(1L);
        }

    @Test
    public void update_shouldUpdateChannel() {
        when(channelRepository.findById(1L)).thenReturn(Optional.of(channel1));
        when(channelRepository.save(channel1)).thenReturn(channel1);

        Channel result = channelService.update(1L, newChannelData);

        assertThat(result).isEqualTo(channel1);
        assertThat(result.getName()).isEqualTo(newChannelData.getName());
        assertThat(result.getDescription()).isEqualTo(newChannelData.getDescription());
        assertThat(result.getId()).isEqualTo(newChannelData.getId());
        assertThat(result.getCreatedAt()).isEqualTo(newChannelData.getCreatedAt());
        assertThat(result.getUpdatedAt()).isEqualTo(newChannelData.getUpdatedAt());
        verify(channelRepository, times(1)).findById(1L);
        verify(channelRepository, times(1)).save(channel1);
    }
}