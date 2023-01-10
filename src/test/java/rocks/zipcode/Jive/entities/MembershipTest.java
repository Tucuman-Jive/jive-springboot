package rocks.zipcode.Jive.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MembershipTest {
    @Test
    public void testSetId() {
        Membership membership = new Membership();
        Long id = 1L;
        membership.setId(id);
        assertEquals(id, membership.getId());
    }

    @Test
    public void testSetAndGetChannel() {
        Membership membership = new Membership();
        Channel channel = new Channel();
        membership.setChannel(channel);
        assertNotNull(membership.getChannel());
        assertEquals(channel, membership.getChannel());
    }

    @Test
    public void testSetAndGetUserEntity() {
        Membership membership = new Membership();
        UserEntity userEntity = new UserEntity();
        membership.setUserEntity(userEntity);
        assertNotNull(membership.getUserEntity());
        assertEquals(userEntity, membership.getUserEntity());
    }
}
