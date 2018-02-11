# Briefing
## You're in the army now

At ease, private!

So you're the soldier who's programming the Java application that will help us manage the composition of our armies? 
I hope you know what you're doing, because this piece of software will contain a lot of sensitive information once it launches.
Our enemies know this too, so they'll be trying their damnedest to gain access to it illegitimately. 
It's your job to prevent that rom happening at all cost. The lives of a lot of good men depend on it!

Sarge McKnowitall told me the UI is already as secure as - and I quote - "a six foot foxhole". 
The Sarge isn't generous with his compliments, so you shoud feel honored, son!
However, your good work on the UI only upped our expectations of your work on the even more crucial backend code.

So get back to work and make your country proud, private! Oorah!

-- General Bradbury Cumberton III

## Some tactical notes

Next up are the stories you will be developing that will help you learn about securing modern Java applications.
- Start by forking the [switchfully-security repository](https://github.com/nielsjani/switchfully-security). 
- Then pull the code from your branched repository to your local machine.
- Finally, to build the code for the first time, call 'mvnw.cmd clean install' from your command line

Each story has a 'starting point', a Git branch that has the minimum code setup for you to start the story without too much hassle.
This can come in handy because some stories build on top of eachother. 
You don't have to switch to these branches every time you start a new story, but if you don't feel certain about your own code it might be safer to start from a branch.
 
Each story will have some test already implemented (found under src/test/java/@name of the story@/@name of the story@Test.java).
However, we do expect you to write some additional (Unit) tests where you see fit.

Also, a REST-client such as [Postman](https://www.getpostman.com/) or [ARC](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo) might come in handy for some manual testing.

#(War) Stories
## Operation Avocado (starting point: [master](https://github.com/nielsjani/switchfully-security))

You're given a very basic Spring Boot application with a couple of REST-calls (see ArmyResource).
This app has an imaginary UI, but it is not relevant for these exercises. 
What you will be doing is securing the REST-calls in a number of ways using Spring's security features. 

Your first task is to make sure not just anyone can call the REST-API. 
We only want people using a Basic authentication header AND whose username and password combination are known to the system to be able to do REST-calls.

Getting started:
- Read [this](http://www.devglan.com/spring-security/spring-boot-security-rest-basic-authentication) article
- You can use an inMemoryAuthentication implementation for now to store your users and their passwords.
 This is not an advisable solution for real life applications, because there is no way for you to easily change/add/remove your users when the app is running.
 We will be switching to an LDAP in later exercises.
- The inMemoryAuthentication will have to hold a user called 'JMILLER' with password 'THANKS' in order for the AvocadoTest to pass.

Extra assignment:
- AvocadoTest currently only tests the 'getDeployedArmyInfo' REST-call. Write similar tests for the other 3 REST-calls

## Operation Baobab

## Operation Cedar

## Operation Dogwood

# Extraction Point

Congratulations, [a winner is you](http://i0.kym-cdn.com/photos/images/facebook/000/048/783/a_winner_is_you20110724-22047-1nd3wif.jpg)!
You've completed all stories and made the lives of your fellow countrymen a little safer. 
See any of your fellow students struggling? 
Try giving them a helping hand (don't just mail them your code, nobody learns anything from blindly copy-pasting text from one app to another).

