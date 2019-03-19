# Running the REST API

The backend uses a MongoDB database, and runs a express.js server on Nodejs. 
It's a simple database with some pseudo-data from a streaming platform.

This API was made entirely by me in around 3-4 hours. It's based on previous work from projects, however 
I was also the author in those projects. 

## Prerequisites: 
 - Mongodb available here: 
    - https://docs.mongodb.com/manual/administration/install-community/ 
      NOTE: To use the previously generated database, download the file from here (available soon), and start the db as follows:
  - ``` mongod --dbpath <path to database file>  ``` 
  - Nodejs and NPM:
    - Windows or Mac: https://nodejs.org/en/download/ 
    - Linux Terminal: https://nodejs.org/en/download/package-manager/ 
      - Ubuntu: 
        - ``` curl -sL https://deb.nodesource.com/setup_10.x | sudo bash - ``` 
         ``` sudo apt install nodejs ``` 
    - Confirm installation in terminal with:
      - ` node -v `
      - ` npm -v ` 

## Running 

1. Open terminal in folder “REST Get sample”
   1. Protip for Windows: Find folder in explorer and type “CMD” in address bar
2. Launch database if not running 
   1. ` mongod --dbpath <path-to-db>  ` 
      1. simply `mongod` may work, but if it gets a permission-denied error, either run as adminitrator (sudo in linux) or use --dbpath select a non-restricted folder. 
   2. (Optional) To monitor database: `mongo` in terminal
3. Execute the following in a terminal in the mock-api folder:
   1.  ` npm install ` 
   2.  ` node ./utilities/initialize-db.js`
       1.  Note: This is only to write data to Database. Only needs to run once. 
   3.  ` npm start ` 
      1.  Note: The server may fail if the database is not running, or port 3000 is busy.  
4. NOTE: Closing the terminal also stops the server. It also be quit using ctrl + c 
   To send requests, go to “localhost:3000” in browser, or use something else to send http-requests. 


# REST API Definition 

## Download functions

### localhost:3000/screenings/

Returns a JSON of screenings. 

Using ? allows paramteres to be added to query. Example: http://localhost:3000/screenings/?seriesId=innafor 

Below the possible arguments are listed, followed by some sample links

``` txt
seriesId: String id in lowercase to identify show
screen: Type of screen
date: Date of screening in format yyyymmdd 
minViews: Minimum number of views
maxViews: Maximum number of views

```

**Sample links:**

- Screenings of "friends" at january 12th 2018:

  - http://localhost:3000/screenings/?seriesId=friends&date=20180112

- Any screening with more than 50.000 views: 

  - http://localhost:3000/screenings/?minViews=50000

- Any screening with less than 10 views: 

  - http://localhost:3000/screenings/?maxViews=10

- Any desktop screening with less than views:

  - http://localhost:3000/screenings/?maxViews=10&screen=desktop

- The desktop screening of The Office at September 23rd

  - http://localhost:3000/screenings/?seriesId=the-office&screen=desktop&date=20180923

# What could be added 
This only uses one out of four REST methods; GET. 
A complete REST API would include: 
    - POST: Insert data 
    - PUT: Update data 
    - DELETE: Remove data 
 
 Furthermore it would need much more sanitation of input and security in general, and better error-handling. 
 
 In doing async calls, the async-await method (which in many cases except here is cleaner) is also not demontrated. 
 This method, instead of using a callback (multi-threaded), halts the exection of the current code until a value is returned
 (promised is resolved). This would similar to: 
 ```{js}
async getDelayedValue(){
    return new Promise({
        'resolve': {
            let value = await fetch('http://url-to-value'); // value = "Text"
            return value;  
        }
        'error': {
            throw error; 
        }
    }
}

async main(){
    let x = await getDelayedValue(); 
    console.log(x); // "Text"
    
    // Without await: 
    let x = getDelayedValue(); 
    console.log(x); // Undefined (because this line executed before promise was resolved)
}
```
 
 
 Lastly logic should be expanded. Firstly, it should cast integers to date-objects and translate to unix-time or similar. 
 Also, when retrieving data, it should do more aggregations and grouping such that the data provided is more meaningful. 
 