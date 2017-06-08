package dk.kb.arkitekturgruppen;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

/**
 * Start program, attach with JConsole or JVisualVM with the JConsole-MBeans plugin installed, and open
 * the X MBean and see values.  Enter data a line a time, and see the uptimeMS and s fields change when refreshing.
 */
public class App {
    public static void main(String[] args) throws Exception {
        SimpleDemoBean bean = new SimpleDemoBean();

        // magic here
        final ObjectName objectName = new ObjectName("dk.kb.arkitekturgruppen:type=HelloWorld");
        ManagementFactory.getPlatformMBeanServer().registerMBean(bean, objectName);
        // magic done
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((bean.s = br.readLine()) != null) {
            System.out.println(bean.getUptimeMS() + " - " + bean.getS());
        }
    }
}
