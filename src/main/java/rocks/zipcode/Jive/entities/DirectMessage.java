package rocks.zipcode.Jive.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirectMessage;
    private Long idThreadDirectMessage;
    private Long idUser;
    private Long toUserID;
    private String message;
    private Timestamp createdAt;

    public DirectMessage() {
    }

    public Long getIdDirectMessage() {
        return idDirectMessage;
    }

    public void setIdDirectMessage(Long idDirectMessage) {
        this.idDirectMessage = idDirectMessage;
    }

    public Long getIdThreadDirectMessage() {
        return idThreadDirectMessage;
    }

    public void setIdThreadDirectMessage(Long idThreadDirectMessage) {
        this.idThreadDirectMessage = idThreadDirectMessage;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getToUserID() {
        return toUserID;
    }

    public void setToUserID(Long toUserID) {
        this.toUserID = toUserID;
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
}
