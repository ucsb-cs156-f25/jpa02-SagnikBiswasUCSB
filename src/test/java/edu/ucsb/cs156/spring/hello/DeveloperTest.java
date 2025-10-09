package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Sagnik B.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("SagnikBiswasUCSB", Developer.getGithubId());
    }


    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Avaneesh K."),"Team should contain Avaneesh K.");
        assertTrue(t.getMembers().contains("Ethan C."),"Team should contain Ethan C.");
        assertTrue(t.getMembers().contains("Sagnik B."),"Team should contain Sagnik B.");
        assertTrue(t.getMembers().contains("Ethan K."),"Team should contain Ethan K.");
        assertTrue(t.getMembers().contains("Tara R."),"Team should contain Tara R.");
        assertTrue(t.getMembers().contains("Jehmiah P."),"Team should contain Jehmiah P.");
    }
}
