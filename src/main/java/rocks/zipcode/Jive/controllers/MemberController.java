package rocks.zipcode.Jive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.Jive.entities.Member;
import rocks.zipcode.Jive.services.MemberService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/add")
    public String addMember (@RequestBody Member member){
        memberService.saveMember(member);
        return "member has been added";
    }

    @GetMapping("/all")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Member> getMemberByID(@PathVariable Long idUser){
        try {
            Member member = memberService.getMemberByID(idUser);
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<Member>( HttpStatus.NOT_FOUND);
        }
     }

     @PutMapping("/{idUser}")
     public ResponseEntity<Member> update(@RequestBody Member member, @PathVariable Long idUser){
        try {
            memberService.saveMember(member);
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
         }
     }



     @DeleteMapping("/{idUser}")
     public String delete(@PathVariable Long idUser) {
        memberService.deleteMemberByID(idUser);
        return "Member " + idUser + "has been deleted";
     }
}
