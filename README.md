## CRaC Name service
This is a little demo name service. It will lazy load around 280000 names from a json
file into memory the first time you call it. That means the first time you call the service
it will take a bit longer to get the response because it will first load the files into memory.
Keep in mind that this is only to demonstrate CRaC, usually you won't do lazy loading at the
first call. The service will return a json reponse with the names and it will also give you 
the time it took to return the response.
Starting it without CRaC will show that the first call takes longer. When using CRaC, the
service will be warmed up before the checkpoint will be created.
In the Micronaut CRaC module you can define a specific warmup script which will be called to
warm up the service. In this case it will simply curl the service to make sure it is warmed up.
After the script ran, a checkpoint will be created and will be stored in the docker image.
With the checkpoint in the docker image the service will start up and it will be already
warmed up which means the first time to response will be fast because the names already
have been loaded.


Start the application with 
```./gradlew run```

Open a browser and type in
```http://localhost:8080/names?gender=female&amount=10```

You should see 10 random female names in JSON format in your browser and also the
time it took to create the response.


### Run without CRaC
Execute ```./gradlew run```

Execute ```curl "localhost:8080/names?gender=female&amount=5"```

The result should show something like this for the first response without CRaC:
```json
{
  "names":[
    {
      "first_name":"Birtha",
      "gender":"female"
    },
    {
      "first_name":"Dorothea",
      "gender":"female"
    },
    {
      "first_name":"Eva",
      "gender":"female"
    },
    {
      "first_name":"Lynnette",
      "gender":"female"
    },
    {
      "first_name":"Missy",
      "gender":"female"
    }
  ],
  "response_time":"931 ms"
}
```

This is for the first response only and you see that the response time in this case was 931 ms.


### Run with CRaC

#### Build docker image
Execute ```./gradlew dockerBuildCrac``` to create a docker image containing a CRaC
enabled JDK and a pre-warmed, checkpointed application.

Execute ```bash start.sh```

Execute ```curl "localhost:8080/names?gender=female&amount=5"```

The result should show something like this for the first response with CRaC:
```json
{
  "names":[
    {
      "first_name":"Berta",
      "gender":"female"
    },
    {
      "first_name":"Doris",
      "gender":"female"
    },
    {
      "first_name":"Emma",
      "gender":"female"
    },
    {
      "first_name":"Lisa",
      "gender":"female"
    },
    {
      "first_name":"Melanie",
      "gender":"female"
    }
  ],
  "response_time":"21 ms"
}
```

This is for the first response only and you see that the response time in this case was 21 ms,
which is way faster because the application was already "warmed up". Here the warm up
is mainly loading the names from the json file into memory.
