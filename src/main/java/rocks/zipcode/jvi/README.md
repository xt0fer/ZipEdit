# jvi

jvi is a simple text editor based on the famous article : 
[Build Your Own Text Editor](https://viewsourcecode.org/snaptoken/kilo/index.html)
And also
[Designing And Writing Vim From Scratch In 3 Weeks](https://medium.com/@dwang.me/designing-and-writing-vim-from-scratch-in-3-weeks-871f8283ce2f)

Only this one is a re-write in Java. Used as the basis for a "add features to" lab of Zip Code Wilmington.

## vm notes

Vm is a Vim-like text editor that was built from scratch in Java.

In this lab we will talk about the overall design of our program, and the object-oriented programming 
concepts and design patterns we use as we build this project.

## A Brief History on Vim

Vi was the original screen oriented text editor created for the Unix operating system, 
written by Bill Joy in 1976.

Vim (Vi IMproved) is a greatly improved clone of Vi written by Bram Moolenaar released in 1991. 
It has since then become one of the world’s most popular text editors, coming in at the 
top 4 for most popular development environments in 2017’s Stack Overflow developer survey.

Three big areas:

- Software Design
- Design Patterns
- Data Structures For Text

## Design Principles

### SOLID

The term SOLID is a mnemonic acronym for five design principles intended to make software designs 
more understandable, flexible and maintainable.

Single Responsibility: All of our classes have single responsibility of doing one task except for 
Controller. If you can’t easily say a class does x, then think about breaking it up into smaller parts.

Open/Closed Principle: Software should be open for extension, but closed for modification. 
Does a change in the project specification result in you changing much of the interface of your class, 
or does it just mean you need to extend your existing class?

The View class is open for extension and closed for modification. We wanted to create an additional 
view that would display certain values, cursor positions, and the command stack, so instead of 
adding that optional functionality in View, we created a subclass DebugView that contained the functionality we wanted. All member variables of all classes are private to that class and we have getters and setters only when needed.

Liskov Substitution: Is your code still correct if you replace an object of type A with and object 
of type B, if B is a subclass of A? Does substituting for a higher level (more general/abstract) 
of class break anything? It shouldn’t. And you use that fact to your advantage to write great code.

We used Liskov substitution mainly in two parts: Commands and Views. For any subtype of command, 
replacing one with another will not cause the program to crash or produce undefined behaviour 
(other than the fact that the command is executing a different series of actions). It can be safely 
assumed that calling `canUndo`, `execute`, and `undo` on any subtype of `Command` will work.

Interface Segregation: Many small interfaces is better than one large interface. 
If a class has many functionalities, each client of the class should only see the functionality it needs.

Most interfaces only needed to serve a single client in our project, so there was no need to 
make a more specific interface for each client. But this is a good general rule!

Dependency Inversion: High level modules should not depend on low-level modules. Both should 
depend on abstraction. Abstract classes should never depend on concrete classes.

All fully abstract classes we had (Command.h) did not inherit from or depend on a concrete 
class. All classes interacted and depended on other classes of the same level of abstraction. 
For example, the View class depends/interacts on other high-level classes like `Highlighter` and `Cursor`, 
rather than their lower level subclasses or underlying data structures such as `CppHighlighter` or `ViewCursor`.


Model-View-Controller
As part of the single responsibility principle, we created three classes that each handle a 
single aspect of Vm with respect to an application that interacts with a user.

Model: Application.java

The Application class is responsible for storing the state of the current instance through MODEs 
and directs the controller to act accordingly.

View: View.java
The View class is responsible for outputting the buffer contents or any output to the screen 
and syntax highlighting.

Controller: Controller.java

The Controller class handles each input depending on the current MODE of the editor and 
makes changes to the View via the ViewCursor and/or the Buffer classes.

-Wikipedia

## Design Patterns
The general principles of SOLID paid off well, since we didn’t run into many situations 
where we didn’t know what type of design path we should take. We didn’t use many design 
patterns as we thought, and I don’t think that is a bad thing. You should never be trying to 
fit in a neat design pattern for the sake of using it. One pattern that actually saved our 
butts was the Command pattern, which seems pretty intuitive actually.

## Design Pattern-ism

We used the Command Pattern to handle the undo function. 
Vm commands were encapsulated in many command classes (concrete subclass) 
that include 2 major methods (execute and undo). These were then stored in a 
Command (abstract superclass) stack. 
When the undo command is executed, it calls the undo method of the top element of the command stack, 
and then it is popped off. Calling execute would actually do a command. 
The downside of this pattern is that you need to build a lot of subclasses for 
each individual function, which doesn’t feel like good object-oriented programming. 
But it will make your undo function as easy as

```java
if (!_app.commandStack().empty() && _app.commandStack().top().canUndo()) {
  _app.commandStack().top()->undo();
  _app.commandStack().pop();
}
```

### Data Structures For Text

A lot of thought went into deciding which data structure we should use to hold and 
manipulate the text of our files. Which ones would prove to be the fastest, 
the most memory efficient, the clearest to code? These were all really fun to consider. 
BUT, no. 
SO, we ended up using a arraylist of strings.






--kyounger, Apr 2023.
