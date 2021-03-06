# football-team-standing


--Docker command to build image and run the application.

    cd football-standing

    docker build -t football:0.0.1 .

    docker run -p 8080:8080 football:0.0.1



##API:<br />
######localhost:8080/api/v1//football/standing <br />
######Response:<br />
```json
[
    {
        "countryName": "England",
        "countryId": "41",
        "leagueName": "Championship",
        "leagueId": "149",
        "teamName": "2641",
        "teamId": "Norwich",
        "overallLeaguePosition": "1"
    },
    {
        "countryName": "England",
        "countryId": "41",
        "leagueName": "Championship",
        "leagueId": "149",
        "teamName": "2644",
        "teamId": "Brentford",
        "overallLeaguePosition": "2"
    },
    .
    .
    .
]
```


######localhost:8080/api/v1//football/standing?countryName=France<br />

######Response:<br />
```json
[
    {
        "countryName": "France",
        "countryId": "46",
        "leagueName": "Ligue 2",
        "leagueId": "177",
        "teamName": "3029",
        "teamId": "Troyes",
        "overallLeaguePosition": "1"
    },
    {
        "countryName": "France",
        "countryId": "46",
        "leagueName": "Ligue 2",
        "leagueId": "177",
        "teamName": "3042",
        "teamId": "Clermont",
        "overallLeaguePosition": "2"
    },
    .
    .
    .
]
```


######localhost:8080/api/v1//football/standing?teamName=3033&countryName=France<br />

######Response:<br />
```json
[
    {
        "countryName": "France",
        "countryId": "46",
        "leagueName": "Ligue 2",
        "leagueId": "177",
        "teamName": "3033",
        "teamId": "Amiens",
        "overallLeaguePosition": "11"
    }
]
```


######localhost:8080/api/v1//football/standing?teamName=3033&countryName=France&leagueName=Ligue 2<br />

######Response:<br />
```json
[
    {
        "countryName": "France",
        "countryId": "46",
        "leagueName": "Ligue 2",
        "leagueId": "177",
        "teamName": "3033",
        "teamId": "Amiens",
        "overallLeaguePosition": "11"
    }
]
```
