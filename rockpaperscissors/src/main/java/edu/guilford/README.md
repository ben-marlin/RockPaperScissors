# Rock Paper Scissors

The objective in this project is to make a simple game. It accepts text input: one of rock, paper, or scissors. If the user types anything else, it should tell them their choice is invalid and prompt them to try again. 

The program should generate its own throw, and the throws should be compared. If you've never seen this before: same throw ties, rock beats scissors, scissors beats paper, paper beats rock. The program should report the results appropriately.

In accomplishing this, you will

- input a string from a `Scanner`
- convert to lower case letter with string methods
- use compound logic statements and negations
- assign values using an `if-else` structure 
- loop using `while` 

## Starting play

Write a print statement that lets the player know what game they're playing. Then write another print statement that lets them know they can only type one of rock, paper, or scissors. Create a `Scanner` object with a name like `myScan` (don't forget to import `java.util.Scanner`). Create a string named `play` and read it in with something like the following. Print it out to make sure this worked right.

```
    String response = myScan.nextLine();
    System.out.println(response);
```

Run this code to make sure it's doing what you expect.

Next, convert `response` into a string with all lower case letters. To make it simpler, let's just do it when doing the input.

```
    String response = myScan.nextLine();
    response = response.toLowerCase();
    System.out.println(response);
```

We do this so you don't have to consider rock, Rock, rOck, etc. Test this to make sure it's working the way you expect it to.

Notice that objects like strings frequently have built-in methods and we access them in the format `object.method(argument)`. The `toLowerCase()` method creates a new string with the obvious changes. If you'd like a list of such methods, Google "java String methods". We're going to take advantage of one more to make our logic easier.

```
    String response = myScan.nextLine();
    response = response.toLowerCase();
    char play = response.charAt(0);
    System.out.println(play);
```

The method `charAt(n)` is present for all strings, and it reads out the character at position `n`. In our case, we ask for position 0, which is the first position in the string. This reads out the first character and records it as a `char` - a primitive type that holds one letter. This makes a later step less painful!

## Validating Input

When testing the preceding, you probably tried something weird as input - users will do the same thing. But we're only interested in continuing if they input one of our three choices.

Create a `while` loop enclosing the input and output which repeats if `play` is not one of the choices. This necessitates that `play` exist before the loop begins.

```
        String response = "whatever";
        char play = 'w';

        while (play != 'r') {
            System.out.print("Type rock, paper, or scissors: ");
            response = scanner.nextLine();
            response = response.toLowerCase();
            play = response.charAt(0);
            System.out.println(play);
        }
```

Run this, making sure what happens when you type rock, Rock, and paper. The code `play != 'r'` will be `false` if you typed rock or Rock, but `true` if you typed paper. The symbol `!=` is read as "not equal to". This code will make you repeat input until you enter rock (or Rock or rOcK or something  that starts with `r`).

When this works, change the conditional to `((play != 'r') && (play != 'p'))`. The `&&` means "and". The condition will only be true if *both* conditions are true... which means that the `while` loop continues as long as the user types anything other than a word that starts with r or p (with possible case change). Run this to test every variation you can think of.

Now... figure out how to change this so that typing any one of rock, paper, or scissors will exit the `while` loop. Run it repeatedly to test variations. Then remove or comment out the line that prints.

## Generating the computer's throw

As we're working on this section, you don't want to have to input rock over & over, so highlight the code for the `while` block you just finished and use `Edit | Toggle Block Comment` or `Alt-Shift-A`. If you comment out all uses of a variable but not its declaration, the compiler may complain - it's trying to keep you from declaring unused variables. Leave the line that instantiates `myScan` uncommented. 

On the next lines, declare an integer named `choice` and a character named `comp`. Then instantiate a random number generator with a name like `rand`.

```
    Scanner scanner = new Scanner(System.in);
    int choice;
    char comp;
    Random rand = new Random();

    String response = "whatever";
    char play = 'w';

```

After the commented out `while` block, use `rand` to generate the integer `choice` from 1 to 3 and print it. Test this to make sure it will produce all three possibilities!

Now insert an `if` structure like the following.

```
        if (choice == 1) {
            comp = 'r';
        }
        
        if (choice == 2) {
            comp = 'p';
        }
        
        if (choice == 3) {
            comp = 's';
        } 

        System.out.println(comp);
```

