package dk.kb.arkitekturgruppen;

/**
 * This is the definition exposed by JMX to the world. get/setters are exposed as fields.
 *
 * Must be public! If annotated with @MXBeanInterface, interface name doesn't matter.
 */
@javax.management.MXBean
public interface MXBeanInterface {

    long getUptimeMS();

    String getS();
}
