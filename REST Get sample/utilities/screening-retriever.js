const mongoose = require('mongoose');
const screening_schema = require('../schemas/screening_schema');
const config = require('../config');

class ScreeningRetriever{
    constructor(){
        mongoose.connect(config.url + config.database_name, {useNewUrlParser: true});
        this.screening_model = mongoose.model("Screening", screening_schema, config.collection_name);
    }

    fetchScreening(callback, urlArgs){

        // Use external argument-parser to handle special arguments.
        // For simple values only, JSON.parse(urlArgs) would also work
        let parsedArgs = this.parseArguments(urlArgs);
        
        console.log(parsedArgs);

        this.screening_model.find(parsedArgs, function (err, result){
            callback(result);
        });
    }

    parseArguments(urlArgs) {
        let queryKeys = Object.keys(urlArgs);

        // Let parsedArgs be a duplicate of urlArgs, such that string-values are passed trough without code needed.
        let parsedArgs = {
            ...urlArgs
        };

        // Parse numbers of date or views if in set.
        if (queryKeys.indexOf('date') >= 0) {
            parsedArgs['date'] = parseInt(urlArgs['date']);
        }

        // Handle views:
        // If either minViews or maxViews is given in URL (or both), we create a special object which mongoose filters
        // upon.

        if(queryKeys.indexOf('minViews') >= 0 || queryKeys.indexOf('maxViews') >= 0){
            // let X = statement ? X1 : X2 is shorthand to select one value based on a truth value.
            // it's equivalent to if(statement){X = X1} else{X = X2} 

            // Let minViews = provided value if provided, otherwise 0
            let minViews = (queryKeys.indexOf('minViews') >= 0) ? parseInt(urlArgs['minViews']) : 0;
            //Let maxViews = provided if provided, otherwise practically "infinite"
            let maxViews = (queryKeys.indexOf('maxViews') >= 0) ? parseInt(urlArgs['maxViews']) : Number.MAX_SAFE_INTEGER;

            // Remove parameters from parsedArgs
            delete parsedArgs['minViews'];
            delete parsedArgs['maxViews'];

            // Special filter object for mongoose: $gt means Greater Than and $lt means Less Than
            parsedArgs['views'] = {
                $gt: minViews,
                $lt: maxViews
            }
        }

        return parsedArgs;
    }

}

module.exports.ScreeningRetriever = ScreeningRetriever;