package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.Membership;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.repositories.ChannelRepository;
import rocks.zipcode.Jive.repositories.MemberRepository;
import rocks.zipcode.Jive.repositories.UserRepository;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChannelRepository channelRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Membership> getAllMembers() {
        return memberRepository.findAll();
    }

    public Membership getMemberByID(Long id) {
        return memberRepository.findById(id).get();

    }

    public void saveMember(Membership member) {
        memberRepository.save(member);
    }

    public void deleteMemberByID(Long id) {
        memberRepository.deleteById(id);
    }

    public Membership update(Long id, Membership newMemberData) {
        Membership originalMember = memberRepository.findById(id).get();
        originalMember.setChannel(newMemberData.getChannel());
        originalMember.setUserEntity(newMemberData.getUserEntity());
        // originalMember.setIdUser(newMemberData.getIdUser());
        // originalMember.setCreatedAt(newMemberData.getCreatedAt());
        // originalMember.setUpdatedAt(newMemberData.getUpdatedAt());
        return memberRepository.save(originalMember);
    }

    // Todo changed this

    // public Member assignUserToMembership(Long memberId, Long userId) { // assign
    // new membership
    // Member member = memberRepository.findById(memberId).get();
    // UserEntity userEntity = userRepository.findById(userId).get();
    // member.setUserEntity(userEntity);
    // return memberRepository.save(member);
    // }
    // user 1
    // membership 1
    // channel id: 1
    // user: 1

    // user 2
    // membership 2
    // channel id: 1
    // user: 2

    // membership 3
    // channel id: 2
    // user: 2

    public Membership assignUserToMembership(Membership member, Long userId) { // assign new membership
        UserEntity userEntity = userRepository.findById(userId).get();
        member.setUserEntity(userEntity);
        return memberRepository.save(member);
    }

    public Membership assignChannelToMembership(Membership member, Long channelId, Long userId) { // assign new
        // membership
        Channel channel = channelRepository.findById(channelId).get();
        UserEntity userEntity = userRepository.findById(userId).get();
        member.setUserEntity(userEntity);
        member.setChannel(channel);
        return memberRepository.save(member);
    }

    public List<Membership> getChannelById(Long channelId) {
        return memberRepository.findByChannelId(channelId);
    }

    public List<Membership> getUserById(Long userId) {
        return memberRepository.getByUserEntityId(userId);
    }
}
