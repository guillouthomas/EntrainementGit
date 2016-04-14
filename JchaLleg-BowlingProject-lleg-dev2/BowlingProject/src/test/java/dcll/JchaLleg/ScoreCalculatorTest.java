package dcll.JchaLleg;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ScoreCalculatorTest
        extends TestCase
{
    ScoreCalculator test;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ScoreCalculatorTest( String testName )
    {
        super( testName ); this.test = new ScoreCalculator();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ScoreCalculatorTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue(true);
    }

    public void testSimple()
    {
        int res = test.calculerScoreSimple("12121212123445627281");
        assertEquals(57, res);
    }

    public void testSimpleAvecZero()
    {
        int res = test.calculerScoreSimpleAvecZero("9_9_9_9_9_9_9_9_9_9_");
        assertEquals(90, res);
    }

    public void testScoreSimpleAvecSrikeSansCumul()
    {
        int res = test.calculerScoreAvecStrike("XXXXXXXXXX");
        assertEquals(100, res);
    }

    public void testScoreSimpleAvecSrikeSansCumul2()
    {
        int res = test.calculerScoreAvecStrike("XXXXXXXXX81");
        assertEquals(99, res);
    }

    public void testScoreAvecSpareSansStrikeSansCumul()
    {
        int res = test.calculerScoreAvecSpareSansStrikeSansCumul("1235639/5/_/7/__1/54");
        assertEquals(79, res);
    }

    public void testScoreComplexeScoreSpareCumul()
            throws InvalideString, InvalideSize {
        int res = test.calculerComplexeScoreSpareCumul("1235639/5/_/7/__1/54");
        int res2 = test.calculerComplexeScoreSpareCumul("1235639/5/_/7/__1/XXX");
        int res3 = test.calculerComplexeScoreSpareCumul("1235639/5/_/7/__1/3/3");
        int res4 = test.calculerComplexeScoreSpareCumul("XXXXXXXXXX_/");
        assertEquals(96, res);
        assertEquals(122, res2);
        assertEquals(98, res3);
        assertEquals(280, res4);
    }

    public void testValidate1TropCourt() {
        boolean thrown = false;

        try {
            test.validate("_/");
        } catch (InvalideSize e) {
            thrown = true;
        } catch (InvalideString invalideString) {

        }
        try {
            test.validate("_/111111111111111111X");
        } catch (InvalideSize e) {
            thrown = true;
        } catch (InvalideString invalideString) {

        }
        assertTrue(thrown);
    }

    public void testValidate2TropLong() {
        boolean thrown = false;

        try {
            test.validate("_/XXXXXXXXXXXXX");
        } catch (InvalideSize e) {
            thrown = true;
        } catch (InvalideString invalideString) {

        }

        assertTrue(thrown);
    }


    public void testValidate3InvalidString() {
        boolean thrown = false;

        try {
            test.validate("-L");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate4OK() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXXX63");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertFalse(thrown);
    }

    public void testValidate5OK() {
        boolean thrown = false;

        try {
            test.validate("81XXXXXXXXXXX");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertFalse(thrown);
    }

    public void testValidate6Invalide() {
        boolean thrown = false;

        try {
            test.validate("81X8XXXXXXXXXX");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate7TropCourt() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXX7/");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
        }

        assertTrue(thrown);
    }

    public void testValidate8TropLong() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXX7/XX");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
        }

        assertTrue(thrown);
    }

    public void testValidate9Invalide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXX7//");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate10TropCourt() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXXX");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
        }

        assertTrue(thrown);
    }

    public void testValidate11Invalide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXXX/");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
        }

        assertTrue(thrown);
    }

    public void testValidate12Invalide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXXXX/");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate13TropLong() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXX626");
        } catch (InvalideSize e) {
            thrown = true;

        } catch (InvalideString invalideString) {
        }

        assertTrue(thrown);
    }

    public void testValidate14Invalide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXX65");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate15Invalide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXXXXL");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate16Invalide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXXX/8");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    public void testValidate17Valide() {
        boolean thrown = false;

        try {
            test.validate("XXXXXXXXX8/8");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }

        assertFalse(thrown);
    }

    public void testValidateCobertura() {
        boolean thrown = false;

        try {
            test.validate("/XXXXXXXX8/8");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            test.validate("XcXXXXXXX8/8");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            test.validate("11XXXXXXXX8/r");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            test.validate("11XXXXXXXX81");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertFalse(thrown);

        thrown = false;
        try {
            test.validate("1nXXXXXXXX81");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            test.validate("XcXXXXXXX81");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            test.validate("XXXXXXXXXX5X");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            test.validate("118811111111111111111");
        } catch (InvalideSize e) {

        } catch (InvalideString invalideString) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
