package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Channel;
import rocks.zipcode.Jive.entities.Membership;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.repositories.ChannelRepository;
import rocks.zipcode.Jive.repositories.MemberRepository;
import rocks.zipcode.Jive.repositories.UserRepository;

import java.util.ArrayList;
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

    public Membership assignChannelToMembershipByName(Membership member, String channelName, Long userId) { // assign
                                                                                                            // new
        // membership
        Channel channel = channelRepository.findByName(channelName);
        UserEntity userEntity = userRepository.findById(userId).get();
        member.setUserEntity(userEntity);
        member.setChannel(channel);
        return memberRepository.save(member);
    }

    public List<Membership> getChannelById(Long channelId) {
        return memberRepository.findByChannelId(channelId);
    }

    public List<Membership> getChannelByName(String channelName) {
        return memberRepository.findByChannelName(channelName);
    }

    public List<Membership> getUserById(Long userId) {
        return memberRepository.getByUserEntityId(userId);
    }

    public List<Membership> getDMsByUserId(Long userId) {

        List<Membership> membershipList = memberRepository.getByUserEntityId(userId);
        List<Membership> dmList = new ArrayList<>();

        for (Membership membership : membershipList) {

            Long id = membership.getChannel().getId();
            Channel channel = channelRepository.findById(id).get();
            List<Membership> countList = memberRepository.findByChannelId(channel.getId());

            int count = countList.size();

            if (count == 2) {
                dmList.add(membership);
            }
        }
        return dmList;
    }

    public List<Membership> getChannelsByUserId(Long userId) {

        List<Membership> membershipList = memberRepository.getByUserEntityId(userId);
        List<Membership> channelList = new ArrayList<>();

        for (Membership membership : membershipList) {

            Long id = membership.getChannel().getId();
            Channel channel = channelRepository.findById(id).get();
            List<Membership> countList = memberRepository.findByChannelId(channel.getId());

            int count = countList.size();

            if (count != 2) {
                channelList.add(membership);
            }
        }
        return channelList;
    }

    public List<Membership> getMembersNotInChannelByChannelId(Long channelId) {
        List<Membership> allMembers = memberRepository.findAll();
        List<Membership> channelMembers = memberRepository.findByChannelId(channelId);
        List<Membership> membersNotInChannel = new ArrayList<>();
        for(Membership membership : allMembers){
            if (!channelMembers.contains(membership)){
                membersNotInChannel.add(membership);
            }
        }
        return membersNotInChannel;
    }
}
