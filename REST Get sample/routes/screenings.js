const express = require('express');
const router = express.Router();
const ScreeningRetriever = require('../utilities/screening-retriever');

const screeningRetriever = new ScreeningRetriever.ScreeningRetriever();
/* GET JSON values */

// Assign function to URL:
router.get('/', function(req, res, next) {
    screeningRetriever.fetchScreening((a) => res.json(a), req.query);
});

module.exports = router;
