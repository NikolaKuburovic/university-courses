import com.it355.metcourses.dao.AsistentDao;
import com.it355.metcourses.dao.KorisnikDao;
import com.it355.metcourses.dao.ProfesorDao;
import com.it355.model.Asistent;
import com.it355.model.Korisnik;
import com.it355.model.Profesor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/MetCourses-test.xml"})
public class MetCoursesJUnitTest {

    @Autowired
    protected KorisnikDao korisnikDao;
    
    @Autowired
    protected ProfesorDao profesorDao;
    
    @Autowired
    protected AsistentDao asistentDao;

    @Autowired
    private ApplicationContext context;

    public MetCoursesJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   
    @Test
    public void addKorisnikTest(){
        Korisnik korisnik = new Korisnik();
        korisnik.setIme("Jakov");
        korisnik.setPrezime("Jakovljevic");
        korisnik.setUsername("jakovj");
        korisnik.setPassword("123456");
        System.out.println("===============================");
        System.out.println("Dodajem korisnika: " + korisnik);
        System.out.println("===============================");
        Korisnik dodatKorisnik = korisnikDao.addKorisnik(korisnik);
        System.out.println("===============================");
        System.out.println("Dodat je korisnik: " + dodatKorisnik); 
        System.out.println("===============================");
        korisnikDao.deleteKorisnik(korisnik);
        Assert.assertNotNull(dodatKorisnik);
    }
    @Test
    public void getAllKorisnikTest(){
        List<Korisnik> korisnici = korisnikDao.getAllKorisnik();
        System.out.println("===============================");
        System.out.println("Ovo su korisnici: " + korisnici);
        System.out.println("===============================");
        Assert.assertNotNull(korisnici);
    }
    @Test
    public void updateKorisnikTest(){
        Korisnik korisnik2 = korisnikDao.getKorisnikById(1);
        System.out.println("===============================");
        System.out.println("Menjam korisnika: " + korisnik2);
        System.out.println("===============================");
        korisnik2.setEnabled(0);
        Korisnik k = korisnikDao.updateKorisnik(korisnik2);
        System.out.println("===============================");
        System.out.println("Korisnik je izmenjen: " + k);
        System.out.println("===============================");
        Assert.assertNotNull(k);
    }
    @Test
    public void getKorisnikByIdTest(){
        Korisnik korisnik3 = korisnikDao.getKorisnikById(1);
        System.out.println("===============================");
        System.out.println("Pronasao sam korisnika: " + korisnik3);
        System.out.println("===============================");
        Assert.assertNotNull(korisnik3);
    }
    @Test
    public void getAllProfesorTest(){
        List<Profesor> profesori = profesorDao.getAllProfesor();
        System.out.println("===============================");
        System.out.println("Ovo su profesori: " + profesori);
        System.out.println("===============================");
        Assert.assertNotNull(profesori);
    }
    @Test
    public void addProfesorTest(){
        Profesor profesor = new Profesor();
        profesor.setIme("Dusan");
        profesor.setPrezime("Dusanovic");
        profesor.setOblast("CS102 Objekti i apstrakcija podataka");
        System.out.println("===============================");
        System.out.println("Dodajem profesora: " + profesor);
        System.out.println("===============================");
        Profesor dodatProfesor = profesorDao.addProfesor(profesor);
        System.out.println("===============================");
        System.out.println("Dodat je profesor: " + dodatProfesor); 
        System.out.println("===============================");
        List<Profesor> profesori2 = profesorDao.getAllProfesor();
        int brojProfesora = profesori2.size();
        Profesor dodatiProfesor = profesori2.get(brojProfesora-1);
        int profId = dodatiProfesor.getId();
        System.out.println("===============================");
        System.out.println("ID dodatog profesora je : " + profId);
        System.out.println("===============================");
        profesorDao.deleteProfesor(profId);
        Assert.assertNotNull(dodatProfesor);
    }
    @Test
    public void updateProfesorTest(){
        Profesor profesor2 = profesorDao.getProfesorById(1);
        System.out.println("===============================");
        System.out.println("Menjam profesora: " + profesor2);
        System.out.println("===============================");
        String oblast = RandomStringUtils.randomAlphanumeric(16);
        profesor2.setOblast(oblast);
        Profesor p = profesorDao.updateProfesor(profesor2);
        System.out.println("===============================");
        System.out.println("Profesor je izmenjen: " + p);
        System.out.println("===============================");
        Assert.assertNotNull(p);
    }
    @Test
    public void getProfesorByIdTest(){
        Profesor profesor3 = profesorDao.getProfesorById(2);
        System.out.println("===============================");
        System.out.println("Pronadjen je profesor : " + profesor3);
        System.out.println("===============================");
        Assert.assertNotNull(profesor3);
    }
    
    @Test
    public void getAllAsistentTest(){
        List<Asistent> asistenti = asistentDao.getAllAsistent();
        System.out.println("===============================");
        System.out.println("Ovo su asistenti: " + asistenti);
        System.out.println("===============================");
        Assert.assertNotNull(asistenti);
    }
    @Test
    public void addAsistentTest(){
        Asistent asistent = new Asistent();
        asistent.setIme("Pavle");
        asistent.setPrezime("Pavlovic");
        asistent.setOblast("CS103 Algoritmi i strukture podataka");
        System.out.println("===============================");
        System.out.println("Dodajem asistenta: " + asistent);
        System.out.println("===============================");
        Asistent dodatAsistent = asistentDao.addAsistent(asistent);
        System.out.println("===============================");
        System.out.println("Dodat je profesor: " + dodatAsistent); 
        System.out.println("===============================");
        List<Asistent> asistenti2 = asistentDao.getAllAsistent();
        int brojAsistenata = asistenti2.size();
        Asistent dodatiAsistent = asistenti2.get(brojAsistenata-1);
        int asId = dodatiAsistent.getId();
        System.out.println("===============================");
        System.out.println("ID dodatog asistenta je : " + asId);
        System.out.println("===============================");
        asistentDao.deleteAsistent(asId);
        Assert.assertNotNull(dodatAsistent);
    }
    @Test
    public void updateAsistentTest(){
        Asistent asistent2 = asistentDao.getAsistentById(1);
        System.out.println("===============================");
        System.out.println("Menjam asistenta: " + asistent2);
        System.out.println("===============================");
        String oblast = RandomStringUtils.randomAlphanumeric(16);
        asistent2.setOblast(oblast);
        Asistent a = asistentDao.updateAsistent(asistent2);
        System.out.println("===============================");
        System.out.println("Asistent je izmenjen: " + a);
        System.out.println("===============================");
        Assert.assertNotNull(a);
    }
    @Test
    public void getAsistentByIdTest(){
        Asistent asistent3 = asistentDao.getAsistentById(2);
        System.out.println("===============================");
        System.out.println("Pronadjen je asistent : " + asistent3);
        System.out.println("===============================");
        Assert.assertNotNull(asistent3);
    }
    
}
