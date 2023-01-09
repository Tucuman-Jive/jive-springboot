package rocks.zipcode.Jive.entities;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "channel_id_channel")
    private Channel channel;
    // private Long idUser;
    // private Long channelID;
    // private Timestamp updatedAt; //TOOK OUT!!!!
    // private Timestamp createdAt;

    // TODO changed this
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "password")
    @JoinColumn(name = "id_user") // what is this...
    // @JoinColumn
    private UserEntity userEntity;

    public Membership() {
    }

    // TODO changed this
    public UserEntity getUserEntity() {
        return userEntity;
    }

    // TODO changed this
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public Long getIdUser() {
    // return idUser;
    // }

    // public void setIdUser(Long idUser) {
    // this.idUser = idUser;
    // }

//    public Long getChannelID() {
//        return channel.getId();
//    }
//
//    public void setChannelID(Channel channel) {
//        setChannel(channel);
//    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    // public Timestamp getUpdatedAt() {
    // return updatedAt;
    // }

    // public void setUpdatedAt(Timestamp updatedAt) {
    // this.updatedAt = updatedAt;
    // }

    // public Timestamp getCreatedAt() {
    // return createdAt;
    // }

    // public void setCreatedAt(Timestamp createdAt) {
    // this.createdAt = createdAt;
    // }
}
