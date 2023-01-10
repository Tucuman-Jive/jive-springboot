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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {




        @Mock
        private MemberService memberService;

        @InjectMocks
        private MemberController memberController;

        @Test
        void testGetAllMembers() {
            List<Membership> members = new ArrayList<>();
            members.add(new Membership());
            when(memberService.getAllMembers()).thenReturn(members);
            List<Membership> result = memberController.getAllMembers();
            assertEquals(members, result);
        }

    @Test
    void testGetMemberByIDSuccess() {
        Membership member = new Membership();
        when(memberService.getMemberByID(anyLong())).thenReturn(member);
        ResponseEntity<Membership> result = memberController.getMemberByID(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(member, result.getBody());
    }

    @Test
    void testGetMemberByIDNotFound() {
        when(memberService.getMemberByID(anyLong())).thenThrow(NoSuchElementException.class);
        ResponseEntity<Membership> result = memberController.getMemberByID(1L);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(null, result.getBody());
    }

//    @Test
//    void testUpdateSuccess() {
//        Membership member = new Membership();
//        when(memberService.getMemberByID(anyLong())).thenReturn(member);
//        ResponseEntity<Membership> result = memberController.update(member, 1L);
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertEquals(member, result.getBody());
//        verify(memberService).update(anyLong(), any());
//    }
//
//    @Test
//    void testUpdateNotFound() {
//        when(memberService.getMemberByID(anyLong())).thenThrow(NoSuchElementException.class);
//        ResponseEntity<Membership> result = memberController.update(new Membership(), 1L);
//        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
//        assertEquals(null, result.getBody());
//    }

    @Test
    void testDelete() {
        memberController.delete(1L);
        verify(memberService).deleteMemberByID(1L);
    }

    private MemberService verify(MemberService memberService) {
            return memberService;
    }

//    @Test
//    void testAddMembershipWithUser() {
//        Member member = new Member();
//        memberController.addMembershipWithUser(member, 1L);
//        verify(memberService, 1).assignUserToMembership(member, 1L);
//    }

    @Test
    void testAssignChannelToMembership() {
        Membership member = new Membership();
        memberController.assignChannelToMembership(member, 1L, 2L);
        verify(memberService).assignChannelToMembership(member, 1L, 2L);
    }
}
