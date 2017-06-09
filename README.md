# jmx-simple-demo

In this project it is demonstrated how a very small and simple
subset of JMX can provide a simple "while running"-statistics
as an alternative to watching logfiles scroll endlessly or having to
explicitly code some kind GUI for the purpose.

Source:
---

Steps:

1. An interface with the getters to expose.  Only use simple return types. Annotate it with `@javax.management.MXBean.  See 
 [MXBeanInterface.java](blob/master/jmx-simple-demo/src/main/java/dk/kb/arkitekturgruppen/MXBeanInterface.java)
2. A plain bean implementing the interface.  See
[SimpleDemoBean.java](blob/master/jmx-simple-demo/src/main/java/dk/kb/arkitekturgruppen/SimpleDemoBean.java)
3. Exposing the bean to JMX and update the values to get. See
[App.java](blob/master/jmx-simple-demo/src/main/java/dk/kb/arkitekturgruppen/App.java)
4. Use any JMX monitoring tool to see values.


To run:
---

* Invoke App (for instance with `mvn exec:java`).  It registers a bean and waits for input from the command line.
* Start JConsole or VisualVM (in the Oracle JDK, enable JConsole-MBeans plugin), attach to "App" 
  and locate the MBean group "dk.kb.arkitekturgruppen" and click
  "Hello World".  The current values of the "updateMS" and "s" fields are shown.
* Type one or more lines of text as input to the running App.  Each time "Enter" is pressed a line showing the current number of
  milliseconds since program start and the line just typed is shown.
* Refresh the "HelloWorld" fields in JConsole/VisualVM (button or Alt-R in panel) and see that the value of "s" is the last line entered.

![visualvm screenshot](app-in-visualvm.png)


Background:
---


JMX is a very useful technology for interacting with 
a Java program in a separate way from what is explicitly coded by 
the programer, and can provide a full remote access API with very little coding in "our"
codebase.  Unfortunately the development of JMX has stalled - JMX 2.0 did not make it to Java 6 and
was later withdrawn - so it is not quite as streamlined as the 
rest of the new Java things.

However, a very low hanging fruit is limiting the use of JMX to 
just exposing non-"complex type" getters in MXBeans as this requires very little
coding, and still get all the benefits from the client tools.

The subset used in this project is:

* Use MXBeans only using the `@MXBean` annotation on the interface.
* Only getters are exposed to make a read-only presentation of data.
* No network port.  VisualVM/JConsole are used as clients and they get 
  access using the Attach API which is restricted to same user on same machine.



/tra 2017-05-24
