package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.Membership;
import rocks.zipcode.Jive.services.MemberService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    // @PostMapping("/add")
    // public String addMember(@RequestBody Member member) {
    // memberService.saveMember(member);
    // return "member has been added";
    // }

    @GetMapping("/all")
    public List<Membership> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Membership> getMemberByID(@PathVariable Long idUser) {
        try {
            Membership member = memberService.getMemberByID(idUser);
            return new ResponseEntity<Membership>(member, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Membership>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<Membership> update(@RequestBody Membership member, @PathVariable Long idUser) {
        try {
            memberService.update(idUser, member);
            return new ResponseEntity<Membership>(member, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Membership>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUser}")
    public String delete(@PathVariable Long idUser) {
        memberService.deleteMemberByID(idUser);
        return "Member " + idUser + "has been deleted";
    }

    // //Todo changed this

    // @PutMapping("/{memberId}/users/{userId}")
    // // @PutMapping("/add/users/{userId}") //post mapping instead?

    // public String assignUserToMembership(@PathVariable Long memberId,
    // @PathVariable Long userId) {
    // memberService.assignUserToMembership(memberId, userId);
    // return "User has been saved to member service";
    // }

    @PostMapping("/add/users/{userId}")
    public String addMembershipWithUser(@RequestBody Membership member, @PathVariable Long userId) { // do not need
        // member
        memberService.assignUserToMembership(member, userId);
        return "User has been saved to member repository";
    }

    @PostMapping("/add/users/{userId}/channels/{channelId}")
    public String assignChannelToMembership(@RequestBody Membership member, @PathVariable Long channelId, // do not need
                                            // member
                                            @PathVariable Long userId) {
        memberService.assignChannelToMembership(member, channelId, userId);
        return "channel has been saved to member repository";
    }

    @GetMapping("/all/channel/{channelId}")
    public List<Membership> getChannelById(@PathVariable Long channelId) {
        return memberService.getChannelById(channelId);
    }
}
