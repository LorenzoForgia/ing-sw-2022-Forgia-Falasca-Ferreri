# Group 13 UML Review

## Appreciations

- Overall the structure is good, with a good usage of OOP principles.
- The use of design patterns is notable.
- Good use of utility classes such as `DeckCC` to setup games with expert rules.
- `Location` is a good idea to facilitate the movements of the students.
- The relations make the connections between classes clear.
- The presence of both the `Controller` and the `View` packages show good planning abilities.

## Suggestions

### General

- The purpose of setter methods is to let the class' attributes be editable from an extern class in a safe way, it is useless to have private setters.
- Although most methods' names are understandable, many of their functionalities remain unexplained since they have no parameters and return no value. Some examples are:
    - `UseEffect(): void`
    - `SetNumberCoin(): void`
    - `RemoveStudent(): void`
- The cardinalities show the number of elements inside each class, nonetheless, this is not enough to understand which data structure are being used (`List`, `Set`, `Map`, etc.).

## Coin

- We would suggest to delete this class and let it be just an integer inside `Player`.

## Deck

- The `Deck` class lacks information about the cards back type.

## Assistant

- `Assistant_Card` is an example of private setters misused: the constructor should not call the setters but should directly set these attributes itself.
- Moreover, we would recommend to use an `Enum` with final attributes to make the initialization of a `Deck` easier.

## Effect

- The Strategy Pattern is a good insight, however its implementation in this specific usecase might be a difficult process, since every character needs different parameters when used.