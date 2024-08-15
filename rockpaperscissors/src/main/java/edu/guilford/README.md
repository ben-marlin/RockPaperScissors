# Rock Paper Scissors

The objective in this project is to make a simple game. It accepts text input: one of rock, paper, or scissors. If the user types anything else, it should tell them their choice is invalid and prompt them to try again. 

The program should generate its own throw, and the throws should be compared. If you've never seen this before: same throw ties, rock beats scissors, scissors beats paper, paper beats rock. The program should report the results appropriately.

In accomplishing this, you will

- input a string from a `Scanner`
- convert to lower case with string methods
- compare to a literal using string methods
- use compound logic statements and negations
- assign values using a `switch` statement 
- loop using `while` 

## Starting play

Write a print statement that lets the player know what game they're playing. Then write another print statement that lets them know they can only type one of rock, paper, or scissors. Create a `Scanner` object with a name like `myScan` (don't forget to import `java.util.Scanner`). Create a string named `play` and read it in with something like the following. Print it out to make sure this worked right.

```
    String play = myScan.nextLine();
    System.out.println(play);
```

Run this code to make sure it's doing what you expect.

Next, convert `play` into a string with all lower case letters. You can do this with code like the following. Put it between the input statement and the output so you can check whether it worked.

```
    play = play.toLowerCase();
```

We do this so you don't have to consider rock, Rock, rOck, etc.

You could store this in a new variable if you want, but this demonstrates how you can write over an old value. Notice that objects like strings frequently have built-in methods and we access them in the format `object.method(argument)`. The `toLowerCase()` method creates a new string with the obvious changes. If you'd like a list of such methods, Google "java String methods".

## Validating Input

When testing the preceding, you probably tried something weird as input - users will do the same thing. But we're only interested in continuing if they input one of our three choices.

Create a `while` loop enclosing the input and output which repeats if `play` is not one of the choices. This necessitates that `play` exist before the loop begins.

```
        String play = new String("blah");

        while (!play.equals("rock")) {
            System.out.print("Type rock, paper, or scissors: ");
            play = myScan.nextLine();
            play = play.toLowerCase();
            System.out.println(play);
        }
```

Run this, making sure what happens when you type rock, Rock, and paper. The code `play.equals("rock")` returns `true` if you typed rock or Rock, but `false` if you typed paper. The "bang" character preceding it reverses these. This code will make you repeat input until you enter rock (or Rock or rOcK or something like that).

When this works, change the conditional to `(!play.equals("rock") && !play.equals("paper"))`. The `&&` means "and". The condition will only be true if *both* conditions are true... which means that the `while` loop continues as long as the user types anything other than rock or paper (with possible case change). Run this to test every variation you can think of.

Now... figure out how to change this so that typing any one of rock, paper, or scissors will exit the `while` loop. Run it repeatedly to test variations. Then remove the line that prints `play`.

## Generating the computer's throw

As we're working on this section, you don't want to have to input rock over & over, so highlight the code you just finished and use `Edit | Toggle Block Comment` or `Alt-Shift-A`. If you comment out all uses of a variable but not its declaration, the compiler may complain.

Create a random number generator and use it to generate an integer from 1 to 3 named `choice` and print it. Test this to make sure it will produce all three possibilities.

Now insert a `switch` statement like the following.

```
        switch (choice) {
            case 1: 
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("three");
        }    
```

Run this repeatedly to make sure it's doing what you expect. As you'll deduce, `switch (variable)` will look at all the cases to see if the variable is one of those possibilities. If it is, then it does the code block that follows the case. `break` throws it out of the switch block. If none of the cases fit, then it executes the code block labeled `default`. If you forget a `break` statement, then the `default` gets executed, even if it shouldn't. In thise case, since `choice` can only be 1, 2, or 3, then after 1 and 2 are handled, 3 is the only possibility and gets handled in `default`.

Now, before the `switch` statement, insert a declaration of a `String` named `comp`. Give it a value of `new String("")` - this is called the "empty string".

