curl -d "@json-data/consent/consent1.json" -H "Content-Type: application/json" -X POST http://localhost:8080/api/consent
curl -d "@json-data/consent/consent2.json" -H "Content-Type: application/json" -X POST http://localhost:8080/api/consent
curl -d "@json-data/consent/consent3.json" -H "Content-Type: application/json" -X POST http://localhost:8080/api/consent

curl -d "@json-data/notes/note1.json" -H "Content-Type: application/json" -X POST http://localhost:8080/api/notes
curl -d "@json-data/notes/note2.json" -H "Content-Type: application/json" -X POST http://localhost:8080/api/notes
curl -d "@json-data/notes/note3.json" -H "Content-Type: application/json" -X POST http://localhost:8080/api/notes