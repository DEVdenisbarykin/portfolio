
# Vehicle Management API

## Übersicht

Diese API bietet grundlegende CRUD-Funktionalitäten für das Management von Fahrzeugen.  
Sie unterscheidet klar zwischen Entities und DTOs, nutzt globales Error Handling und schützt sensible Endpunkte mit Basic Authentication.

---

## Technologien

- Java (openjdk 22.0.1)
- Spring Boot
- Spring Data JPA (Repository Layer)
- Spring Security (Basic Auth)
- OpenAPI / Swagger (API Dokumentation)
- Lombok 

---

## Features

- REST-konforme API mit folgenden Endpunkten:  
  - `GET /v1/vehicles` — Liste aller Fahrzeuge (optionale Filterung)  
  - `GET /v1/vehicles/{id}` — Fahrzeugdetails abrufen  
  - `POST /v1/vehicles` — Fahrzeug anlegen  
  - `PUT /v1/vehicles/{id}` — Fahrzeug vollständig aktualisieren  
  - `PATCH /v1/vehicles/{id}` — Fahrzeug teilweise aktualisieren  
  - `DELETE /v1/vehicles/{id}` — Fahrzeug löschen (Basic Auth geschützt)

- Klare Trennung zwischen Entity und DTO für sauberes API-Design  
- Validierung der Eingabedaten mit eindeutigen Fehlermeldungen  
- Globales Exception Handling mit Custom Exceptions und strukturierter Fehlerausgabe  
- Swagger UI für interaktive API-Dokumentation und Testing  
- Basic Authentication auf geschützten Endpunkten (z. B. DELETE)

---

## Quickstart

### Voraussetzungen

- Java (openjdk 22.0.1)
- Maven 
- Datenbank (aktuell H2 eingebunden)

### Build & Run

```bash
TODO
```
Die API ist erreichbar unter:
[localhost:8080/api/v1/vehicles](localhost:8080/api/v1/vehicles)

Swagger UI unter:
[localhost:8080/api/swagger-ui/index.html](localhost:8080/api/swagger-ui/index.html)

### Authentifizierung

Für Basic Auth geschützte Endpunkte wird ein Username und Passwort benötigt:

- Benutzername: admin
- Passwort: xxx

(Das Passwort ist konfigurierbar in der *application.properties*)

### Beispiel JSON für POST /v1/vehicles

```json
{
  "vehicleType": "CAR",
  "brand": "Volkswagen",
  "model": "Golf",
  "engineType": "GASOLINE"
}
```

## Nächste Schritte 

- Einführung einer neuen Entity "MaintenanceEntry" um Fahrzeug Wartungen zu dokumentieren.
- Unit-Testing
- Erweiterung der Swagger-Dokumentation um Beispielobjekte.
- Vollständige Swagger-Dokumentation aller Endpunkte und Felder.


## Kontakt

Für Fragen oder Anregungen gerne melden:
**Denis Barykin** - denis.barykin@outlook.de
