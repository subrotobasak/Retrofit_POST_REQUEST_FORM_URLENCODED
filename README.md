# Retrofit_POST_REQUEST_FORM_URLENCODED
Retrofit POST REQUEST and FORM URLENCODED 

For this we use the @POST annotation in our interface, define the relative URL endpoint and pass the object that we want to send to the server as an argument that we annotate with @Body. The GSON converter will then serialize this object into the JSON format before it is uploaded to the server.
