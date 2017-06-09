# jmx-simple-demo

Source:
---

Steps:

1. An interface with the getters to expose. Annotate it with `@javax.management.MXBean.  See 
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
the programer.

In this project it is demonstrated how a very small and simple
subset of JMX can be used very easily to provide a "while running"-statistics
as an alternative to watching logfiles scroll endlessly or having to
explicitly code some kind GUI for the purpose.

The subset used here is:

* @MXBean annotates the interface to make it a MXBean.
* Only getters are exposed to make a read-only presentation of data.
* VisualVM/JConsole are used as clients to make configuration as simple as possible.



/tra 2017-05-24
