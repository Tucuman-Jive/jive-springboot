//package rocks.zipcode.Jive.repositories;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import rocks.zipcode.Jive.entities.Channel;
//@SpringBootTest
//public class ChannelRepositoryTest {
//
//
//
//        @InjectMocks
//        private ChannelRepository channelRepository;
//
//        @Mock
//        private JpaRepository<Channel, Long> jpaRepository;
//
//        private Channel channel1;
//        private Channel channel2;
//        private List<Channel> channels;
//
//        @BeforeEach
//        public void init() {
//            MockitoAnnotations.initMocks(this);
//            channel1 = new Channel();
//            channel1.setId(1L);
//            channel1.setName("Test channel1");
//            channel2 = new Channel();
//            channel2.setId(2L);
//            channel2.setName("Test channel2");
//            channels = new ArrayList<>();
//            channels.add(channel1);
//            channels.add(channel2);
//        }
//
//        @Test
//        public void testFindAll() {
//            when(jpaRepository.findAll()).thenReturn(channels);
//            List<Channel> result = channelRepository.findAll();
//            assertNotNull(result);
//            assertEquals(2, result.size());
//            assertEquals("Test channel1", result.get(0).getName());
//            assertEquals("Test channel2", result.get(1).getName());
//        }
//    }
//
