# Retro notes Service
This service exists to allow a client to interface with a database (currently using an in memory DB which does not persist between runs of the service) which maintains a list of retro actions. 
Used primarily for explaining REST requests and as a basis for mock interviews.
Interview scenarios include:
 - Running the Spring Boot app and getting the candidate to create a front-end application which calls the GET and POST endpoints to display and submit notes.
  - There is an example front-end application in the vue folder
- Have the candidate extend the back-end application so that notes now have the concept of an 'author'.
  - Some discussion points on this could include how to make the endpoints backwards-compatible (the handling of old notes which do not have an author), how the ```post-data``` script would need updating and modification to documentation (including this file).
- Have the candidate create a new back-end application which implements the endpoints as outlined in the documentation below

## Running the Service

To run the service as a Spring-Boot app run ```./gradlew bootRun``` in the root directory.

To fill the database with some example notes and consent documents cd into the ```scripts``` directory and run ```sh post-data.sh```.

Then navigate to http://localhost:8080/api/notes to see the list of retro notes.


## GET retro notes endpoint
```/api/notes```

Will return a list of all notes currently stored in the DB

## POST retro note endpoint
```/api/notes```

Allows the user to post a new note.

Example:
```
{
  "title":"title",
  "content":"content",
  "date":"2018-08-03T12:12:12+01:00"
}
```

## GET consent endpoint
```/api/consent/latest```

Will return the consent document with the highest version number.

## POST consent endpoint
```/api/consent```

Allows the user to post a new version of the consent document.

Example:
```
{
  "version":"3",
  "content":"You hereby kinda promise to do everything agreed in the retro."
}
```
