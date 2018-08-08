
There are 2 RESTful web services exposed :
http://localhost:8080/parents
http://localhost:8080/parents/{id}

mvn clean test  will execute 3 testcases. 
testCreateParentWithoutChild
testCreateParentWithOneChild
testRetriveParent

Below is the example of Response from the REST wevservice:

{
   "id": "1",
   "title": "Mrs",
   "firstName": "Jane",
   "lastName": "Doe",
   "emailAddress": "jane.doe@gohenry.co.uk",
   "dateOfBirth": "1990-06-03",
   "gender": "female",
   "secondName": "",
   "children": [   {
      "id": "1",
      "title": null,
      "firstName": "Janet",
      "lastName": "Doe",
      "emailAddress": "janet.doe@gohenry.co.uk",
      "dateOfBirth": "2010-05-22",
      "gender": "female",
      "secondName": ""
   }]
}
