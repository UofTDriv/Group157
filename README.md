# CSC207 Final Project

## Group Members
* Hrunt Jokakelian: https://github.com/jermag-vochkhar
* Denis Divard: https://github.com/UofTDriv
* Zhe Wang: https://github.com/ZheWang7
* Scott Angelides: https://github.com/JustCookieDough


## TODOs by Fri 8 Nov
1. [ ] Use cases described and user interations identified - James
2. [ ] All the Views sketched - Denis
3. [ ] Entities decided - James
4. [ ] A first "team use case" implemented, tested, and pushed to repo - 
5. [ ] Be able to make calls to the API your team has chosen - 


## Project Blueprint
### Team Name: 
WSHD
### Domain: 
Graphing Wikipedia Rabbit Holes
### Software Specification:
A program that makes a graph of what you have seen as you search through Wikipedia. 
As you click links in existing articles to new articles it creates a new node for said article on the map.  
### Features to be implemented (User Stories)
1. [ ] Type in a subject and click on `Search`: the program will display the page 
and create a new node.
2. [ ] `Click` the links in the page: the program takes you to that page
3. [ ] `Add` a new node for that page, connecting it to the node from which you came. 
4. [ ] As you explore more pages you can see a list of past pages visited but the program also automatically `adds links` between nodes that were not originally connected by traversal.
5. [ ] `Save` and `Open` your research journeys at another time by saving your current journey to a human-readable file that can be imported. \

**(Complexity Requirements already satisfied. Additional Features to make the project outstanding)**

6. [ ] During your exploring there may be articles you have not clicked on but are linked to by more than 2 articles you have visited.
The program will create `Ghost Nodes` for these articles.
7. [ ] `Switch` the history between **graph** and **chronological list**
### Proposed API for the Domain
#### [MediaWiki Action API](https://www.mediawiki.org/wiki/API:Main_page)
* Allows us to easily interact with MediaWiki-based online resources like English Wikipedia.
* Pulling down the HTML of English Wikipedia for display using swing.
* Accessing the MediaWiki `pagelinks` database, which stores all of the links between Wikipedia articles.
* Abstracts away difficult to handle features of MediaWiki sites such as redirects or deprecated pages.
#### [Another API for graph (TBD)]()
(Add once determined)