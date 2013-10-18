VaadinSplitPanels
=================
Using split panels (horizontal and vertical) and different layouts with many components inside each of the two panels.
***

Using postgresql database:
1. All the necessary .jar files should be added to /WEB-INF/lib/ folder (for Tomcat).
2. File hibernate.cfg.xml with database configurations should be added to /src/ folder.
3. Instead of "new Configuration().configure().buildSessionFactory();"
   One should use "new AnnotationConfiguration().configure().buildSessionFactory();"
4. Download .jar file, which contains org.hibernate.cfg.AnnotationConfiguration class and
   add it to the other jar files in /WEB-INF/lib/ folder.

5. Check the saved data with pgAdmin III.
