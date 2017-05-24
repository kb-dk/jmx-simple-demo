package dk.kb.arkitekturgruppen;

/**
 * This is the implementation of the MXBeanInterface that give functionality to the methods
 * defined in the interface.
 */
public class HelloWorldBean implements MXBeanInterface {
    long startTime = System.currentTimeMillis();

    public long getUptimeMS() {
        return System.currentTimeMillis() - startTime;
    }

    public String s;

    public String getS() {
        return s;
    }
}
