const mongoose = require("mongoose");

const Schema = mongoose.Schema;

module.exports.screening_schema = new Schema({
    "seriesId": String,
    "date": Number,
    "screen": String,
    "views": Number
});