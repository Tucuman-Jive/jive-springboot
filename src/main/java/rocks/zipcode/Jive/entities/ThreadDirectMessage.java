package rocks.zipcode.Jive.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ThreadDirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idThreadDirectMessage;

    public ThreadDirectMessage() {
    }

    public Long getIdThreadDirectMessage() {
        return idThreadDirectMessage;
    }

    public void setIdThreadDirectMessage(Long idThreadDirectMessage) {
        this.idThreadDirectMessage = idThreadDirectMessage;
    }
}
