package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_returns_correct_equal() {
        assertTrue(new Team().equals(new Team()), "Two team objects with same parameters are equal");
        assertTrue(!new Team().equals(new TeamTest()), "Objects must be of same type");

        Team t = new Team();
        assertTrue(t.equals(t), "An object equals itself");

        Team sameA = new Team("Same");
        Team sameB = new Team("Same");
        assertTrue(sameA.equals(sameB), "Has same name and same members");

        sameB.addMember("Random person");
        assertTrue(!sameA.equals(sameB), "Has same name but not same members");

        sameA.setName("Same A");
        sameA.addMember("Random Person");
        assertTrue(!sameB.equals(sameA), "Has same members but not same name");

        Team frontEnd = new Team("Front End");
        frontEnd.addMember("Alice");
        Team backEnd = new Team("Back End");
        backEnd.addMember("Bob");
        assertTrue(!frontEnd.equals(backEnd), "Does not have same name nor members");
    }


    @Test 
    public void equals_returns_correct_hashcode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        // System.out.println(result);
        assertEquals(expectedResult, result);
    }

}
