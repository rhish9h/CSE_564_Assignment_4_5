# Basic clone of Astah

## Tool to create class diagrams using Java Swing, which also uses multiple java design patterns

The tool contains 2 panels - left panel for code and right panel for class diagrams.

### Right class diagram panel:

Click anywhere in the right class diagram panel and enter class name to create a class. 
Any number of classes can be created.

Click on one class and then click on another to create a connection between the two classes. 
A popup will show to choose between the type of connections:
- Association [Arrow] (object within a method)
- Composition [Diamond] (class attribute)
- Inheritance [Triangle] (extension)

Class creation will also generate code in the left code panel.

### Left code panel:

The classes from the right panel will auto generate code in the left panel.

Moreover, user can write code (not actual Java code, but the pseudo code that is similar to the auto generated code),
after pressing the Generate Diagram button, the class diagram will be generated in the right panel based on the code 
written if it follows the auto generated pseudo code syntax.

Required pseudo code syntax example:

```
class MyClass extends FirstParent, SecondParent { // yes, it allows multiple inheritance
    FirstComposition
    SecondComposition
    method() { // take care of spacing
        FirstAssociation
        SecondAssociation
    }
}
```

### Architecture Patterns used:

- MVC (Model-View-Controller)
- Blackboard

### Java Design Patterns used:

- Singleton
  - Class: StatusBar
  - Class: ClassSource
- Observer
  - Class: ClassSource -> Observable.
  - Class: ClassPanel -> Observer. 
  - Class: CodePanel -> Observer.
- Decorator
  - Abstract Class: Connection 
  - Concrete Class: Line 
  - Decorator Abstract Class: LineDecorator 
  - Decorator Concrete Class: Triangle 
  - Decorator Concrete Class: Diamond 
  - Decorator Concrete Class: Arrow
- Chain of Responsibility
  - 1
    - Interface: DrawConnection 
    - Class: DrawLine (Successor: DrawDiamond) 
    - Class: DrawDiamond (Successor: DrawArrow) 
    - Class: DrawArrow (Successor: DrawTriangle) 
    - Class: DrawTriangle
  - 2
    - Interface: RelationLoadHandler 
    - Class: LoadHandlerArrow (Successor: LoadHandlerTriangle) 
    - Class: LoadHandlerTriangle (Successor: LoadHandlerDiamond) 
    - Class: LoadHandlerDiamond
- Strategy
  - Interface: Encoder 
  - Concrete Class: ClassBoxEncoder 
  - Concrete Class: ConnectionEncoder
