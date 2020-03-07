Branch Manager Address Book
===========================================

Description
-----------
As a Reece Branch Manager
I would like an address book application
So that I can keep track of my customer contacts

Acceptance Criteria
  - Address book will hold name and phone numbers of contact entries
  -	Users should be able to add new contact entries
  -	Users should be able to remove existing contact entries
  -	Users should be able to print all contacts in an address book
  -	Users should be able to maintain multiple address books
  -	Users should be able to print a unique set of all contacts across multiple address books
 
 A working user interface is not required, nor is the use of any frameworks. All acceptance criteria
should be covered by unit tests, with additional integration tests where appropriate. Tests will be
included in the assessment criteria, as will demonstration of other good coding practices like: clear
separation of concerns, clean code, standardised formatting, etc. Data should only be persisted in
memory, using simple data structures like Set, List, etc.

NOTE: Solution may be written in either Java or Kotlin
       
Project Structure
-----------------------------------------------

The project structure is created with Maven and follow the conventions. 

   
Reece-address-book (project root directory)

    -- src   (source code)
    
       -- java
          
          -- com.reece.addressbookapp
            -- addressbook    (addressbook module)
              -- action (addressbook action)
              -- exception 
              -- manager (addressbook app entry)
              -- model
            -- common    (common module)
              -- exception      
            -- contact    (contact module)
              -- exception
              -- model
    
    -- test  (unit tests)

       -- java
       
          -- com.reece.addressbookapp.addressbook.action.impl     (unit tests for AddressBookActionImplement classes)
          -- AddressBookManagerTest  (unit tests for AddressBookManager classes)
          -- AddressBookAppIntegrationTest  (AddressBookApp Integration Test classes)
          
    pom.xml           (the Maven pom file)
    
    README.md         (the project document file)
          


System Environment
-----------------------------------------------
* Java version: 1.8
* Apache Maven 3.5.0


Building
--------

To build, enter the project directory and type the following command:

    mvn clean install
    mvn test



Version Control
-------
Git is used for version control system.




Contact
-------
If need more information, please contact me at  songwang7701@gmail.com




