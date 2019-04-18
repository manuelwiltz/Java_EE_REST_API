package repository;
import at.wiltz.entities.Schoolclass;
import at.wiltz.entities.Teacher;
import at.wiltz.entities.Unit;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Manuel Wiltz
 */
public class SchoolRepository {

    private EntityManager em;

    public SchoolRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("School_PU");
        em = emf.createEntityManager();
    }

    //=====================================
    // Teacher
    //=====================================
    public List<Teacher> findAllTeacher(String lastname) {
        TypedQuery<Teacher> query = em.createQuery("select t from Teacher t where t.lastname'" + lastname + "'", Teacher.class);
        return query.getResultList();
    }

    public List<Teacher> findAllTeacher() {
        return em.createQuery("select t from Teacher t").getResultList();
    }

    public void createTeacher(Teacher teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
    }
    
    public void updateTeacher(Teacher t) {
        Teacher teacher = (Teacher) em.find(Teacher.class, t.getId());
        if (teacher != null) {
            teacher = t;
            em.refresh(teacher);
        }
    }

    //=====================================
    // Schoolclass
    //=====================================
    public List<Schoolclass> findAllSchoolclass() {
        return em.createQuery("select s from Schoolclass s").getResultList();
    }
    
    public void createSchoolclass(Schoolclass schoolclass) {
        em.getTransaction().begin();
        em.persist(schoolclass);
        em.getTransaction().commit();
    }
    
    //=====================================
    // Unit
    //=====================================
    public List<Unit> findAllUnits() {
        return em.createQuery("select u from Unit u").getResultList();
    }
    
    public List<Unit> findUnitByClassName(String classname) {
        TypedQuery<Unit> query = em.createQuery("select u from Unit u where u.schoolclass.id='" + classname + "'", Unit.class);
        return query.getResultList();
    }
    
    public void updateUnit(Unit u) {
        Unit unit = (Unit) em.find(Unit.class, u.getId());
        if (unit != null) {
            unit = u;
            em.refresh(unit);
        }
    }
    
    public void createUnit(Unit unit) {
        em.getTransaction().begin();
        em.persist(unit);
        em.getTransaction().commit();
    }

}
