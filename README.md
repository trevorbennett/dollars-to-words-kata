# dollars-to-words-kata
A short code kata that converts dollar values to words

http://codingdojo.org/kata/NumbersInWords/


### Retrospective

What would I do with more time?

* I would build the corresponding converter from text to the value for the dollar box on the cheque

* I would likely pull the interpreter out into it's own class, and clean up the interpretation strategy a bit, as there is a bit of duplicate code that could be simplified.

* I would come up with a solution for N digit dollar amounts. While a trillion dollars is probably a sufficient stopping point for this project, I know there are libraries that can be leveraged for arbitrarily large indicies.

* Handling of empty and invalid inputs is something that would be pretty valuable to this project. Were it launched as a service that would take top priority
