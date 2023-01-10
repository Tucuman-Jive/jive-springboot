package rocks.zipcode.Jive.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.services.ChannelService;

// @RestController
// class ChannelController {
//     //...
// }
public class ChannelControllerTest {







    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    private ChannelService channelService;
    @InjectMocks
    private ChannelController channelController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(channelController).build();
    }

    @Test
    public void testAddChannel() throws Exception {
        Channel channel = new Channel();
        channel.setName("Test channel");
        doNothing().when(channelService).saveChannel(any(Channel.class));
        String json = objectMapper.writeValueAsString(channel);

        mockMvc.perform(post("/channels/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllChannels() throws Exception {
        List<Channel> channels = Arrays.asList(new Channel(), new Channel());
        when(channelService.getAllChannels()).thenReturn(channels);

        mockMvc.perform(get("/channels/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetChannelById() throws Exception {
        Channel channel = new Channel();
        channel.setName("Test channel");
        when(channelService.getChannelById(1L)).thenReturn(channel);

        mockMvc.perform(get("/channels/1"))
                .andExpect(status().isOk());

        when(channelService.getChannelById(2L)).thenThrow(new NoSuchElementException());

        mockMvc.perform(get("/channels/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdate() throws Exception {
        Channel originalChannel = new Channel();
        originalChannel.setId(1L);
        originalChannel.setName("Test channel");
        when(channelService.update(eq(1L), any(Channel.class))).thenReturn(originalChannel);

        Channel updateRequest = new Channel();
        updateRequest.setName("Updated channel");
        String json = objectMapper.writeValueAsString(updateRequest);

        mockMvc.perform(put("/channels/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        when(channelService.update(eq(2L), any(Channel.class))).thenThrow(new NoSuchElementException());

        mockMvc.perform(put("/channels/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNotFound());
    }


    @Test
    public void testDelete() throws Exception {
            doNothing().when(channelService).deleteChannelById(1L);

            mockMvc.perform(delete("/channels/1"))
                    .andExpect(status().isOk());
        }
    }
