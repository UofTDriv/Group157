# CSC207 Final Project

## Group Members
* Hrunt Jokakelian: https://github.com/jermag-vochkhar
* Denis Rivard: https://github.com/UofTDriv
* Zhe Wang: https://github.com/ZheWang7
* Scott Angelides: https://github.com/JustCookieDough

## TODOs by Fri 8 Nov
1. [X] Use cases described and user interations identified - James
2. [X] All the Views sketched - Denis
3. [X] Entities decided - James

## TODOs by Sun 17 Nov
4. [ ] A first "team use case" implemented, tested, and pushed to repo - 
   * Controller, input data, interactor, output data, presenter, in memory database (if needed)
5. [ ] Be able to make calls to the API your team has chosen - 
6. [ ] Functioning view and view model


## Project Blueprint
### Team Name: 
WSHD
### Domain: 
Graphing Wikipedia Rabbit Holes
### Software Specification:
A program that makes a graph of what you have seen as you search through Wikipedia. 
As you click links in existing articles to new articles it creates a new node for said article on the map.  
### Features to be implemented (User Stories)
1. [X] Type in a subject and click on `Search`: the program will display the page and create a new node. (Team Use Case) 
2. [ ] Journey UseCase: Display the searched article as the root and be able to `Click` the links in the page: the program will display that page. (Denis)
3. [ ] The searched article is added as the root node to the Graph of your current journey, any new articles you `click` will be added and linked to the previous node. (Zhe Wang)
4. [ ] As you explore more pages you can see a list of past pages visited but the program also automatically `adds links` between nodes that were not originally connected by traversal. (Scott)
5. [ ] `Save` and `Open` your research journeys at another time by saving your current journey to a human-readable file that can be imported. (Hrunt)

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


## CA Structures of Use Cases
### Search
![image](images/search_ca.png)
1. When the user types in the subject in the textbox and click **Search**, the content in the textbox
will be passed to the `SearchController`.
2. The `SearchController` will wrap the input into a `SearchInputData` object,
which will be used by the `SearchInputBoundary` interface.

**(I'm not sure if the `SearchInputData` is necessary because the data is really just a String of the subject name.
I'll ask the TA on Monday)**

3. `SearchInteractor` implements the `SearchInputBoundary` interface, which calls the MediaWiki API.
to fetch the corresponding webpage. The fetched result will be stored in `Webpage`.
4. `SearchInteractor` then returns `SearchOutputBoundary`.
5. `SearchPresenter`, which implements the `SearchOutputBoundary` interface, will then update the `ViewModel`.
6. `ViewModel` fires the changes to display the webpage on the `View`.

### Add
The structure of the **Add** use case would be similar to that of **Search**.
The potential entities involved are `Node` (the node representing a webpage), and
`WikiHistory` (storing the Wikipedia Rabbit Hole).

### Save
![image](images/save_ca.png)

### Usage Guide

### License

Distributed under the Creative Commons Zero v1.0 Universal License. Project is dedicated to the world-wide public domain. The creators of the project (Hrunt Jokakelian, Denis Rivard, Zhe Wang, Scott Angelides) disclaim responsibility for obtaining any necessary consents, permissions or other rights required for any use of this project. See LICENSE for more information.

### Feedback

Curious on giving feedback and or giving suggestions on how to improve the project? Send in a response to the following google form:
https://forms.gle/M7uPDBEbZgMDvskc7

What counts as valid feedback?
- Written in English only
- Should be aligned with project goals (i.e. the purpose of the project)
- Provide actionalable suggestions (NOT vague or abstract critiques)

Guidelines for what to expect when writing feedback?
- Be clear and specific
- Be professional and respectful
- Aim for constructiveness (don't be overly critical)

### Contributions

How can users contribute to the project?
Users can contribute in two ways:
- Providing feedback via actionalable suggestions (as previously mentioned under 'Feedback')
- Adding further use cases to the project
     - NOTE: that this does not allow the mutation of already existing use cases

How can users make a fork of this repo?
 1. Navigate to the home page of the repository
 2. In the top right of the page, click on 'Fork'
 3. Leave the 'Owner' selection as is. Change 'Repository Name' to the following format: {github username}_{fork number}, where 'fork number' specifies whether this is the first, second, third etc. fork you've made of this repo.
 4. Adding a description is not necessary
 5. Ensure that 'Copy the main branch only' is selected
 6. Click on 'Create fork'

Guidlines for creating a good merge request.
1. Write clear commit messages
2. Ensure code quality (Follow some kind of linter e.g SolarLint)
3. Appropriately use branching (i.e. create a branch when implementing a distinct feature or use case)
4. Ensure that the merge quest description is thorough
     - What does the merge request do?
     - Why are the changes necessary?
     - How were the changes implemented
5. Provide evidence of successful testing (i.e. screenshots for changes to the UI) and adequate test coverage from provided test suite (at least 90% code coverage for core logic)

Protocols for reviewing and merging contributions.
1. Automatic testing: automatic tests will be run to ensure that code in the merge request is correct and compatible with the current codebase.
2. Review. A review will be selected to review your merge request. Expect merge requests to be completed between 2 and 5 business days. Reviewers will take into consderation the aformentioned criteria/guidlines for a good merge request. 
4. Feedback. The reviewer will provide any necessary feedback regarding the request (NOTE: any merge requests NOT following these guidelines will be ignored and DELETED)
5. Approval mechanism. An additional reviewer may be called for a second opinion before merging.


### 
