package dk.kb.arkitekturgruppen;

/**
 * This is the definition exposed by JMX to the world.
 */
@javax.management.MXBean
public interface MXBeanInterface {

    long getUptimeMS();

    String getS();
}
