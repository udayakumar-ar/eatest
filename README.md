# eatest

This application will list out festival detail in a particular manner:
- Top level with the management name
- Next level with the band name
- Next level with the band attended festival name

All the above records will be ordered alphabetically.

This festival data will be provided from a different API team. This application consumes that data and displays the record in the above mentioned manner.

To run the application, execute the below maven command
```bash
mvn spring-boot:run
```
Once the application is up and running, go to browser and enter
[http://localhost:8080/listMusicFestival](http://localhost:8080/listMusicFestival)

It will process the request and displays the success or error page based on the API response from the third party.

# Success screen
![Alt text](/src/main/resources/SuccessPage.PNG?raw=true "Success Screen page")

# Error screen
![Alt text](/src/main/resources/ErrorPage.PNG?raw=true "Error Screen page")
