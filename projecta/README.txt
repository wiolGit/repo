


Aplikacja dostępna pod adresem :
http://localhost:8080/index

Funkcjonalność:
- dodawanie elementów : Pracownik, AktywnyPracownik
- usuwanie elementów : Pracownik, AktywnyPracownik
- edycja elementów  : Pracownik, AktywnyPracownik
- podgląd elementów  : Pracownik, AktywnyPracownik


endpointy REST:


http://localhost:8080/content/ap/
=> Wyświetla wszystkie dane z tabeli  Aktywni Pracownicy



http://localhost:8080/content/p/
=> Wyświetla wszystkie dane z tabeli  Pracownicy


http://localhost:8080/content/byfield/ap/
=>Wyświetla dane z tabeli Pracownicy oraz AktywniPracownicy   , tylko aktywni pracownicy



http://localhost:8080/content/byfield/p/
=>Wyświetla dane z tabeli Pracownicy oraz AktywniPracownicy   , wszyscy pracownicy



http://localhost:8080/content/edit/1?val1={name}&val2={salary}&val3={datazatrud}
	=>Edycja pól name, salary , dataZatrudnienia
	
	
http://localhost:8080/content/edit/1?val1=Kunegunda&val2=33.33&val3=2001-05-22
		=>Edycja pól name, salary , dataZatrudnienia
	
http://localhost:8080/content/delete/2
	=>Usunięcie wiersza o indeksie numer 2


http://localhost:8080/content/savedata/
	=>Zapis danych  znajdujących się body komunikatu
	Należy zdefiniować body komunikatu