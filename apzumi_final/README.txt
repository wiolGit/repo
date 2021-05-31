- aplikacja powinna zawierać plik README z instrukcją budowania, konfiguracji oraz uruchomienia


Technologie:
Baza danych MySql 8
Java 8
Spring Boot 2.3.11

Projekt budowany do pliku .jar



Instrukcją budowania:
mvn install

-------------------------------------------------------------------------

Instrukcja konfiguracji:
Zamiennie możliwość zmiany konfiguracji bazy danych w pliku :
application_database.properties

#MySql configuration version
#Schemat apzumi
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/apzumi?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Warsaw
jdbc.username = mysql
jdbc.password = mysql
hibernate.dialect = org.hibernate.dialect.MySQL8Dialect


-------------------------------------------------------------------------

Instrukcja uruchamiania:

Uruchomienie :
Uruchamiamy plik : apzumi2.jar

Projekt po uruchomieniu dostępny pod adresem :
http://localhost:8080/index

Zaimplementowana funkcjonalność :
- pobierania danych z pominięciem pola userId
- usuwania pojedynczego wiersza
- edycji pola title oraz body 
- filtrowanie po polu title



Funkcjonalność pobierania danych z adresu:
 https://jsonplaceholder.typicode.com/posts
 
 Dla potrzeb testowych dane będą pobierane co 10 minut
Konfiguracja pobierania danych raz na dzień została zakomentowana.

-------------------------------------------------------------------------

Endpointy REST:
/content/edit/
=> edycja danych  pola title oraz body  dla podanego id
http://localhost:8080/content/edit/{id}?title={title}&body={body}
Przykład
http://localhost:8080/content/edit/1?title=tytul_przyklad&body=body_przyklad


/content/delete/
=> usuwanie danych  dla podanego id
http://localhost:8080/content/delete/{id}
Przykład
http://localhost:8080/content/edit/1


/content/
=> pobranie całej listy postów
http://localhost:8080/content/
Przykład
http://localhost:8080/content/


/content/byfield/{field}
=> pobranie całej listy postów dla zadanego pola title
http://localhost:8080/content/byfield/{title}
Przykład
http://localhost:8080/content/byfield/moj_tytul



-------------------------------------------------------------------------








