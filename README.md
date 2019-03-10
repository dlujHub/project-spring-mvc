Lista laureaților Premiului Nobel folosind Spring MVC
===============================
Aplicația creată poate fi folosită pentru afișarea listei și informațiilor despre fiecare persoană, permițând și editarea, ștergerea sau adăugarea datelor noi, având și o pagină pe care se afișează numărul de laureați pe cap de locuitor.
Informațiile sunt stocate într-o bază de date HSQLDB, iar în cazul introducerii greșite a datelor sunt afișate mesajele de eroare corespunzătoare.

###1. Tehnologiile folosite

•	Spring MVC

•	Maven

•	JSP

•	Bootstrap

•	HSQLDB

###2. Pașii de instalare

1. Importați proiectul în InteliJ IDEA folosind File -> Open.. -> alegeți proiectul -> OK.
2. Rulați aplicația
3. Poate fi accesat urmând acest [Link](http://localhost:8080/project-spring-mvc/laureates)


===
Aplicația arată în felul următor (pagina principală):
![1](/src/main/webapp/resources/img/1.png)
Aici se afișează lista completă, sortată după nume. Butonul ”More..” permite accesare mai multor informații, ”Edit..” – editarea acestora și ”Delete” – ștergerea. Pagina cu informații arată în felul următor:
![2](/src/main/webapp/resources/img/2.png)
Editarea:
 ![edit](/src/main/webapp/resources/img/edit.png)
Când se apasă ”Update”, va apărea pagina cu informațiile editate și mesajul ”Information updated successfully!”. 
![updated](/src/main/webapp/resources/img/updated.png)

Dacă este șters, acesta dispare și apare mesajul ”Laureate is deleted.”.
 ![deleted](/src/main/webapp/resources/img/deleted.png)

La adăugarea noilor date, va apărea:
 ![3](/src/main/webapp/resources/img/3.png)

În caz că nu sunt introduse unele date necesare, sau formatul acestora nu este corect, apar mesajele corespunzătoare.
  ![errors](/src/main/webapp/resources/img/errors.png)

Dacă nu sunt erori, se redirecționează pe pagina cu informații, afișându-se mesajul ”Information updated successfully!”. Se atribuie câte un id unic la fiecare adăugare.
  ![4](/src/main/webapp/resources/img/4.png)

La accesarea ”Laureates per capita” apare o listă de forma (sortată în funcție de numărul laureaților la 10 mln. de locuitori):
  ![capita](/src/main/webapp/resources/img/capita.png)

Proiectul se accesează de pe http://localhost:8080/project-spring-mvc/.