Then edit each code block so `comp` is assigned "rock" when `choice` is 1, "paper" for 2, and "scissors" for 3. After the `switch` block, add a print statement to check the value of `comp`. Run this repeatedly to confirm you can get all three possibilities. Afterwards, remove the print statement that printed the integer `choice`.

## Determining a winner

To minimize your testing, comment out the code where `comp` was randomly generated. Write a couple of lines of code assigning both `play` and `comp` to be "rock".

In general, we have three possibilities: the user won, the user lost, or there was a draw. We have to examine how each could happen, then design feedback. So make a string called `feedback`, which is initially the empty string.

### Tie condition

This one is the easiest, so let's handle it first. If `play` and `comp` are equal, then neither player won or lost. Use an `if` statement like the following.

```
    if (comp.equals(play)) {
        feedback = "It's a draw!";
    }

    System.out.println("You: " + play + "\t Computer: " + comp);
    System.out.println(feedback);
```

Run this to make sure it does what you expect. Then change `comp` to "paper" and make sure it doesn't print anything. You may want to try other possibilities, but these are the main two for now.

Notice that there is no way for a draw to happen if these are not equal, nor any way for anything else to happen if they are. We don't have to use a complex `if-else` structure as these three conditions are "disjoint" - we can use three `if` blocks.

### Lose condition

This can happen for any possibility the user chose, but the right throw for the program had to come up. So we'll use the `&&` to form a compound conditional before printing `feedback`.

```
    if (play.equals("rock") && comp.equals("paper")) {
        feedback = "You lost!";
    }
```

Change your hardcoding for `play` and `comp` to make sure this works and test it. Then make it not work and test it.

Next, we want to complete the condition, but this requires a more complex conditional. The symbol `||` means "or". If you have three conditions, `A`, `B`, and `C`, you'd write `(A || B || C)` to create a condition that is true if any of the three are true.

But each of these has to have two conditions, like `(play.equals("rock") && comp.equals("paper")`, to both be true. The result looks like this.

```
if ((play.equals("rock") && comp.equals("paper")) || (play.equals("paper") && comp.equals("scissors")) || (play.equals("scissors") && comp.equals("rock"))) {
    feedback = "You lost!";
}
```

Hardcode each of the three test conditions (i.e. set `play = "rock"` and `comp = "paper"`, etc.) and make sure they work. Then try a condition for draw to make sure it doesn't print both. Finally try a condition for a win to make sure it does neither of the other two.

### Win condition

Likewise, we know paper beats rock, rock beats scissors, and scissors beat paper. Starting with the first,

``` 
    if (play.equals("paper") && comp.equals("rock")) {
        feedback = "You won!";
    }
```

As before, test this with the hardcoded values for `play` and `comp`to make sure it works. Then expand to the other two possibilities. Finally,  test them to make sure you get the correct response for one of each.

## Putting it together

Now, remove your hardcoded values of `play` and `comp`. Uncomment the blocks that decided the values and run the code, confirming that it does what you suspect. You may want to insert a print statement to make sure what values the variables have, then delete it afterwards. Run it repeatedly to make sure it does what you expect.

## Playing repeatedly

Finally, enclose the whole thing in a `while` loop. Before the start of the loop, input a string named `yesno` with a value of `Y` or `N`. The loop should start something like this.

```
    String yesno = new String("Y");

    while (yesno.equals("Y")){
        <other code goes here>

        System.out.print("Do you want to play again? Y/N");
        yesno = (myScan.nextLine()).toUpperCase();
    }
```

Test this to make sure it continues as long as the player enters Y and doesn't play if they enter anything else. You could also use `((yesno.toUpperCase()).equals("Y"))` to make it more robust.

## Wrapping up

Go back through the code and comment what each block does. Make sure you have enough information that you will be able to understand it if you have to review it later.

This should do it! I know this one seemed pretty long. Go ahead and commit it, then send me a message that you're ready for me to grade it.