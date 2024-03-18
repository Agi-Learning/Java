# SpringBoot ElasticSearch using Spring Data | Java Techie

## What is it?

* ElasticSearch is a search engine based on the Lucene library.
* It provides a distributed full-text search engine with an HTTP web interface.
* It is schema-free JSON documents.
* ElasticSearch is developed in Java and is released as open source under the terms of the Apache License

## Why we need it?

* ElasticSearch is able to achieve fast search responses because, instead of searching the text directly, it searches an index.
* For example,
* Ajay Maya bunch of file, and I want to face those fine queretplace mentioned as Dubai. Ok. So if you will go through the traditional approach, what we are doing in traditional approach, we are searching every word of every file, and where. we are finding the content to buy. We are just returning that file So, but in case of elastic search, as it is the inverted index, it will first retrieving the page from a file related to a specific keyword. First, it will scan the keyword where it mentioned Dubai. Then it will retract that specific page. It would not load entire page, and it will not perform the fully iteration, fully text search. That is what the advantages of elastic search, ok?
* So these type index called and inverted index, Because it inverts a peccentric data to a keyword centric data structure. It means we are not going to the each page, and we are not searching each word paste down a word. We are going to that specific page and we are retrieving that. So there is few key component of elastic search, which

### Components of elastic-Search?

1. Index: An index consists of ane or more Documents
2. Document: Document consists of one or more Fields
3. Shards: spilt up indices horizontally into pieces called shards (It means one index can have multiple document if the load is more in a specific index that we can split into multiple shares. Ok? )
4. Replica: One or More copy of index.

### How Elasticsearch represents data?

Take Picture

* Inside sets you have the multiple documents. Ok so index split into multiple shares and one chair scanner multiple documents. And one document scanner multiple field. So here 1234 right? So now let us understand the internal flow of elastic surge So here is my inter Melfoo architect.

### Flow Architecture

* Chuck, this is the query. I want to find a person with maths with the job. So we provide the query to our api. And api goes to the index. You can observe here 1 index can have multiple shared I already mentioned. So as per this image, there is 4 sat and And wherever it will bind the match object, it will give us a response with the details from which sets it found and the time to and the sort and index everything it will give as a response, ok? So few installation process we need to follow here. So this is the link where you can download the elastics or binary distribution. So I downloaded 6.5 .1. This is the latest version. Once you download, just extract that cheap. So already I download and I extracted that So you can observe here is my. Elastic search, binary distribution. We have the beam config data, leap and locks. Now let us move to the config folder. There is a Oml file called Elasticsoft Yml. There you need to change the cluster name and the path data where exactly you want to Get all the index and node related stuff ok, then at the end go to the bin folder and there is a back file that is the elastic sorted band and run that band to half hour elastic search. solver ok Let's go to the config folder and let's do the configuration changes.

# Spring Data ElasticSearch using QueryDSL | Java Techie

* Power how to use spring data elastic search with Curry Dsl. So query dsl means it will internally helps us to convert our complex query to JSON format. So that is what we can perform the custom full text search operation using elastic search. So let us do that with example.
