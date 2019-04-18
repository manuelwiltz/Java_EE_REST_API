package at.wiltz.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Manuel Wiltz
 */
@Entity
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int day;
    private int unit;
    private String subject;
    
    private Teacher teacher;
    
    private Schoolclass schoolclass;

    public Unit() {
    }

    public Unit(int day, int unit, String subject, Teacher teacher, Schoolclass schoolclass) {
        this.day = day;
        this.unit = unit;
        this.subject = subject;
        this.teacher = teacher;
        this.schoolclass = schoolclass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schoolclass getSchoolclass() {
        return schoolclass;
    }

    public void setSchoolclass(Schoolclass schoolclass) {
        this.schoolclass = schoolclass;
    }
    
}
