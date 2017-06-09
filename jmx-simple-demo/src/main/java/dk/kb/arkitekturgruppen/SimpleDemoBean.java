package dk.kb.arkitekturgruppen;

/**
 * This is the implementation of the MXBeanInterface that give functionality to the methods
 * defined in the interface.  No magic here.
 */
public class SimpleDemoBean implements MXBeanInterface {
    long startTime = System.currentTimeMillis();

    public long getUptimeMS() {
        return System.currentTimeMillis() - startTime;
    }

    public String s;

    public String getS() {
        return s;
    }
}
