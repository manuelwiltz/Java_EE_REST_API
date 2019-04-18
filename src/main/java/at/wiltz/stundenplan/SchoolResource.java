package at.wiltz.stundenplan;

import at.wiltz.entities.Schoolclass;
import at.wiltz.entities.Teacher;
import at.wiltz.entities.Unit;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.SchoolRepository;

/**
 *
 * @author Manuel
 */
@Path("rest")
public class SchoolResource {

    private SchoolRepository rep = new SchoolRepository();

    ///////////////////////////
    // Init
    ///////////////////////////
    @GET
    @Path("init")
    @Produces(MediaType.TEXT_PLAIN)
    public String init() {
        Teacher t = new Teacher("Manuel", "Wiltz", "E11");
        Teacher t1 = new Teacher("Teacher1", "Lastname", "119");
        Teacher t2 = new Teacher("Rupert", "Obermueller", "222");
        Teacher t3 = new Teacher("Herbert", "Lackinger", "201");
        Teacher t4 = new Teacher("Franz", "Rager", "E20");
        rep.createTeacher(t);
        rep.createTeacher(t1);
        rep.createTeacher(t2);
        rep.createTeacher(t3);
        rep.createTeacher(t4);

        Schoolclass s = new Schoolclass("5BHITM", "119");
        Schoolclass s1 = new Schoolclass("5AHITM", "220");
        Schoolclass s2 = new Schoolclass("4AHITM", "E24");
        Schoolclass s3 = new Schoolclass("4AHIF", "153");
        Schoolclass s4 = new Schoolclass("4BHIF", "E72");
        rep.createSchoolclass(s);
        rep.createSchoolclass(s1);
        rep.createSchoolclass(s2);
        rep.createSchoolclass(s3);
        rep.createSchoolclass(s4);

        Unit u = new Unit(1, 1, "SEW", t, s);
        Unit u0 = new Unit(4, 4, "SEW", t, s);
        Unit u01 = new Unit(2, 2, "AM", t, s);
        Unit u1 = new Unit(2, 2, "MDT", t1, s1);
        Unit u2 = new Unit(3, 3, "D", t2, s4);
        Unit u3 = new Unit(4, 4, "AM", t3, s3);
        Unit u4 = new Unit(5, 5, "WR", t4, s2);
        rep.createUnit(u);
        rep.createUnit(u0);
        rep.createUnit(u01);
        rep.createUnit(u1);
        rep.createUnit(u2);
        rep.createUnit(u3);
        rep.createUnit(u4);
        return "imported";
    }

    ///////////////////////////
    // Teacher
    ///////////////////////////
    @GET
    @Path("teacher/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAllTeacher() {
        return rep.findAllTeacher();
    }

    ///////////////////////////
    // Schoolclass
    ///////////////////////////
    @GET
    @Path("class/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Schoolclass> getAllSchoolclass() {
        return rep.findAllSchoolclass();
    }

    ///////////////////////////
    // Unit
    ///////////////////////////
    @GET
    @Path("unit/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unit> getAllUnits() {
        return rep.findAllUnits();
    }

    @GET
    @Path("unit/findbyclass/{schoolclass}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unit> getByClass(@PathParam("schoolclass") String schoolclass) {
        return rep.findUnitByClassName(schoolclass);
    }

    @PUT
    @Path("unit/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Unit unit) {
        rep.updateUnit(unit);
    }

}
