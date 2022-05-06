package it.polimi.ingsw.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class InfluenceProfessorTableTest {
    InfluenceProfessorTable IPT = null;
    @BeforeEach
    public void setUp() {
        IPT = new InfluenceProfessorTable();
    }

    @AfterEach
    public void tearDown() {
        IPT = null;
    }

}