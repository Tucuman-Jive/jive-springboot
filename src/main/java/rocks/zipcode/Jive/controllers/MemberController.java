package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.Membership;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.services.MemberService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;


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



    @PostMapping("/add/users/{userId}")
    public String addMembershipWithUser(@RequestBody Membership member, @PathVariable Long userId) { // do not need
        // member
        memberService.assignUserToMembership(member, userId);
        return "User has been saved to member repository";
    }

    @PostMapping("/add/users/{userId}/channels/{channelId}") //TODO do we want to remove @Requestbody?
    public String assignChannelToMembership(@RequestBody Membership member, @PathVariable Long channelId, // do not need
            // member
            @PathVariable Long userId) {
        memberService.assignChannelToMembership(member, channelId, userId);
        return "channel has been saved to member repository";
    }

    @PostMapping("/add/users/{userId}/channelName/{channelName}") //TODO do we want to remove @Requestbody?
    public String assignChannelToMembershipByChannelName(@RequestBody Membership member, @PathVariable String channelName, // do not need
                                            // member
                                            @PathVariable Long userId) {
        memberService.assignChannelToMembershipByName(member, channelName, userId);
        return "channel has been saved to member repository";
    }

    @GetMapping("/all/channel/{channelId}")
    public List<Membership> getChannelById(@PathVariable Long channelId) {
        return memberService.getChannelById(channelId);
    }

    @GetMapping("/all/notchannel/{channelId}")
    public List<UserEntity> getMembersNotInChannelByChannelId(@PathVariable Long channelId) {
        return memberService.getMembersNotInChannelByChannelId(channelId);
    }

    @GetMapping("/all/channelName/{channelName}")
    public List<Membership> getChannelByName(@PathVariable String channelName) {
        return memberService.getChannelByName(channelName);
    }


    @GetMapping("/all/user/{userId}")
    public List<Membership> getUserById(@PathVariable Long userId) {
        return memberService.getUserById(userId);
    }

    @GetMapping("/dms/user/{userId}")
    public List<Membership> getDMsByUserById(@PathVariable Long userId) {
        return memberService.getDMsByUserId(userId);
    }

    @GetMapping("/channels/user/{userId}")
    public List<Membership> getChannelsByUserById(@PathVariable Long userId) {
        return memberService.getChannelsByUserId(userId);
    }

}
