package com;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Nicholas on 10/31/2015.
 */
public class BookAPITest {

    private static HttpServer theArchiveServer;

    @Before
    public void setUp() throws Exception {

    }

    @BeforeClass
    public static void beforeTest(){
        theArchiveServer = new TheArchiveServer().start();
    }

    @After
    public void tearDown() throws Exception {

    }

    @AfterClass
    public static void afterTest(){
        theArchiveServer.shutdown();
    }

    @Test
    public void testAMethod(){
        assert true;
    }
}