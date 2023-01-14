package rocks.zipcode.Jive.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "userEntity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    // TODO changed this
    @JsonIgnore
    // @OneToMany(mappedBy = "userEntity")
    @OneToMany
    private Set<Membership> memberships = new HashSet<>();
    // private List<Member> memberships = new ArrayList<>();

    @JsonIgnore
    @OneToMany
    private Set<Message> messages = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(long l, String user1, String password1) {
    }

    // TODO changed this
    public Set<Membership> getMemberships() {
        return memberships;
    }

    // TODO changed this
    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
