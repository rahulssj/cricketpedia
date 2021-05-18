Problem statement:

At Cricketpedia, the marketing department often finds itself using long URLs with UTM tracking. These URLs often travel in emails, getting copied over sheets and docs, thereby are at risk of getting ruined by formatters. Objective is to design and implement a URL hashing system that would allow us to overcome these problems primarily. Things to keep in mind: URL length can't be restricted. Query parameters can’t be ignored. Click tracking should be there but hashed URLs can be made privacy aware. 
May be used in a secure manner as the generated URL might be single (limited) use only. You can choose to make the application with UI or only API.


Solution : API which uses Postman and Springboot

############################################

Requirements:

1.)Eclipse
2.)Redis server
3.)Postman
4.)jdk latest version

###################################################

How to run the application:

1)Import the project into eclipse as maven project.
2)run the redis Server
3)run the ApplicationDemo.java as java application
4)run postman and put get and post request to see results
5)for shortening use post request and put url in body which you want to shorten. 


#####################################
for example Post request: url: http://localhost:8080//cricketpedia/short/ and body:http://www.cricketpedia.com?utm_source=facebook&utm_medium=paid_social&utm_campaign=summer_sale&utm_term=social_media&utm_content=video_ad

for get use the shorten link get by post request

GET example:http://localhost:8080//cricketpedia/ef8c7056
										
#######################################


THANK YOU!!!