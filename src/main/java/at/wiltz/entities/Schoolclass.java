package at.wiltz.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Manuel Manuel
 */
@Entity
public class Schoolclass implements Serializable {
    
    @Id
    private String id;
    
    private String room;

    public Schoolclass() {
    }

    public Schoolclass(String id, String room) {
        this.id = id;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Schoolclass{" + "id=" + id + ", room=" + room + '}';
    }

}
