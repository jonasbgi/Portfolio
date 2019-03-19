const data = require('../data/seertall');

const MongoClient = require('mongodb').MongoClient;
const config = require('../config.json');

// Connection URL etc
const url = config.url;
const db_name = config.database_name;
const collection = config.collection_name;


 async function initialize_db () {
    let client = await MongoClient.connect(url, { useNewUrlParser: true });
     let db = client.db(db_name);

     db.collection(collection).insertMany(data, function(err, res) {
         if (err) throw err;
         console.log("Number of documents inserted into " + collection + ": " + res.insertedCount);
         client.close();
     });
};

initialize_db();
