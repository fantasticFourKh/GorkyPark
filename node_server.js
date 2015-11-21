var Hapi = require("hapi");

var server = new Hapi.Server({});

server.connection({
    port: "3000"/*port*/,
    host: "localhost"/*host*/
});


server.start(function () {
    console.log("Server started at: " + server.info.uri);
    initialize();
});