//package rocks.zipcode.Jive.services;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import rocks.zipcode.Jive.entities.Channel;
//import rocks.zipcode.Jive.entities.Membership;
//import rocks.zipcode.Jive.entities.UserEntity;
//import rocks.zipcode.Jive.repositories.ChannelRepository;
//import rocks.zipcode.Jive.repositories.MemberRepository;
//import rocks.zipcode.Jive.repositories.UserRepository;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//
//class MemberServiceTest {
//
//
//
//    @Mock
//    private MemberRepository memberRepository;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private ChannelRepository channelRepository;
//
//    private MemberService memberService;
//
//    private final Membership member1 = new Membership(1L, new UserEntity(), new Channel());
//    private final Membership member2 = new Membership(2L, new UserEntity(), new Channel());
//    private final Membership newMemberData = new Membership(3L, new UserEntity(), new Channel());
//    private final UserEntity userEntity = new UserEntity(1L, "User1", "password1");
//    private final Channel channel = new Channel(1L, "channel1", "description1");
//
//    @Before
//    public void setUp() {
//        memberService = new MemberService(memberRepository);
//    }
//
//    @Test
//    public void getAllMembers_shouldReturnAllMembers() {
//        List<Membership> expectedMembers = Arrays.asList(member1, member2);
//        when(memberRepository.findAll()).thenReturn(expectedMembers);
//
//        List<Membership> result = memberService.getAllMembers();
//
//        verify(memberRepository, times(1)).findAll();
//        assertThat(result).isEqualTo(expectedMembers);
//    }
//
//    @Test
//    public void getMemberByID_shouldReturnMember() {
//        when(memberRepository.findById(1L)).thenReturn(Optional.of(member1));
//
//        Membership result = memberService.getMemberByID(1L);
//
//        verify(memberRepository, times(1)).findById(1L);
//        assertThat(result).isEqualTo(member1);
//    }
//
//    @Test
//    public void saveMember_shouldSaveMember() {
//        when(memberRepository.save(member1)).thenReturn(member1);
//
//        memberService.saveMember(member1);
//
//        verify(memberRepository, times(1)).save(member1);
//    }
//
//    @Test
//    public void deleteMemberByID_shouldDeleteMember() {
//        memberService.deleteMemberByID(1L);
//
//        verify(memberRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void update_shouldUpdateMember() {
//        when(memberRepository.findById(1L)).thenReturn(Optional.of(member1));
//        when(memberRepository.save(member1)).thenReturn(member1);
//
//        Membership result = memberService.update(1L, newMemberData);
//
//        assertThat(result).isEqualTo(member1);
//        assertThat(result.getChannel()).isEqualTo(newMemberData.getChannel());
//        verify(memberRepository, times(1)).findById(1L);
//        verify(memberRepository, times(1)).save(member1);
//    }
//
//    @Test
//    public void assignUserToMembership_shouldAssignUserToMembership() {
//        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
//        when(memberRepository.save(member1)).thenReturn(member1);
//
//        Membership result = memberService.assignUserToMembership(member1, 1L);
//
//        assertThat(result).isEqualTo(member1);
//        assertThat(result.getUserEntity()).isEqualTo(userEntity);
//        verify(userRepository, times(1)).findById(1L);
//        verify(memberRepository, times(1)).save(member1);
//    }
//
//    @Test
//    public void assignChannelToMembership_shouldAssignChannelToMembership() {
//        when(channelRepository.findById(1L)).thenReturn(Optional.of(channel));
//        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
//        when(memberRepository.save(member1)).thenReturn(member1);
//
//        Membership result = memberService.assignChannelToMembership(member1, 1L, 1L);
//
//        assertThat(result).isEqualTo(member1);
//        assertThat(result.getUserEntity()).isEqualTo(userEntity);
//        assertThat(result.getChannel()).isEqualTo(channel);
//        verify(channelRepository, times(1)).findById(1L);
//        verify(userRepository, times(1)).findById(1L);
//        verify(memberRepository, times(1)).save(member1);
//    }
//}
