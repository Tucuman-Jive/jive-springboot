package rocks.zipcode.Jive.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Timestamp createdAt; //set value in service
    //    private Timestamp updatedAt; //TODO do we want this value?
    @ManyToOne
    @JoinColumn(name = "channel_id_channel")
    @JsonIgnoreProperties(value = {"description", "createdAt", "updatedAt"})
    private Channel channel;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "password")
    @JoinColumn(name = "id_user") // what is this...
    // @JoinColumn
    private UserEntity userEntity;


    public Message() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

//
//    public Timestamp getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Timestamp updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