Run this repeatedly to make sure it's doing what you expect. You should get an error that `comp` may have never been assigned. This is a limitation of computers! Although `choice` can only have one of three values and each case is handled, the compiler misses that. It may be that you can solve this problem using an `if-else` structure or a `switch` statement, but this code is simpler. To fix the error, return to the line where `comp` was declared and change it to this.

```
    char comp = '0`;
```

You may get a suggestion from VSCode to replace the chain of `if` statements with a `switch`. If you have the time, try this. But part of this lesson is to learn about `if` statements!

## Determining a winner

To minimize your testing, comment out the code where `comp` was randomly generated. Write a couple of lines of code assigning both `play` and `comp` to be 'r'.

```
    play = `r`;
    comp = `r`;

    System.out.println(play + "\t" + comp);
```

In general, we have three possibilities: the user won, the user lost, or there was a draw. We have to examine how each could happen, then design feedback. So make a string called `feedback`, which is initially the empty string.

## Feedback

We need to say what happened, so let's replace the print line so it says what was thrown. To do that, we'll use another `if` block and string concatenation.

```
    String feedback = "You threw ";

    if (play == 'r') {
        feedback += "rock.";
    }

    if (play == 'p') {
        feedback += "paper. ";
    }

    if (play == 's') {
        feedback += "scissors. ";
    }
```

Now add "Computer threw " and use a similar `if` sequence for `comp`. Then use `System.out.println(feedback)` to print the result. Run this and test it by changing various values of `play` and `comp`.

### Tie condition

This one is the easiest, so let's handle it first. If `play` and `comp` are equal, then the game was a draw. Let's reuse `feedbac` and an `if` statement like the following.

```
    feedback = "";

    if (comp == play) {
        feedback = "It's a draw!";
    }

    System.out.println(feedback);
```

Run this to make sure it does what you expect. Then change bot to `'p'` to make sure it's still a draw - similarly for `'s'`. Then change one and make sure it doesn't print anything. You may want to try other possibilities, but matching and different are the main two for now.

### Lose condition

This can happen for any possibility the user chose, but the right throw for the computer had to come up. So we'll use the `&&` to form a compound conditional before printing `feedback`. Before the final print of `feedback` insert an `if` block like this.

```
    if ((play == 'r') && (comp == 'p')) {
        feedback = "You lost!";
    }
```

Change your hardcoding for `play` and `comp` to make sure and test this combination. Then try another combination that isn't covered.

Next, we want to complete the condition, but this requires a more complex conditional. The symbol `||` means "or". If you have three conditions, `A`, `B`, and `C`, you'd write `(A || B || C)` to create a condition that is true if any of the three are true.

But each of these has to have two conditions, like `((play == 'r') && (comp == 'p'))`, to both be true. The result looks like this.

```
if (((play == `r`) && (comp == 'p')) || ((play == `p`) && (comp == 's')) || ((play == `s`) && (comp == 'r'))) {
    feedback = "You lost!";
}
```

Hardcode each of the three test conditions (i.e. set `play = 'r'` and `comp = 'p'`, etc.) and make sure they work. Then try a condition for draw to make sure it doesn't print both. Finally try a condition for a win to make sure it does neither of the other two.

### Win condition

Likewise, we know paper beats rock, rock beats scissors, and scissors beat paper. Starting with the first, insert this after the lose condition if block, but before the final print statement.

``` 
    if ((play == 'p') && (comp == 'r')) {
        feedback = "You won!";
    }
```

As before, test this with the hardcoded values for `play` and `comp`to make sure it works. Then expand to the other two possibilities. Finally,  test them to make sure you get the correct response for one of each.

## Putting it together

Now, comment out or remove your hardcoded values of `play` and `comp`. Uncomment the blocks that decided the values and run the code, testing to confirm that it does what you suspect. You may want to insert a print statement to make sure what values the variables have, then delete it afterwards. Run it repeatedly to make sure it does what you expect.

## Wrapping up

Go back through the code and comment what each block does. Make sure you have enough information that you will be able to understand it if you have to review it later.

This should do it! I know this one seemed pretty long. Go ahead and commit it, then send me a message that you're ready for me to grade it.