# Spring Boot With GraphQ

* Why it called us alternative of rest api. So graphql is nothing. It's just a query language through which we can get our desired required fields. So what graphical say describe your data This is the typescript and ask for what you want, which field you want, as part of response, that just pass in this request format and get. predictable result. A query language for api. Here it is in request. It is giving tagline. So that is why it is giving the response only tagline, not other fields OK so let me show you one example.

* This is one movie api so here I did title and actor actors. This is one array So these are the field is there. They're giving us what a request and response specific to these fields only. So let's run it OK, you can see here IDT title actors it is giving suppose I want only actors. Show run it, it will give only actors ok. Similar suppose I want only idea and title, and I don't want actor So it will give only idea and title So that's why people are using graph ql to get the desired output. Whichever field you want as part of response, just specify those while sending the request post request. Only those filled data will be populated So I have prepared a blog on it. I will share this link in my video description section. And this graph queue was invented by Facebook on 2012. And it, it will be supported by multiple technology net Groovy javascript, php, python scala, ok, And this is some dummy example I did here with some explanation. So let's do a small piece on that so that I will explain how we will implement the graph QL and I will get our required field as part of response. So let's create a Spring boot application.
* Object will contains the 80 fields. OK, but I don't want to use those 80 fields. I only want to fetch only 23 fields only name and mobile OR ID and address like this. I want to face we can do it using our plain Java application without using graph QL. So for that we need to write the DTO class and we need to bind the data. We need to face from database and we need to iterate and we need to add 1 by 1 object. This data. roughing concept we need to write manually. So whenever this graph QL providing these features you want only IDM name mention this 2 field as part of request I will give only these two response to you. So this is. so this is the advantages of graph fuel will now we will write the typescript to enable the graph pair and we will write some logic you need to pass that type script and we need to runtime wiring we need to do to apply the graph query so that we will do now. So let us write the typescript first