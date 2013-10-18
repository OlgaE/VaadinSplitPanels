VaadinSplitPanels
=================
Using split panels (horizontal and vertical) and different layouts with many components inside each of the two panels.


Using postgresql database:
   All the necessary .jar files should be added to /WEB-INF/lib/ folder (for Tomcat).

   File hibernate.cfg.xml with database configurations should be added to /src/ folder.
   
   Instead of "new Configuration().configure().buildSessionFactory();"
   One should use "new AnnotationConfiguration().configure().buildSessionFactory();"
   
   Download .jar file, which contains org.hibernate.cfg.AnnotationConfiguration class and
   add it to the other jar files in /WEB-INF/lib/ folder.
   Check the saved data with pgAdmin III.
