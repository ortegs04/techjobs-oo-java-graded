package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job JobInstance = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(JobInstance.getName(), "Product tester");
        assertEquals(JobInstance.getEmployer().getValue(), "ACME");
        assertEquals(JobInstance.getLocation().getValue(), "Desert");
        assertEquals(JobInstance.getPositionType().getValue(), "Quality control");
        assertEquals(JobInstance.getCoreCompetency().getValue(), "Persistence");


        assertTrue(JobInstance instanceof Job);
        assertTrue(JobInstance.getEmployer() instanceof Employer);
        assertTrue(JobInstance.getLocation() instanceof Location);
        assertTrue(JobInstance.getPositionType() instanceof PositionType) ;
        assertTrue(JobInstance.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job JobInstance = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job JobInstanceTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(JobInstance.getId() == JobInstanceTwo.getId());
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job JobInstance = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(JobInstance.toString(), "\nID: "+JobInstance.getId()+"\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n");
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job JobInstance = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(JobInstance.toString().charAt(0), '\n');
        assertEquals(JobInstance.toString().charAt(JobInstance.toString().length()-1), '\n');
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job JobInstance = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals(JobInstance.toString(), "\nID: "+JobInstance.getId()+"\n" +
                "Name: Data not available\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n");
    }

}
