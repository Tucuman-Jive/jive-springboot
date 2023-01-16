package rocks.zipcode.Jive.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rocks.zipcode.Jive.entities.Membership;
import rocks.zipcode.Jive.services.MemberService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    @Test
    public void testGetAllMembers() {
        //Arrange
        Membership membership1 = new Membership();
        Membership membership2 = new Membership();
        List<Membership> expectedMembers = Arrays.asList(membership1, membership2);
        when(memberService.getAllMembers()).thenReturn(expectedMembers);

        //Act
        List<Membership> actualMembers = memberController.getAllMembers();

        //Assert
        assertEquals(expectedMembers, actualMembers);
    }

    @Test
    public void testGetMemberByID() {
        //Arrange
        Long id = 1L;
        Membership expectedMember = new Membership();
        when(memberService.getMemberByID(id)).thenReturn(expectedMember);

        //Act
        ResponseEntity<Membership> actualResponse = memberController.getMemberByID(id);

        //Assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedMember, actualResponse.getBody());
    }

    @Test
    public void testGetMemberByIDNotFound() {
        //Arrange
        Long id = 1L;
        when(memberService.getMemberByID(id)).thenThrow(NoSuchElementException.class);

        //Act
        ResponseEntity<Membership> actualResponse = memberController.getMemberByID(id);

        //Assert
        assertEquals(HttpStatus.NOT_FOUND, actualResponse.getStatusCode());
    }

    @Test
    public void testUpdate() {
        //Arrange
        Long id = 1L;
        Membership expectedMember = new Membership();
        when(memberService.update(id, expectedMember)).thenReturn(expectedMember);

        //Act
        ResponseEntity<Membership> actualResponse = memberController.update(expectedMember, id);

        //Assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedMember, actualResponse.getBody());
    }

    @Test
    public void testUpdateNotFound() {
        //Arrange
        Long id = 1L;
        Membership expectedMember = new Membership();
        when(memberService.update(id, expectedMember)).thenThrow(NoSuchElementException.class);
        //Act
        ResponseEntity<Membership> actualResponse = memberController.update(expectedMember, id);

        //Assert
        assertEquals(HttpStatus.NOT_FOUND, actualResponse.getStatusCode());
    }

    @Test
    public void testDelete() {
        //Arrange
        Long id = 1L;

        //Act
        String actualResponse = memberController.delete(id);

        //Assert
        assertEquals("Member " + id + "has been deleted", actualResponse);
        verify(memberService, times(1)).deleteMemberByID(id);
    }

    @Test
    public void testAddMembershipWithUser() {
        //Arrange
        Long userId = 1L;
        Membership expectedMember = new Membership();

        //Act
        String actualResponse = memberController.addMembershipWithUser(expectedMember, userId);

        //Assert
        assertEquals("User has been saved to member repository", actualResponse);
        verify(memberService, times(1)).assignUserToMembership(expectedMember, userId);
    }

    @Test
    public void testAssignChannelToMembership() {
        //Arrange
        Long userId = 1L;
        Long channelId = 1L;
        Membership expectedMember = new Membership();

        //Act
        String actualResponse = memberController.assignChannelToMembership(expectedMember, channelId, userId);

        //Assert
        assertEquals("channel has been saved to member repository", actualResponse);
        verify(memberService, times(1)).assignChannelToMembership(expectedMember, channelId, userId);
    }

    @Test
    public void testAssignChannelToMembershipByChannelName() {
        //Arrange
        Long userId = 1L;
        String channelName = "channel1";
        Membership expectedMember = new Membership();

        //Act
        String actualResponse = memberController.assignChannelToMembershipByChannelName(expectedMember, channelName, userId);

        //Assert
        assertEquals("channel has been saved to member repository", actualResponse);
        verify(memberService, times(1)).assignChannelToMembershipByName(expectedMember, channelName, userId);
    }

    @Test
    public void testGetChannelById() {
        //Arrange
        Long channelId = 1L;
        Membership membership1 = new Membership();
        Membership membership2 = new Membership();
        List<Membership> expectedMembers = Arrays.asList(membership1, membership2);
        when(memberService.getChannelById(channelId)).thenReturn(expectedMembers);

        //Act
        List<Membership> actualMembers = memberController.getChannelById(channelId);

        //Assert
        assertEquals(expectedMembers, actualMembers);
    }

    @Test
    public void testGetChannelByName() {
        //Arrange
        String channelName = "channel1";
        Membership membership1 = new Membership();
        Membership membership2 = new Membership();
        List<Membership> expectedMembers = Arrays.asList(membership1, membership2);
        when(memberService.getChannelByName(channelName)).thenReturn(expectedMembers);
        //Act
        List<Membership> actualMembers = memberController.getChannelByName(channelName);

        //Assert
        assertEquals(expectedMembers, actualMembers);
    }

    @Test
    public void testGetUserById() {
        //Arrange
        Long userId = 1L;
        Membership membership1 = new Membership();
        Membership membership2 = new Membership();
        List<Membership> expectedMembers = Arrays.asList(membership1, membership2);
        when(memberService.getUserById(userId)).thenReturn(expectedMembers);

        //Act
        List<Membership> actualMembers = memberController.getUserById(userId);

        //Assert
        assertEquals(expectedMembers, actualMembers);
    }

//    @Test
//    public void testGetDMsByUserById() {
//        //Arrange
//        Long userId = 1L;
//        Membership membership1 = new Membership();
//        Membership membership2 = new Membership();
//        List<Membership> expectedMembers = Arrays.asList(membership1, membership2);
//        when(memberService.getDMsByUserById(userId)).thenReturn(expectedMembers);
//
//        //Act
//        List<Membership> actualMembers = memberController.getDMsByUserById(userId);
//
//        //Assert
//        assertEquals(expectedMembers, actualMembers);
//    }

}


