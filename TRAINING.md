# Advanced Programming Training (Summer 2026)
Welcome to advanced programming training!

You will learn WPILib coding and general FRC programming.

WPILib is the software suite containing all necessary packages and applications for FRC programmers.

## Table of Contents
- [Table of Contents](#table-of-contents)
- [Attribution](#attribution)
- [Setup Part 1](#setup-part-1)
    - [WPILib Installation](#wpilib-installation)
    - [GitHub](#github)
    - [Cloning](#cloning)
- [Setup Part 2](#setup-part-2)
    - [View](#view)
    - [Extension Installation](#extension-installation)
        - [Disabling Unnecessary Extensions](#disabling-unnecessary-extensions)
        - [Live Share](#live-share)
- [Optional Java Recap](#optional-java-recap)
- [Programming the Codebase](#programming-the-codebase)
    - [Expectations](#expectations)
    - [Spindexer Subsystem](#spindexer-subsystem)
        - [Initializing the Motor](#initializing-the-motor)
        - [Configuring the Motor](#configuring-the-motor)
        - [Adding Subsystems to the Robot](#adding-subsystems-to-the-robot)
        - [Using the Motor](#using-the-motor)
            - [Movement Method](#movement-method)
        - [Reading the Motor](#reading-the-motor)
            - [Sendable Properties](#sendable-properties)
            - [Velocity Property](#velocity-property)
        - [Refactoring and Organization](#refactoring-and-organization)
            - [Documentation](#documentation)
    - [Commands and Bindings](#commands-and-bindings)
        - [Optional Runnables and Lambdas Review](#optional-runnables-and-lambdas-review)
        - [Spindexer Controls](#spindexer-controls)
        - [More About Commands](#more-about-commands)
            - [Subsystem Requirements](#subsystem-requirements)
            - [Command Lifetime](#command-lifetime)
            - [Command Creation](#command-creation)
            - [Default Subsystem Command](#default-subsystem-command)
            - [Command Types](#command-types)
            - [Disable Behavior](#disable-behavior)
            - [Interrupt Behavior](#interrupt-behavior)
            - [Canceling Commands](#canceling-commands)
            - [Robot Mode Triggers](#robot-mode-triggers)
            - [Autonomous Commands](#autonomous-commands)
    - [Intake Subsystem](#intake-subsystem)
        - [Subsystem Specifications](#subsystem-specifications)
        - [Initializing the Motors](#initializing-the-motors)
        - [Configuring the Motors](#configuring-the-motors)
            - [Software Limit Switches](#software-limit-switches)
        - [Intake Position](#intake-position)
        - [Adding Intake to the Robot](#adding-intake-to-the-robot)
        - [Using the Roller Motor](#using-the-roller-motor)
        - [Java Units Library](#java-units-library)
            - [Units Summary](#units-summary)
            - [Units Refactoring](#units-refactoring)
        - [Using the Deploy Motor](#using-the-deploy-motor)
            - [Adding Safety Limits](#adding-safety-limits)
        - [Deploying and Stowing Intake](#deploying-and-stowing-intake)
        - [Intake Bindings](#intake-bindings)
        - [Retrieving Intake Angle](#retrieving-intake-angle)
        - [Robot Constructor Refactoring](#robot-constructor-refactoring)
    - [Launcher Assembly](#launcher-assembly)
        - [Control Area Network](#control-area-network)
        - [Feeder Subsystem](#feeder-subsystem)
            - [Feeder Requirements](#feeder-requirements)
        - [Hood Subsystem](#hood-subsystem)
            - [Hood Specifications](#hood-specifications)
            - [Recording the Setpoint](#recording-the-setpoint)
        - [Shooter Subsystem](#shooter-subsystem)
            - [Leader and Follower Motors](#leader-and-follower-motors)
            - [Configuring Shooter Motors](#configuring-shooter-motors)
            - [Shooter Movement Methods](#shooter-movement-methods)
        - [Turret Subsystem](#turret-subsystem)
            - [Motors vs Encoders](#motors-vs-encoders)
            - [Turret Movement Methods](#turret-movement-methods)
        - [Automatic Targeting](#automatic-targeting)
            - [Aiming The Turret](#aiming-the-turret)
            - [Determining Launch Speed](#determining-launch-speed)
            - [Putting It Together](#putting-it-together)

- [Temporary End](#temporary-end)

## Attribution
This file and codebase were written by @spacepotatoes3 and @aatle on GitHub.

*No AI was used to write any parts of this project.*

## Setup Part 1

### WPILib Installation
Go to https://docs.wpilib.org/en/stable/docs/zero-to-robot/step-2/wpilib-setup.html, and download the installer.

Once downloaded, run the installer. Click `Start`.

Select `Everything` and click `Install for this User`.

Click `Download for this computer only (fastest)`, the top left option. After it finishes, click `Next`.

Wait for it to install, then click `Finish`.

Make sure to put the WPILib VS Code for the current year in an accessible location, such as by adding a shortcut.

Also, avoid mixing up your WPILib VS Code with your regular VS Code. WPILib's VS Code shows a small WPILib icon in the top right of the window.

**MacOS users:** \
Extra step after installation finishes: \
Inside the Finder file explorer that opens and shows `VS Code`, select the `VS Code`, right click, and press `Make Alias`. \
Then rename the alias to something like `FRC VS Code 20XX`, where `20XX` is the current year. \
Next, move this alias into your `Applications` folder in the left sidebar. \
You can now run WPILib's VS Code from your Launchpad; it is recommended to also `Keep in Dock` (pin) this application to the bottom dock bar.

### GitHub
First, you must *fork* your own copy of the [`Team-1280-Training/rebuilt-training`](https://github.com/Team-1280-Training/rebuilt-training) repository because you don't have write access for that repo.

Near the top, click the `Fork` button. In the opened page, you can use the default configuration; press `Create fork`.

Once you have created the repository, open your WPILib VS Code application.

### Cloning
In WPILib VS Code, open the *Command Palette* (important tool), by using a keyboard shortcut or clicking the top search bar and typing a `>`. \
Windows, Linux: `F1` or `Ctrl`+`Shift`+`P` \
Mac: `fn`+`F1` or `Command`+`Shift`+`P`

Then, find and select the `>Git: Clone` command. \
If it asks you to sign into GitHub, do that.

Then press `Clone from GitHub` and select the repository you created earlier (make sure the repository's author is you and not the team training organization).

Select or create a new folder that the repository folder will be in.

> Tip: I recommend creating a folder on your computer called `dev` or `development` that holds all of your programming projects. \
> Pin it in your computer's file explorer for easy access.

When prompted, click `Open` to open it in the current VS Code window. \
Then press `Yes, I trust the authors` (do not check the checkbox).

## Setup Part 2

### View
On the left, open `TRAINING.md`. Preview the file using `Ctrl`/`Command`+`Shift`+`V`.

> Tip: When programming later, drag the `Preview TRAINING.md` tab (near the top) to the right side, to split the window.

> Tip: If at any time you want more space, press `Ctrl`/`Command`+`B` to hide the side bar, or press the sidebar's selected icon.

### Extension Installation
You will need to install an extension that automatically formats your code upon saving.

Find and select the `>Extensions: Show Recommended Extensions` command.

Install the *Workspace Recommendations* extension: `Google Java Format for VS Code`. \
Click that you trust the author, when prompted.

Now, auto-formatting will work when you save your code with `Ctrl`/`Command`+`S`.

> Note: Many useful settings are enabled in this workspace at `.vscode/settings.json`, near the bottom of the file. If you would like to also have these settings in all workspaces, copy them to your User Settings JSON file (openable with a command).
> These settings should be in your FRC robot codebases.

#### Disabling Unnecessary Extensions
Some extensions take a long time to start up but aren't very useful.

On the top right corner of many of the extensions listed in the Extension sidebar, the startup time of the extension is shown (e.g. `533ms`).

Disable the following extensions:
- Any extension with `Gradle` in the name
- `Maven for Java`
- `Test Runner for Java`
- `Project Manager for Java`
- Any other extensions with a high startup time that you have determined to be not useful (ask mentors)

#### Live Share
To allow mentors to view your coding in real time, install the `Live Share` extension (by the verified `Microsoft`).

On the left bar, click on the live share icon and share a `Read/Write` link with the mentor.

Mentors:
- When opening a link, it will replace the last used VS Code window. So if you have existing windows to keep, create a new blank window with `Ctrl`/`Command`+`Shift`+`N`.
- In the shared workspace, click on the Live Share icon on the left and then click on the trainee's name to follower their pointer.
- Works best with 1-2 trainees. When mentoring, use split screen, second monitor, or skillful window switching to monitor both trainees.

## Optional Java Recap
<details><summary>Optional review</summary>

Before we start WPILib programming, let's recap some Java syntax and terminology.

A *variable* stores a value of the correct *type*. All variables have a name (use `camelCase` convention) and a type. \
E.g. `int count = 2;`

A *class* is a type that can create individual *instances* (objects). Users can define new classes. Classes use the `PascalCase` naming convention. \
E.g. `String`, `IntakeSubsystem`.
```java
public class Person { // Person class

}
```

A class can have *fields*, which are variables that belong to each instance. Fields can optionally have a default value.
```java
public class Person {
    String name;
    boolean alive = true;
}
```
Fields can be accessed with the `.` dot operator on an instance.
```java
System.out.println(person.name); // Field: name, of person
```
However, inside of the same class, the field can be referred to directly with just its name.
```java
System.out.println(name); // Inside of Person class
```

A class can have *methods*, which are runnable blocks of code. \
The method definition starts with the *return type* (`void` if none), followed by the method's name, and then a pair of parentheses, and then curly braces enclosing the method body (method code).
```java
public class Person {
    void greet() { // greet method
        System.out.println("Hello!");
    }
}
```
Methods can be *called* on an instance using the `.` dot operator.
```java
Person me = <...>;
me.greet(); // Method call
```

Methods can have *parameters*, which are variables that are used to input values, called *arguments*, from the method call. Parameters are placed in the method declaration parentheses. Arguments are placed in the parentheses of a method call.
```java
public class Person {
    void greet(String name1, String name2) { // Parameters: name1, name2
        System.out.println("Hello " + name + " and " + name2 + "!");s
    }
}
```
So, arguments are passed into a method call to fill the parameters.
```java
me.greet("Mittens", "Dracula");  // Arguments: "Mittens", "Dracula"
// Output: 'Hello Mittens and Dracula!'
```

*Modifiers* affect methods and fields:
- Access modifiers: `public`/`private`/(`protected`) - affect if other classes can access the method or field
- `final` modifier: makes the variable or field unassignable (constant); for methods, makes it not overridable
- `static` modifier: makes the method or field belong to the class instead of an instance, so that it can be accessed with the class itself
```java
public class Person {
    public String name; // Changeable, public field
    public final String birthday; // Constant, public field
    private final int ssn; // Constant, private field

    public void greet() { // Public method
        // ...
    }
}
```

A *constructor* is a special method for the class that is invoked when creating a new instance with the `new` keyword. \
It has no return type, and the method name is the same as the class name
```java
public class Person {
    private String name;
    private int age;

    public Person(String personName, int personAge) { // Constructor for Person class
        name = personName;
        age = personAge;
    }
}
```
```java
Person trainee = new Person("E", 5); // Create a new Person instance with the new keyword and the constructor
```
Comments start with `//`. Multi-line comments start with `/*` and end with `*/`. \
Javadoc comments start with `/**`, end with `*/`, and are put right before a method, field, or class.
```java
class Person {
    /** First and last name */
    public String name;

    /** 
     * Greet a person.
     */
    public void greet() {
        System.out.println("Hello!"); // cheerful
    }

    /*
     * Long
     * comment
     */
}
```

</details>

> Note: If the Java code is giving errors or isn't updating for new edits, try using the `>Java: Clean Java Language Server Workspace` command to clear the Java cache and reload the window.

## Programming the Codebase
We will dive right into coding. The first priority is to implement the subsystems (mechanisms) of the robot.

### Expectations
Programming is difficult and you cannot fake competence.

It is expected that you will ask questions and clarify *every* concept you do not know or understand. Do not wait; interrupt the mentor to ask as early as possible, so that you don't start falling behind. \
This is a mentorship, not a classroom.

However, please note that mentors will not directly write out code for you unless necessary, because copying code does not induce learning. \
Please also refrain from copy-pasting previous code; you can type it out quickly with the help of autocomplete and IDE features, which reinforces the syntax.

Mentors:
- You must monitor how the trainees are doing and provide verbal corrections if something is off (unless it is a repeating/frequent error)
- You also need to provide suggestions on how to edit code more efficiently, e.g. the following shortcuts:
    - `Ctrl`+`C` or `Ctrl`+`X` on a whole line without highlighting anything
    - `Alt`+`Down`/`Up` to move lines
    - `Ctrl`+`Left`/`Right` to move quickly, and `Ctrl`+`Backspace`
    - `F2` or `fn`+`F2` to rename symbols
    - `Ctrl`+`A` to select all code
    - `Ctrl`+`D` to highlight multiple occurrences
    - `Ctrl`+`K` `S` to save all files at once
    - `Ctrl`+`Tab` to switch back to recent tabs
    - `Ctrl`+`/` to toggle line comment
    - Save code frequently, to automatically format instead of manually

### Spindexer Subsystem
To start, we'll implement the robot's spindexer from scratch.

<sub><sup>Mentors, explain what the spindexer subsystem is.</sup></sub>

Open the `src/main/java/frc/robot` folder (start by opening the `src` folder).

You'll see some files, but ignore them for now. We'll create a new file called `SpindexSubsystem.java`. (The class definition should be autofilled for you by the IDE.)

The `SpindexerSubsystem` class defines procedures and methods for the spindexer that other code can later use to control it.

The first thing we need to do is make the `SpindexerSubsystem` class *inherit* from `SubsystemBase` to make it a real subsystem.

You may notice a red squiggly line under `SubsystemBase`. This is because that class has not been imported yet. \
Generally, you should *autocomplete* the class or any other symbol when typing it, by pressing `Tab` to accept a dropdown suggestion; this will *auto-import* it.

Luckily, because of some JSON settings I put inside this repository, you can just save the file with `Ctrl`/`Command`+`S` to auto-import `SubsystemBase` in this specific case.

#### Initializing the Motor
Let's add a field in `SpindexerSubsystem` for controlling the single motor. \
The motor controller class is called `TalonFX` (for Kraken motors).

Declare a private and final `TalonFX` field named `motor`.

The `motor` name has a warning because it is not used. Define a default value for the field, setting it to a new `TalonFX` *instance*.

The `TalonFX` constructor requires an integer argument for the motor CAN ID. (If you autocompleted the constructor then you'll notice that the IDE filled it with a placeholder `0`, that you can delete.)

You would not know the motor ID at this point in development, so use the placeholder value of `-1`.

#### Configuring the Motor
The motor needs to be configured correctly.

Create a new private, static, final field called `motorConfig`. Initialize it to a new `TalonFXConfiguration` object, with no constructor arguments.

We could set the properties of this configuration in a `SpindexerSubsystem` constructor, but instead we will use a special static block to do this right in the class.

Start a new static block by typing `static` on a new line in `SpindexerSubsystem`, and then placing a pair of curly braces after it.

The Talon FX motor configuration is split into sections, each section corresponding to a field on the `TalonFXConfiguration` object, such as `CurrentLimits`, `MotorOutput`, `Feedback`. Each of those then has fields for the specific configuration properties.

For example, the direction of the motor is controlled by `motorConfig.MotorOutput.Inverted`.

Inside of the block, set the *stator current limit*, under the *current limits* section, to `80.0` (amps). This protects the motor by limiting how much electric current flows through it, preventing overheating or and capping maximum torque.

Next, set the *neutral mode*, under the *motor output* section. The value will be an enum constant, as shown by the right side of the suggestion. Set the motor output to coast (as opposed to brake). \
(For `TalonFXConfiguration` settings, these enum type names will always be the field name with `Value` added to the end.)

Coasting has the valuable benefit of allowing easy manual movement when the robot is disabled. If you need the motor to brake during operation, you can explicitly set it to instead of relying on neutral mode. However, mechanisms affected by gravity such as elevators or vertical arms should obviously default to braking.

Then, set the *inverted* setting, under *motor output* section, to any of the two enum values (as a placeholder) since it is unknown right now. This affects which way the motor spins when the motor speed is set to a positive number, and negative number (reverse).

We want it so that a positive motor speed makes fuel be fed into the launcher, just as an intuitive convention. Make a code comment to note this convention.

> Note: Although you can technically deduce the correct direction from the motor's placement, it is much easier and more robust to simply test it.

These three settings, current limit, neutral mode, and direction, are the basic, universal motor configs that should be explicitly set for all motors. \
The spindexer motor actually does not require any more configuration because it is a simple wheel.

You have now created and initialized a motor configuration object but have not yet applied it to the actual motor. Write a constructor for `SpindexerSubsystem` that takes no arguments.

To apply the motor configuration in `SpindexerConfig` to `motor`, call `getConfigurator()` on the `motor` followed by calling the `apply()` method on its return value. Pass in the motor config as the argument to the `apply` method.

> Note: whenever a motor configuration is applied, by code or elsewhere, the motor chirps a short melody. This is useful to tell when the code on the robot is all initialized and ready.

> Tip: Be sure to save your code frequently, to automatically format the code.

#### Adding Subsystems to the Robot
Even though we've written this nice class, it isn't used anywhere yet.

Navigate to `Robot.java`. Scroll down past the import statements to the start of the `Robot` class body.

Add a new private, final field named `spindexer`, initialized with a new instance of `SpindexerSubsystem`.

Now the spindexer subsystem is activated and usable. (Ignore the warning that says the field is not used anywhere yet.)

#### Using the Motor
Go back to `SpindexerSubsystem.java`.

In order to get the spindexer to move, the motor has to be controlled. There are a few different methods on `TalonFX` to do this:

- `set(double speed)`: set the motor to a fraction/percentage of its maximum output, from `-1.0` (reverse) to `1.0`; this fraction from -1.0 to 1.0 is sometimes called *duty cycle*
- `setVoltage(double volts)`: set the motor voltage directly, a value from around -12 to 12 (the battery is 12V)
- `setControl(ControlRequest request)`: tell the motor to follow a specific control request, such as requesting a specific motor position or velocity, or braking, coasting, or idling

See the [CTRE Phoenix 6 Java API docs](https://api.ctr-electronics.com/phoenix6/stable/java/com/ctre/phoenix6/hardware/TalonFX.html#set(double)) for the official information on `set()` and `setVoltage()` methods. \
Note that you can also view this information in VS Code when the method is suggested as a completion, e.g. if `motor.se` was partially typed.

The spindexer is extremely simple and only needs to spin at some arbitrary approximate speed. Therefore, we should use the `set()` method. Other mechanisms like elevators need to use `setControl()` because they must be very accurate.

##### Movement Method
Let's add a convenience method to set the spindexer motor speed.

Create a public method named `moveMotorSpeed` that sets the spindexer motor to some desired input speed using its `set` method.

> Hint: If you are having trouble writing the method definition, ask yourself:
> - Does the method return anything? What type is it?
> - Does the method need some sort of input parameter? If so, what type are they?

The reason we made this method is because now setting speed is documented, explicitly defined, and *extensible* (we can add features such as logging or speed capping easily).

Importantly, other code outside of `SpindexerSubsystem` can now set the speed because we made the method public; the motor field itself is private.

This method also applies abstraction, since we are making a single neat method that hides the actual implementation details.

In most cases though, we want to just tell the spindexer to be either on or off, without needing to give it a speed. So, create two more public methods, `start()` and `stop()`, that use your `moveMotorSpeed()` method with a predefined speed. For `start()`, use `0.5` as the speed for now.

#### Reading the Motor
Being able to tell the spindexer what to do is cool, but we should also have methods that get information that we can display on the dashboard.

The dashboard is an application where you can view real-time robot information. WPILib provides many available dashboards.

We have a method to set motor speed, and now we will define a method to get the motor speed.

First, declare the method (this means write the method out except the body).

To implement the method body, use the `get()` method of the motor. After writing it, hover over it to see its documentation.

Now we have defined a way to get the motor speed of the spindexer.
But this information getter is of little use if we can't access it easily while the robot is running.

##### Sendable Properties
A sendable is something we can *send* over NetworkTables (an FRC communication protocol) to the dashboard. The sendable contains multiple properties, which is the actual numerical or text information shown.

Here, our sendable is the `SpindexerSubsystem`, and the property we want to log is the motor speed.

To log it, we need to override a method in `SpindexerSubsystem`. \
On a new line in the class body, type in `initSendable` without modifiers, and autocomplete with the suggestion. \
(If no suggestion shows, be sure that your `SpindexerSubsystem` extends from `SubsystemBase`.)

Replace the code inside with a call to the `builder`'s `addDoubleProperty()` method. The `SendableBuilder` is used to build the sendable's properties.

Autocompleting it fills it with 3 arbitrary arguments that we need to replace. Hover over `addDoubleProperty` to see documentation.

We see that the first parameter is a string for the property name; a label. Let's use `"motor speed (frac)"` for this (don't forget the quotes to make it a string). The label should be lowercase.

> Note: Document the units of numerical properties in its label, e.g. rotations, degrees, fraction, meters.

The next parameter is a getter that gives the value of the property to display on the dashboard. Its type is `DoubleSupplier`. A `DoubleSupplier` is simply a runnable that takes no arguments and returns a `double`. We can use lambda expressions or method references for this.

Use a method reference to our new `getMotorSpeed` method.

> Hint: the `this` keyword is a variable referring to the instance of the current method.

The last parameter is the setter, which allows a user to change the value on the dashboard, invoking the setter. Passing in `null` means no setter.

However, our `moveMotorSpeed()` is the perfect setter method for this. It already takes a `double` like the setter should. Use a method reference to `moveMotorSpeed` for the setter argument.

> Tip: You can add forward slashes `/` to the property key to use or create dropdowns and hierarchies inside the dashboard table.

Defining `initSendable()` is not enough. The sendable still has to be actually sent to the dashboard. Be sure to not forget this step.

In `Robot.java`, create a new constructor for `Robot`.

Then call the `SmartDashboard.putData()` static method. For the first argument, the string key/label, put `Spindexer`, with capital `S` to help differentiate sendables from properties. The second argument is `spindexer`, our sendable.

The dashboard now receives information about the spindexer motor speed, along with allowing the user to set the motor speed. The spindexer subsystem is now testable.

##### Velocity Property
Challenge: create a dashboard property for the angular velocity of the motor. Research how to do this on your own.

<details><summary>Solution</summary>

**Method 1: Web Browser or AI** \
To research with AI or web browser AI overview, search something concise, specific, and descriptive like:
```
phoenix6 talonfx get angular velocity
```
Not:
```
how do i get the angular velocity of a motor
```
Notice that only keywords are necessary to search for information.

Yields either:
```java
motor.getVelocity().getValueAsDouble()
motor.getVelocity().getValue().in(RotationsPerSecond)
```

**Method 2: VS Code Autocomplete**
Type in partial method or field accesses to get search-like autocomplete suggestions, especially useful if you learned it before and vaguely remember the structure.

In any method in `SpindexerSubsystem`, typing in `motor.angular` or `motor.velocity` to show autocomplete suggestions yields `getVelocity()` as the first result. Accepting this and then hovering over the method shows us the Javadoc that verifies it is correct.

Then, adding a `.` and scrolling through the methods of `StatusSignal` shows `getValueAsDouble()` as a result, which is correct.

**Method 3: API Reference**
To research with the online API reference, use `Ctrl`/`Command`+`F` with distinct keywords on the appropriate page.

The API docs for `TalonFX` are at https://api.ctr-electronics.com/phoenix6/stable/java/com/ctre/phoenix6/hardware/TalonFX.html.

Searching `angular` yields no results, so search `velocity`. \
There are 8 matches. `Ctrl`+`Click`-ing on some to read their descriptions leads to the `getVelocity` method.

However, here, the return type is a `StatusSignal`, leading to further research.

**Final Statement:**
```java
builder.addDoubleProperty("angular velocity (rps)", () -> motor.getVelocity().getValueAsDouble(), null);
```

> Note: Don't forget to add units in your property key.

</details>

#### Refactoring and Organization
First, commit your code. For the message, start with a type `feat: ` for feature, and then add your description `implement spindexer subsystem`. Other commit types include `fix`, `refactor`, `docs`, `tune`, `style`, etc. (look up "git conventional commits" for more).

Currently, all of our spindexer code is in `SpindexerSubsystem.java`. These subsystem classes can grow quite large if they are not broken up, making finding specific methods or constants more difficult.

Our codebase convention is to split up the overall subsystem 'feature' into three distinct parts: the subsystem, the configuration, and the constants.

- Subsystem: contains methods for all of the low-level motor control and code
- Configuration: stores all *tunable* (adjustable) values in one convenient class, such as desired speeds, current limits, neutral modes, PID gains (explained later), etc.
- Constants: stores all *physically constant* or generally unchanging values, such as device IDs, gear ratios, mechanism limits, dimensions, etc.

Note that configuration values should be adjusted or tuned to improve robot functionality while constants values are simply givens and do not need to be tuned.

Let's *refactor* (rewrite and reorganize) our spindexer code.

First, create a folder called `spindexer` (lowercase), in the same directory as `SpindexerSubsystem.java`.

Then, move `SpindexerSubsystem.java` inside of the new folder. The IDE will ask to make refactoring changes; accept them. This automatically fixes any imports or references to the original location.

Then, create two files in the folder: `SpindexerConfig.java`, and `SpindexerConst.java`.

Apply the following refactoring:
- Move the motor ID `-1` to `SpindexerConst` as `MOTOR_ID`
- Move `motorConfig` and its static block to `SpindexerConfig`
- Move the current limit of `80.0` to a new `SpindexerConfig` constant
- Move the `start()` motor speed of `0.5` to a new `SpindexerConfig` constant

Don't forget to commit, with commit type `refactor: `.

##### Documentation
The core functionality of the spindexer feature is done for now, but there are a few documentation tasks to do.

First, use Javadoc comments to document methods where necessary, specifically your motor methods. (Javadoc comments are started with `/**` (slash, star, star)).

Fields can also be documented using a Javadoc comment placed before the declaration. Document your motor speed constant, as the operational spindexer power.

We have a lot of placeholder values in the code currently. For every unknown or to-be-determined value, add a `// TODO: description` comment.

> Tip: Some bugs in early testing come from inadvertently using forgotten placeholder values.

Note that these documentation tasks should typically be done *while* writing the code, not after writing it.

Don't forget to commit.

This marks the completion of the first subsystem.

### Commands and Bindings
In order for the driver to utilize these methods, we have to create controller *bindings* that tie *controls* (e.g. right trigger) to *actions* (WPILib command objects). We use an Xbox controller. \
For example, one binding could be: hold left bumper to run spindexer.

Think of a WPILib `Command` object as an instruction written on a slip of paper. You can give it to someone, pass it around, store it for a later time, reuse it.

The instruction on the paper is a subsystem action such as 'start the spindexer'. But how do we store something like a method as an object? We use method references and lambda expressions. In Java, these are `Runnable`s, function objects that take 0 parameters and don't need to return anything.
```java
// Equivalent Runnable objects for starting the spindexer

// lambda expression: 'one line function object'
Runnable lambdaRunnable = () -> spindexer.start();

// method reference: concise representation, but less flexible
Runnable methodRunnable = spindexer::start;

// ERROR! a spindexer.start() call cannot be stored
Runnable notARunnable = spindexer.start();

// flexible lambda expression
Runnable lambdaRunnable2 = () -> spindexer.moveMotorSpeed(0.2);

// ERROR! spindexer::moveMotorSpeed requires 1 argument, not 0
// (The correct variable type is: Consumer<Double>)
Runnable invalidRunnable = spindexer::moveMotorSpeed;
```

A WPILib `Trigger` object is like a green LED light that signals when to execute the command. Controller inputs like `Left Bumper` are the triggers here. The `Trigger` object has methods to bind (register) commands to conditions like 'when trigger changes from false to true'.

With this, we can write code that says "when left bumper pressed, run `spindexer.start()`, and when released, run `spindexer.stop()`", all without using any if statements.

#### Optional Runnables and Lambdas Review
<details><summary>Review</summary>

A *runnable* is like a miniature method or function, that is treated like an object but can be *invoked* (run) to run its code. \
Unlike regular methods, you can pass around a runnable like an object, especially as an argument to methods.

A common way to define one is a *lambda expression*, a short block of code that defines a mini function.

To write a lambda, start with a set of parentheses (representing the parameter list of a function), followed by an arrow: `() -> ` \
Then, after the end of the arrow, put an expression that will be executed (and returned if applicable).

Example of a runnable that, when invoked, prints `Hello`.
```java
() -> System.out.println("Hello")
```
Analogous to:
```java
public void runnable() {
    System.out.println("Hello");
}
```
Example of a runnable that, when invoked with integer arguments `a` and `b`, returns their product:
```java
(int a, int b) -> a * b
```
Analogous to:
```java
public int runnable(int a, int b) {
    return a * b;
}
```

> Note: Lambda expressions can also have a whole code block enclosed in curly braces at the end, instead of just one expression. \
> `(int x) -> { method1(x); method2(); return value; }`

> Note: The types of the lambda parameters can be omitted.

</details>

#### Spindexer Controls
Open `Robot.java`.

Locate the `robotPeriodic` method. This method runs every 20 milliseconds. Write the following line of code:
```java
CommandScheduler.getInstance().run();
```
If we forgot this line, then commands never get scheduled and never run.

Then, add a new private, final field called `controller` initialized to a new `CommandXboxController` instance, passing in `0` (controller port) for the constructor argument.

Then create a parameterless constructor for `Robot`, where we will put some bindings. We will bind holding the left bumper to run the spindexer.

The `controller` has methods for each control, that each return a `Trigger` object. Define a `Trigger` variable called `leftBumper` initialized to a `controller.leftBumper()` call.

Then define a `Runnable` variable called `startSpindexer` initialized to a method reference to the spindexer's `start` method.

To create a command that instantly executes a given `Runnable`, the most basic command possible, use the `runOnce()` factory method of a subsystem.

Define a `Command` variable called `spindexerCommand` initialized to `spindexer.runOnce(startSpindexer)`.

Then, call the `onTrue()` method of `leftBumper`, and pass in `spindexerCommand`. This tells the controller to *schedule* (begin) the `spindexerCommand`, whenever `leftBumper` changes from unpressed to pressed. (Note that this does not repeatedly schedule the command while the left bumper is held.)

The spindexer has not yet been told to stop upon release of the left bumper. So, without defining more variables, write a single statement that binds the `stop()` method to left bumper release.

The code now works, but we can shorten it. Refactor the `start` binding code to remove the `spindexerCommand` and `startSpindexer` variables.

Currently, we use `leftBumper` twice. We can actually combine the two statements into one, via *method chaining*. Hover over the `onTrue` method, and see that the method actually will return `leftBumper` again. Use this information to move the `onFalse()` call to the same line as the `onTrue()` call. Then refactor and remove the `leftBumper` variable.

There's an even shorter way to write this though. A `StartEndCommand` executes one runnable instantly at the start like (`InstantCommand`) but when the command is ended/canceled, it executes a second runnable. This is perfect for our case. The trigger method to use with it is the `whileTrue()` method; read its Javadoc comment.

Use this to rewrite our binding more concisely, referring to docs or mentors if needed.

Then, document this control in [README.md](README.md).

Don't forget to commit.

#### More About Commands
Now that you've had a taste of commands, we'll go into more complex features of commands.

WPILib commands are a very heavy topic designed to allow advanced programmers to have precise control of the robot. Writing command procedures to efficiently operate the robot is basically an entire robotics programming specialization in itself.

Examples of command-based controls systems can be found at our past codebases, [REBUILT 2026](https://github.com/Team-1280/rebuilt-2026/blob/main/src/main/java/frc/robot/Robot.java) and [REEFSCAPE 2025](https://github.com/Team-1280/Reefscape-2025/blob/main/src/main/java/frc/robot/RobotContainer.java) (messy).

##### Subsystem Requirements
Each command has a set of subsystem requirements, e.g. just spindexer, or feeder+shooter, or even no requirements.

What does it mean for a command to require a subsystem? Command requirements are simply a convenient way of keeping track of which subsystems are currently occupied. For example, you can't run the spindexer forward and backward simultaneously.

If a command requires a subsystem, but another command that requires the same subsystem is scheduled/run, then the previous command is canceled. (Note that you can configure the previous command to instead block/cancel incoming commands using its `withInterruptBehavior()` method, a useful.)

Imagine if you had written another analogous binding for running spindexer in reverse with the right bumper, but you neglected to use subsystem requirements on either command. Strange behavior could occur.

##### Command Lifetime
These requirements only last while the command is active. The lifetime of a command is as follows:

- Create: command is created but not scheduled
- Schedule: command is scheduled by a trigger object
  - Initialize: run any starting code, e.g. `runOnce()` would invoke its runnable
  - Execute: if command lasts longer than one instant, then it may run behavior every periodic, e.g. `RunCommand` invokes its runnable repeatedly
  - End/Deschedule: the command is ended, potentially invoking behavior, by one of three ways:
    - Finish: command ends itself by signalling with its `isFinished()` method, e.g. `WaitCommand` elapsing or `runOnce()` finishing instantly
    - Interrupt: another command is scheduled requiring the same subsystem, which ends the current command
    - Cancel: command's `cancel()` is called, manually ending it

##### Command Creation
There are four ways to create commands:
- Use the inherited methods on subsystems like `runOnce()` to create command objects requiring that subsystem.
- Use the `Commands` utility class with methods like `runOnce()` to create command objects. Pass in subsystems to add requirements.
- Directly use the constructor of command classes. Pass in subsystems to add requirements.
- Use a method of an existing command such as `withTimeout()` to wrap it with another command that further specializes or restricts it.

The following expressions all give equivalent commands.
```java
// Instant command that runs spindexer.start(), and requires the spindexer subsystem
spindexer.runOnce(spindexer::start) // recommended
Commands.runOnce(spindexer::start, spindexer)
new InstantCommand(spindexer::start, spindexer) // not recommended
```
In fact, each line shown here just internally invokes the line below it. Use `Ctrl`+`Click` on `runOnce` in `spindexer.runOnce()`, then again for `Commands.runOnce`, to see that it boils down to `InstantCommand`.

##### Default Subsystem Command
Subsystems may be given a default command that is run whenever no other command requires the subsystem.

Use the inherited `setDefaultCommand()` method of any subsystem.

The command should not end itself (no `InstantCommand`); the subsystem will reschedule the command if it ends.

An example use case of default command is a drivetrain applying driver controls to itself; this will be run by default unless overridden by an autoalignment command for example.


If you wanted the spindexer to run all the time except when told to stop, you could write:
```java
spindexer.setDefaultCommand(spindexer.run(spindexer::start));
```

##### Command Types
There are commands for any possible combination of behaviors you can imagine, plus commands for basic utilities such as waiting, printing, or idling. These are created with `Commands` methods, `Command` methods, or `SubsystemBase` inherited methods.

The basic commands wrapping runnables such as `runOnce`, `startEnd` all have subsystem methods that automatically return a method requiring that subsystem.

A special type of command is a command group, which is simply a command that contains multiple commands and executes them sequentially, or in parallel, etc. A command group inherits all requirements from its inner commands.

The most common command types you will use are:
- `runOnce` - executes a runnable once
- `run` - executes a runnable repeatedly until ended
- `startEnd` - executes a runnable upon initialization, executes another runnable upon finishing
- `runEnd` - executes a runnable repeatedly until ended, which executes another runnable
- `startRun` - executes a runnable and then executes another repeatedly until ended
- `sequence`/`andThen` - executes each command in order, sequentially
- `parallel`/`alongWith` - executes all commands at the same time
- `waitSeconds` - waits some time and then finishes

You can create any possible construct of behavior by chaining and composing the built-in commands. The recommended way to organize long command compositions is to place their creation in dedicated methods within `Robot` or a separate utility class.

You can also extend a command class and write your own functionality for even more flexibility if somehow that is necessary.

##### Disable Behavior
By default, commands will NOT be scheduled when the robot is disabled, even if they are harmless (with the exception of utility commands like print or wait).

To override this, call `ignoringDisable(true)` on the command, which makes it able to run even while disabled.

For example, you should have the stow command binding able to run while disabled, allowing you to safely prevent the robot from operating before you enable it, rather than needing to time the input.

##### Interrupt Behavior
By default, a newly scheduled command will interrupt and end older commands that require the same subsystem.

To prevent this, call `withInterruptBehavior(InterruptionBehavior.kCancelIncoming)` to make a scheduled command end incoming commands instead of itself.

For example, your full-stow commands may want to protect itself from other commands while requiring every subsystem.

##### Canceling Commands
Commands can be manually canceled with their `cancel()` method. You may need to make a variable for a command to be able to access its cancel method later.

Use `CommandScheduler.getInstance().cancelAll()` to cancel all commands.

##### Robot Mode Triggers
Controller inputs are the primary trigger, but another useful set of triggers resides in the `RobotModeTriggers` class. It has triggers such as `autonomous()`, allowing you to write code like:
```java
RobotModeTriggers.autonomous().onFalse(Commands.print("our 0 point auto routine has ended"));
```

##### Autonomous Commands
Autonomous routines run using registered "named commands" (allowing you to refer to them when making routines in an application).

The entire selected autonomous routine is encapsulated in one command that you have to schedule in your code.

### Intake Subsystem
Next, we'll implement our intake subsystem! You will receive slightly less guidance on setting up the intake, so feel free to reference your completed spindexer subsystem if needed. Do not copy-paste code.

Create the `intake` folder and the three files, `IntakeConfig.java`, `IntakeConst.java`, and `IntakeSubsystem.java` are contained in the `intake` folder.

> Hint: Make sure `IntakeSubsystem` inherits from `SubsystemBase`.

#### Subsystem Specifications
<sub><sup>Mentors, explain what the intake subsystem is.</sup></sub>

The intake deploy mechanism has a range of `128.26` degrees, where the lowest angle is parallel to the ground and the highest angle has a hard stop.

The gear ratio between the deploy motor angle and the mechanism angle is probably `96`, but this had to be deduced empirically during testing since the provided design doc value was incorrect.

Be sure to note these physical constants somewhere.

> Hint: Think of an appropriate convention for the intake angle, then define `MIN_ANGLE` and `MAX_ANGLE` constants.

#### Initializing the Motors
Our intake subsystem has two TalonFX motors, `deployMotor` and `rollerMotor` respectively. Initialize both in `IntakeSubsystem`.

Place motor ID constants in `IntakeConst`.

#### Configuring the Motors
Make sure to set up motor configurations for both `deployMotor` and `rollerMotor` in `IntakeConfig`. Using `SpindexerConfig` as a guide, set each motor's `StatorCurrentLimit`, `NeutralMode`, and `InvertedValue`.

Both motors should be set to coast in order to make manual movement easy. Although the intake angle mechanism is affected by gravity, it isn't very dangerous, and being able to manually stow it is important. During operation, the motors can be directly set to brake if needed.

Additionally, the intake angle mechanism has a gear reduction, so set `Feedback.SensorToMechanismRatio` to the given constant. This makes it so that the motor's reported angle is the gear-reduced mechanism angle instead of the raw *rotor position*.

Be sure to document any conventions and placeholder values.

Now, create a parameterless constructor in `IntakeSubsystem` that applies motor configurations to `deployMotor` and `rollerMotor`.

##### Software Limit Switches
The intake angle has physical limits on how far it can go. We need to configure the motor to stop applying force in a certain direction when it passes these limits.

TalonFX has a very useful configuration setting for this already, under the `SoftwareLimitSwitch` section.

To turn on the limit switch for the forward/positive direction (position is increasing numerically), using `ForwardSoftLimitEnable` setting, and then set the `ForwardSoftLimitThreshold` to the position (usually defined earlier as a physical constant). Don't forget to convert correctly.

The reverse/negative direction is done in the same way. Both forward or reverse limits can be enabled at once, or just one, or none.

Configure the correct limit thresholds for the intake deploy motor.

#### Intake Position
The motor can track its position, but only when the robot is on. The motor does not know where it is when the robot starts up (the code initializes).

Our spindexer motor did not have to know its position so it was not a concern there.

There are two ways to correctly measure mechanism position:
1. Put the mechanism in a known position upon startup such as at a hard stop. Initialize the motor angle to that known position; after startup, the internal motor sensor can correctly keep track of changes.
2. Include a device called an encoder in the mechanism, which measures angles correctly even while the robot is off.
  - Note: can only measure angles within one full rotation when robot is off; number of full rotations is lost.

The intake does not include an encoder because approach 1 works. This means that the intake must always be *stowed* to the upper hard stop when the robot initializes. If it is not, the position will be wrong which can lead to extremely dangerous movements.

In the `IntakeSubsystem` constructor, after configuring the motors, use the `setPosition()` method on `deployMotor` to set its starting position to the max angle upon startup. Be sure to convert units correctly.

> Tip: Save your code periodically, to automatically format the code.

#### Adding Intake to the Robot
In `Robot.java`, add an instance of `IntakeSubsystem` as another field under `spindexer`.

#### Using the Roller Motor
To put our intake subsystem together, `deployMotor` and `rollerMotor` need methods that tell them how to function. Let's start with `rollerMotor`.

`rollerMotor` controls the rollers on the intake that spin to pull in fuel, so we will need methods to turn them on and off.

First, create a convenience method `moveRollerSpeed()` that sets `rollerMotor` to the desired input speed. You may reference `moveMotorSpeed()` in `SpindexerSubsystem` if needed.

Next, use `moveRollerSpeed()` to create two more methods, `rollersOn()` and `rollersOff()`. `rollersOn()` should set the roller speed to a defined constant.

Also create a method `rollersReverse()` that runs the rollers in reverse at a defined speed. This could be used to expel fuel jammed in the intake.

#### Java Units Library
In robotics programming, one common problem is documenting the units of physical measures and values. For example, if a height is in feet or meters.

Or, for example, look at your intake software limit thresholds. You have to convert it to degrees manually. But imagine if you forgot to convert, then it would be very hard to notice just by reading the code.

To solve this, there is an optional library (package) called the `Units` library which provides classes that document this directly in the variable type, in addition to making unit conversions explicit and automatic.

**Read the Units library documentation [here](https://docs.wpilib.org/en/stable/docs/software/basic-programming/java-units.html)**, skipping the `Using Composite Unit Types` section, and reading up to and including `Human-readable Formatting` section.

##### Units Summary
(Please read the documentation before continuing to this section.)

A measure holds a specific quantity of some physical thing, e.g. one measure could be `180 degrees` or `0.5 rotations`. The variable type you use for them is something like `Angle`, the type of quantity, *not a unit like `Degrees`*, because measures can be expressed in any unit.

*To create measures*, that is where units come in. You cannot say `Angle myAngle = 5;` because the unit is unknown. Instead, you say set `myAngle` to "rotations of 5" (aka 5 rotations). \
`Rotations` is the unit, `of` is the static method, `5` is the double. 
```java
Angle myAngle = Rotations.of(5.0);
// Angle myAngle = Degrees.of(5 * 360); // equivalent
```

However, say you need `myAngle` in a `double` (number) form. \
*To convert an existing measure to a number*, you have to specify the unit. You can't say `double numberDegrees = myAngle.convert();` because you didn't specify the unit. \
Instead, you say set `number` to "myAngle in degrees". `myAngle` is the object, `in` is the method, `Degrees` is the unit.
```java
double numberDegrees = myAngle.in(Degrees);
```

Some basic math operations are provided for `Angle`. You can use the `add()` method to add together two angles, and it will handle the unit conversions automatically. Similarly, you can write `myAngle.div(Seconds.of(1.0))`, which returns an `AngularVelocity` measure.

##### Units Refactoring
Convert your min angle and max angle constants to measure objects. Then fix their usages.

> Tip: `Ctrl`/`Command`+`Click` on a name to go to its declaration. \
> Then, `Ctrl`/`Command`+`Click` on its name in the declaration to show where it is used (its *references*).

From now on, you should use measure objects when possible, especially for angles. For example, return an `Angle` object instead of a `double` for a method that gets the intake angle.

#### Using the Deploy Motor
`deployMotor` is in control of pivoting the intake subsystem up and down. We will need methods to move the intake subsystem down (deployed) and up (stowed) using this motor.

First, we'll create a convenience method for changing the intake subsystem angle named `moveAngle`. This method will be slightly more complicated than the others because it controls a mechanism angle, not a mechanism spin speed, which comes with stricter mechanical limitations similar to an elevator.

Since we will be using the Units library, make sure the parameter of `moveAngle()` is of type `Angle`.

Since we want the intake to move to a certain angle and stop, we can't just set the deploy motor speed with `set()` and move on. We'll have to use a *control request*.

In the body of `moveAngle()`, call the `setControl()` method on `deployMotor`. The argument will be a new `MotionMagicVoltage` instance created with the given angle as the constructor argument.

<details><summary>Method code</summary>

```java
public void moveAngle(Angle angle) {
deployMotor.setControl(new MotionMagicVoltage(angle));
}
```

</details>

##### Adding Safety Limits
However, this method is currently unsafe because it doesn't have any safety limits or checks. If someone were to set the angle past the subsystem's mechanical limitations, the intake could break itself.

You should always implement software limits that protect the hardware limits, preventing buggy code from physically breaking the robot.

A safe angle for the intake to move to must be between the values `MIN_ANGLE` and `MAX_ANGLE` in `IntakeConst`.

We could add a check that skips the movement if the input is outside of that range, a perfectly valid safety check.

But in order to prevent confusion and improve usability, we will instead *clamp* the input to be between `MIN_ANGLE` and `MAX_ANGLE`; if it is outside of the range, then it is set to be `MIN_ANGLE` or `MAX_ANGLE` instead.

At the start of `moveAngle()`, define an`Angle` variable called `targetAngle`, which we will initialize to the angle parameter but clamped.

Here is how to clamp the angle:
- First, convert the angle into a unit such as `Rotations`, using the `in()` method
- Second, pass that value into `MathUtil.clamp()` as the first argument
- Third, add in the clamp units as the second and third arguments: minimum angle in the same unit for second argument, maximum angle in same unit for third argument
- Fourth, convert that entire expression (which evaluates to a `double`) into an `Angle` using the `Rotations.of()` static method

> Tip: Hover over the `clamp` method name to see the documentation on how to use it.

```java
Angle targetAngle = Rotations.of(MathUtil.clamp(angle.in(Rotations), IntakeConst.MIN_ANGLE.in(Rotations), IntakeConst.MAX_ANGLE.in(Rotations)));
```

Now replace `angle` with `targetAngle` in the `MotionMagicVoltage` constructor.

The intake can no longer be set to unsafe positions.

#### Deploying and Stowing Intake
For most use cases, we only need the intake to either be deployed or stowed. Create two methods, `moveDown()` and `moveUp()`, that move the intake to its minimum angle (deployed) and its maximum angle (stowed) respectively.

Since we have methods to move both `deployMotor` and `rollerMotor`, we can put them together to create final `deploy()` and `stow()` methods for the intake subsystem. Your `deploy()` method should turn on the rollers and move the intake down, and your `stow()` method should turn off the rollers and move the intake up.

#### Intake Bindings
We'd like to use a controller to move the subsystems.

Open `Robot.java` file and locate the constructor.

We want the intake subsystem to be controlled by the D-pad on the driver controller, down button for deployed and up button for stowed.

Let's set the down button on the D-pad (aka POV Hat) to deploy the intake, and then set the up button to stow the intake.

At the end of the method, start with the code `controller.povDown()`. Since we want code to activate upon pressing it, use the `onTrue()` method of the trigger.

Then pass in the appropriate command for deploying the intake (with rollers on).

```java
controller.povDown().onTrue(intake.runOnce(intake::deploy));
```
Breaking it down: \
*The `driverController`'s `povDown()` trigger, when it is pressed (`onTrue()`), shall run an `intake` subsystem command (from `runOnce()`) that instantly calls the `deploy()` method (`intake::deploy`).*

Add another statement for stowing the intake (including rollers) upon pressing the `povUp` controller button.

> Reminder: You must document controls in the README.

#### Retrieving Intake Angle
Just like with the spindexer, we want to be able to see information about the intake subsystem in the dashboard.

Declare a new method to get the current angle of the intake.

Since we are retrieving position instead of motor speed, we will be using the `getPosition()` method instead of `get()`. `getPosition()` will give us the motor's position as a `StatusSignal<Angle>`. This `StatusSignal` has two useful methods, `getValue()` (returns its `Angle` object) and `getValueAsDouble()` (returns its angle in rotation as a `double`.

Now we have to add this angle to the dashboard. Start by overriding the `initSendable` method in `IntakeSubsystem` (be sure to autocomplete with the suggestion).

Create a property for the intake angle using the `addDoubleProperty()` method of builder. You can call this property `angle (deg)`.

For the getter, use a lambda expression that calls `getAngle()` and converts the value to degrees (Java Units library).

For the setter, try to use the `moveAngle()` method for it.

> Hint: The setter lambda expression takes a double, converts it into an angle, and then calls `moveAngle()`.

Be sure to add the intake subsystem to the dashboard in `Robot.java`!

#### Robot Constructor Refactoring
In `Robot.java`, notice that the robot constructor currently performs two different tasks: adding sendables to the dashboard, and initializing bindings.

To better organize the code, extract out these tasks into separate methods, `initDashboard()` and `initBindings()`.

### Launcher Assembly
Now we can start on the subsystems that make up our *launcher assembly* (feeder, hood, shooter, turret).

<sub><sup>Mentors, explain what each subsystem in the launcher assembly is.</sup></sub>

For better organization, create a folder called `launcher` to store all of these four subsystems.

#### Control Area Network
First, a new electrical aspect of the launcher assembly needs to be discussed.

Recall that every device (e.g. motor) on the robot has a unique CAN ID, aka device ID, that is used to identify it. But what is CAN?

CAN stands for Control Area Network, which is the nervous system of the robot. Electrically, it is wired with yellow and green wires.

This system is controlled by a central brain, which is the CAN Bus. The main or default CAN bus is actually the roboRIO itself (the main robot computer). However, additional dedicated CAN buses can be added to the robot to reduce traffic on them.

In code, a `CANBus` object can be instantiated with the registered name of the CAN bus. (It is safe to make multiple instances referring to the same CAN bus.)
```java
new CANBus() // new default CAN bus (usually roboRIO)
new CANBus("launcher") // new CAN bus referring to bus named launcher
CANBus.roboRIO() // new CAN bus explicitly referring to roboRIO
```

Then, these `CANBus` objects may be passed into device constructors:
```java
private final TalonFX motor = new TalonFX(SubsysConst.MOTOR_ID, SubsysConst.CAN_BUS);
```
If no `CANBus` is provided, then the device defaults to using the default `CANBus`.

If a device is put on the wrong `CANBus` in code, then it will not work. Be sure that any electrical CAN bus changes are immediately updated in the codebase.

For the launcher assembly, all subsystem devices use a CAN bus with the name `launcher`, *except for the feeder subsystem*.

#### Feeder Subsystem
We'll set up the feeder subsystem first.

The feeder subsystem will be nearly identical in functionality to the spindexer.

First, make your `feeder` folder and the three files inside it. Populate any basic constants or configurations, adding placeholders and comments when necessary.

Also create a new `CAN_BUS` constant in `FeederConst`, initialized to a `new CANBus()` (no arguments).

For the `TalonFX()` motor constructor, pass `FeederConst`'s `CAN_BUS` in as the second argument. We are doing this to be explicit since the feeder is the exception in the launcher.

##### Feeder Requirements
From here, you can write the rest of `FeederSubsystem.java` on your own. It should have:
- A motor configured with:
  - Stator current limit (untuned)
  - Neutral mode set to coast
  - Motor direction with intuitive convention (untuned)
- Method to set motor speed
- Methods to start, stop, brake, and reverse
- Method to get the current motor speed
- Correctly initialized dashboard properties
- Appropriate documentation and comments
- Appropriate code organization according to our codebase conventions
- Subsystem is properly initialized inside `Robot`

You do not have to add bindings or a default command for the feeder yet; we will do that when all subsystems of the launcher are set up.

You may reference:
- 1st, spindexer or subsystem that you wrote earlier (do not copy-paste)
- 2nd, other trainees (not their code), if possible
- 3rd, mentors

You may not reference AI, browser, or outside people for writing the simple feeder subsystem.

Once you complete the feeder, a mentor will show you any mistakes or problems.

<details><summary>Potential problems</summary>

- Forgot to initialize subsystem as a field in `Robot`
- Forgot to send feeder to `SmartDashboard` in `Robot.initDashboard()`
- Forgot to extend from `SubsystemBase`
- Missing or inaccurate modifiers
- Incorrect naming convention of symbol
- Forgot to document unit of dashboard property in the label
- Did not add setter for dashboard property
- Did not write any Javadoc comments
- Did not write any TODO comments
- Forgot to document direction convention
- Constant or config field declared in wrong place
- Placed files directly inside `launcher` folder instead of new `feeder` subfolder

</details>

#### Hood Subsystem
Next, we'll create our hood subsystem.

The hood subsystem will work similarly to the `deployMotor` in `IntakeSubsystem`.

Before you start, think of what convention you want to use for the hood's position. (There are really two acceptable options.)

##### Hood Specifications
Info:
- Hood motor is on the launcher CAN bus
- Fuel is shot perpendicularly to where the hood points
- Hood has one hardstop usable for stow, but has no encoder
- The hardstop is at `16.394` degrees above the horizontal; or equivalently, the maximum fuel launch pitch is `73.606` degrees above horizontal
- The hood gear ratio, rotor to mechanism, is `24:1`

Notes:
- The term for hood position/angle is *pitch*
- There is no second hardstop, but the useful range of the hood for launching is obviously physically limited

**Requirements:**
- A motor properly initialized and configured
- Method for moving hood pitch, with appropriate safety
- Method to stow hood
- Method to get pitch of hood
- Appropriate dashboard properties
- Correct conventions and documentation

You do not have to add bindings or a default command for the hood yet; we will do that when all subsystems of the launcher are set up.

Same rules for referencing information as the feeder.

<details><summary>Additional potential problems</summary>

- Did not configure `Feedback.SensorToMechanismRatio` to gear ratio
- Did not configure software limit switches for both directions
- Did not clamp angle parameter in method to move pitch
- Inconsistent usage of pitch convention
- Forgot to document pitch convention
- Did not use Units library
- Used a name other than `motor` (the most concise) for the motor field
- +Potential problems listed from feeder section

</details>

##### Recording the Setpoint
One thing that our code is not aware of is what the current target angle is. The target position of a mechanism is called its *setpoint*.

Take a minute to think of how you could implement a field that always has the current target pitch. You would not need to make any additional method calls.

The way that you can easily implement a field that has the setpoint is by updating the field inside of your hood movement method.

The only time that the target pitch changes is when your movement method is called. So, by storing the given pitch in a field when the method executes, the correct setpoint is always accessible later.

Define a private `Angle` field named `targetPitch`. Modify your movement method to set the field plus use the field for the request.

Then use `targetPitch` to add a new dashboard property.

In general, these setpoint fields should be used for any movement that uses a control request instead of `set()` or `setVoltage()` methods.

Once you are done with this, go back to `IntakeSubsystem` and implement a setpoint field and dashboard property for the angle.

#### Shooter Subsystem
The shooter subsystem has two motors both connected to the same axle, to provide extra force for launching the fuel using flywheels.

The CAN bus for both motors is the `launcher` one.

##### Leader and Follower Motors
Before we start on the shooter subsystem, we have to learn how leader and follower motors work.

With `TalonFX`, you can designate certain motors as leaders and certain motors as followers. Leader motors are controlled directly by the program, while follower motors automatically mirror what the leader does (voltage, duty cycle, `MotionMagicVoltage`).

This is much more reliable than manually setting both motors to be the exact same output and makes it easier to write subsystems where the motors move in sync, like our double motor shooter.

The follower can either be set to go in the same direction or opposite direction as the leader.

In our case, if the shooter motors don't apply the same output or go in the wrong directions, it may break the mechanism or motors.

Use the `Follower` control request on the follower motor, immediately in the subsystem constructor, to set a leader and follower.

##### Configuring Shooter Motors
The shooter subsystem will have two `TalonFX` motor fields, `rightLeaderMotor` and `leftFollowerMotor`. Each can be initialized with their respective motor IDs and the same CAN bus from `ShooterConst.java`.

Both motors will use the same motor configuration, `motorConfig`, in `ShooterConfig.java`. Make sure to set both current limits. Since they are flywheels, coast is best here.

Note: The positive direction is set to whatever would be the "shooting" direction for the leader motor (in this case the right shooter motor).

Create a constructor for `ShooterSubsystem` and apply this configuration to the left and right motors. Since we want them to be leader and follower, there is one additional configuration step to take. Beneath where you applied the motor configuration, add this line:

```java
leftFollowerMotor.setControl(
new Follower(rightLeaderMotor.getDeviceID(), MotorAlignmentValue.Opposed));
```

We call the `setControl()` method on a follower motor to specify how we want it to behave. The first parameter is the ID of the leader motor it should listen to, and the second dictates if it will spin in the same or opposite direction to its follower. In order to shoot fuel properly, the left motor will have to invert  the direction of the right (`MotorAlignmentValue.Opposed`).

##### Shooter Movement Methods
To start, make a field to store the target angular velocity of the shooter subsystem at all times. The type is `AngularVelocity`.

Then, we need to make a method that sets the shooter motors to any desired velocity. Create a method called `moveAngularVelocity` that updates the value of `targetAngularVelocity` and sets the right leader motor to a specific speed (the left does not need to be set, it will mirror automatically). Ensure that the magnitude of this velocity is within the shooter's limitations (`MAX_ANGULAR_VELOCITY`).

Create a method `stop()` that stops the shooter motors and updates `targetVelocity` accordingly.

We may want to be able to enable and disable the shooter independently of the rest of the launcher assembly, for testing purposes or streamlining commands. Underneath where you created the `targetAngularVelocity` field, add a field that can track whether the shooter subsystem is enabled or not.

In your `moveAngularVelocity()` method, add a check to see if the shooter subsystem is enabled. If it is disabled, prevent the motors from moving.

Next, you'll want to make a getter method for the shooter's angular velocity. While we could use `motor.get()` to retrieve the speed as a fraction between `-1.0` and `1.0`, we want a more specific value so we can better test our shooter. For this, we can use the `getVelocity()` method in place of `get()`, which returns the motor's velocity in rotations per second (rps) instead. 

Remember that `getVelocity()` returns a `StatusSymbol<AngularVelocity>` value that you'll have to convert into `AngularVelocity` with `getValue()`.

Your method should look like this:
```java
public AngularVelocity getAngularVelocity() {
return rightLeaderMotor.getVelocity().getValue();
}
```

Add both the shooter's angular velocity (using `getAngularVelocity()`) and the recorded `targetAngularVelocity` into an `initSendable()` method. Remember to convert the values you pass in to rps using the Units library (`.in(RotationsPerSecond)`).

The retrieved angular velocity should not have a setter passed in, but the target angular velocity field should. Use a lambda expression to pass an inputted angular velocity into the `moveAngularVelocity()` method.

Also add the `enabled` property to your `initSendable()`. You can do this with the `addBooleanProperty()` method. For the getter, use a lambda expression that takes in no parameters and checks the value of `enabled`. The setter should also be a lambda expression, one that takes in a parameter `enabled`, checks if it is true, and updates the value of 'enabled' accordingly.

<details><summary> All properties should look like this: </summary>

```java
       builder.addDoubleProperty(
                "angular velocity (RPS)", () -> getAngularVelocity().in(RotationsPerSecond), null);
        builder.addDoubleProperty(
                "target angular velocity (RPS)",
                () -> targetAngularVelocity.in(RotationsPerSecond),
                (double angularVelocity) -> moveAngularVelocity(RotationsPerSecond.of(angularVelocity)));
        builder.addBooleanProperty(
                "enabled",
                () -> enabled,
                (enable) -> {
                    if (enable) enabled = true;
                    else enabled = false;
                });
```
</details>

#### Turret Subsystem

##### Motors vs Encoders
The turret subsystem has both a motor and an **encoder**. Encoders are sensors we use to track motor position, separate from the motor itself.

Initialize the motor and encoder to start. Encoders are initialized similar to motors, but they are of type `CANCoder` instead of `TalonFX`. Both will need placeholder motor IDs in `TurretConst` and the same `CAN_BUS` as the hood subsystem passed into their constructors.

Configure the turret motor with a stator current limit of `30` and make it brake when output is neutral.

You will need to make a configuration for the encoder as well (object type `CANcoderConfiguration`).

In a separate `static` block, set two properties of your encoder configuration:
`MagnetSensor.MagnetOffset` to the value `-0.444`. This represents the angular displacement between the encoder's true (mechanical) zero position and the one reported by the encoder itself.
`MagnetSensor.SensorDirection` to an enum value of `SensorDirectionValue` (similar to the motor's `MotorOutput.Inverted` field, we will determine this in testing)

Also enable and set forward/reverse limit switches for the turret motor.

Be sure to set a stow yaw for our turret (upon stow/startup) as a constant.

We will also need to store our *encoder to mechanism ratio* as a constant. This value is the number of encoder rotations recorded for every mechanism rotation, and will be useful for conversions. Set it to `8.5`.

Because we're using an encoder, there are some additional steps we'll take when configuring the motor. `TalonFXConfiguration` objects also have a `Feedback` field where we can set and configure the motor's *feedback source*. In this case, our encoder readings are the "feedback" we give to the motor; the motor receives its exact position and can adjust accordingly.

First, we'll set the motor config's `Feedback.FeedbackSensorSource` field to a value of the `FeedbackSensorSourceValue` enum, `RemoteCANcoder`.

Now set the `Feedback.FeedbackRemoteSensorID` property to the encoder ID you declared earlier.

Lastly, set the `Feedback.SensorToMechanismRatio` property to your encoder to mechanism ratio value.

Apply both configurations in the `TurretSubsystem` constructor.

Similar to the hood, the turret should also have a target field for setpoints. Create an `Angle` called `targetYaw` that will be updated when we change the turret position.

The turret subsystem should also have an `enabled` field for testing purposes.

##### Turret Movement Methods
To start, write a method that returns the current turret yaw in rotations. Note that the `getPosition()` method will read the CANcoder instead of the motor, and already accounts for the encoder to mechanism ratio (no conversion needed).

We will write two methods to move the turret, one that sets it to the exact inputted position and one that calculates the best possible position to move to that still faces the correct direction. Let's start with the former.

Our first method will be called `moveRawYaw()`. Make sure to check that the turret is enabled before trying to change its position.

In the method body, update `targetYaw` to the new setpoint. Remember to clamp the new value between the turret subsystem's `MIN_ANGLE` and `MAX_ANGLE`.

After you update `targetYaw`, use a new `MotionMagicVoltage` request to move the turret motor. 

Use this `moveRawYaw()` method in a new method to stow the turret.

Our second movement method, which calculates the best possible turret position, will be named `moveYaw()`. 

Because the turret can make more than one full rotation within its mechanical limitations, there will sometimes be two yaw values the turret could move to in order to point the same direction. These yaw values are considered **coterminal**, because they are different angles that point the same way. One of these positions will be closer for the turret to move to than the other. Now, you'll write a method that calculates the distance the turret would need to move to each point and chooses the shorter distance.

To start, create two `double` values to store the turret's current yaw and the desired (input) yaw.

To make our calculations easier, we are going to treat the position we want to end up (our *desired* yaw) as if it's at `0.0` rotations. In other words, we are changing our *frame of reference* and writing all other yaw values in terms of how far they are from our desired yaw. 

Let's start by creating a new variable to store the turret's current yaw relative to our desired yaw, called something like `relCurrentYaw`. To do this, simply subtract the desired value from the current value.

Create two more variables to store the turret's minimum and maximum angles, relative to our desired yaw.

Now we can look for the best position to set the turret in order to point in the desired direction. The yaw value we're looking for will have to be:
The closest value to our current yaw that is also **coterminal** to our desired yaw
Within the mechanical limits (max and min angles) of the turret

Let's start by finding the closest coterminal yaw value to our current yaw. Because we're considering our desired yaw to be `0.0` right now, finding the potential coterminal values are easy; they will all fall exactly one rotation away from each other, so our possible coterminal yaws are simply `0`, `1`, `2`, `-1`, `-2`, etc.

This means that finding the closest coterminal angle to our (relative) current yaw is just a matter of rounding that value to the nearest integer.

Now that we've found the angle we want, let's make sure it's within the turret's mechanical bounds.

Determine the smallest and largest coterminal angles that the turret could move to within its minimum/maximum angles. Use the `Math.ceil()` and `Math.floor()` methods.

Clamp our closest coterminal angle between these new limitations to make sure we don't break the turret.

We have to convert the yaw value we found back to the turret motor's frame of reference before we move anything. Add our desired yaw value back to this angle to do so.

Lastly, use your `moveRawYaw()` method to point the turret in our desired direction!

We will also need a `calibrateYaw()` method that correctly calibrates the encoder position based on where we think the turret is. 

We need this method because the encoder has many rotations per mechanism rotation, but it only tracks the position within one rotation on boot, so it could be off by a whole number of rotations on startup. Only the phase of the encoder is always correct.

To calibrate the encoder, our method will use a "guess" of the current yaw (passed into the method) and the encoder's current position (off by whole rotations) to determine what the encoder position should be set to.

The method finds the coterminal (off by whole rotations, so some phase) encoder position the closest to the guess, and then sets the encoder position to that.

First, make sure our inputted guess yaw is actually within the range of valid turret yaws.

Next, you'll need two `double` values; the encoder's current position and our guessed position (which should be converted into encoder rotations).

To figure out how far off our encoder measurement is, we want to take the difference between its current position and our guess position. However, since our guess rotation is not exact, we want to *round* this result to the nearest rotation. This value gives us the offset between where the encoder thinks the turret is and where it actually is.

Make sure to clamp this value between the possible range of offsets so we aren't setting the encoder to an invalid position!

Remember to add the measured encoder position back to your clamped offset to find the coterminal encoder position closest to your guess yaw.

Finally, use the `setPosition()` method to update the encoder to your new calibrated position.

Another useful piece of information here would be the turret's yaw error, or the difference between the desired and current yaw. Create a method called `getYawError()` that retrieves this difference.

A little bit of error is expected and okay, but error past a certain set tolerance becomes an issue.

Let's start with a yaw error tolerance of `3` degrees. Save this value in your config file.

In `TurretSubsystem.java`, create a method that compares the current yaw error with this value, and returns whether or not it is still within tolerance.

Now we can start adding turret information to the dashboard. In a new `initSendable()` method, initialize the following properties:
Turret status (enabled/disabled)
Current yaw (all angles should be in degrees)
Target yaw 
Yaw error
Whether or not the error is within tolerance

<details><summary>Your final method should look like this:</summary>

```java
@Override
    public void initSendable(SendableBuilder builder) {
        builder.addBooleanProperty(
                "enabled",
                () -> enabled,
                (enable) -> {
                    if (enable) enabled = true;
                    else enabled = false;
                });
        // Use this dashboard property setter to calibrate yaw if necessary after startup
        builder.addDoubleProperty(
                "YAW (deg)",
                () -> getYaw().in(Degrees),
                (guessYaw) -> calibrateYaw(Degrees.of(guessYaw)));
        builder.addDoubleProperty(
                "target yaw, raw (deg)",
                () -> targetYaw.in(Degrees),
                (yaw) -> moveRawYaw(Degrees.of(yaw)));
        builder.addDoubleProperty("yaw error (deg)", () -> getYawError().in(Degrees), null);
        builder.addBooleanProperty("within tolerance", this::withinTolerance, null);
    }
```
</details>

### Automatic Targeting

#### Aiming The Turret

The point of having a turret subsystem is to aim at the hub and score regardless of the robot's present rotation. While we could have the driver aim it manually, it would be a lot slower and less accurate than performing the calculations in code. We want to write a method in `turretSubsystem.java` that reads the current robot position and determines which way the turret needs to aim.

This might seem like a complicated task, but we'll break down the calculations and make it easier to follow.

> Note: In the original rebuilt robot's codebase, Anthony implemented a more complicated "shoot on the move" algorithm that accounted for robot velocity as well as position. These calculations are too complicated to teach in this training, so our goal will be making the robot aim accurately towards the hub at a standstill.

Let's work with a simpler problem to start. Assume the robot's rotation is always 0 (facing away from the driverstation) as we drive it around the field. All we have to do is determine the angle $\theta$ (pronounced *theta*) between the turret's current direction and the direction we want it to face (towards the hub), which will be the change in yaw for the turret.

Since we have both the robot and hub positions (as FCS coordinates), the calculations come down to basic trigonometry. We can draw a straight line from the robot's center to the hub's center and use this as a hypotenuse for a right triangle, where the legs are the change in x and y values respectively.

The $\theta$ will be the angle we want to find, the difference between the robot's current orientation and the way it must face to aim at the hub. 

Since we have the x and y coordinates of both the robot and the hub (FCS), we can solve for the side lengths of the right triangle's legs. 

Now we can use a trigonometric function known as *tan*, which relates the value of an angle $\theta$ to the ratio of its opposite and adjacent sides in a right triangle. It looks like this:

$$
\tan\theta = \frac{opposite}{adjacent}
$$

Since we know the values of both the opposite and adjacent sides from the angle we want to find, we can substitute those in and solve the expression.

$$
\tan\theta = \frac{x}{y}
$$

In order to solve for $\theta$, we have to get rid of the tan somehow. For this, we can use an inverse trigonometric function, which essentially "undoes" a normal trigonometric function when applied. The inverse function of tan is known as arctan.

Applying it here looks like this:

$$
\arctan(\tan\theta) = \arctan(\frac{x}{y}) \\
\theta = \arctan(\frac{x}{y})
$$

Now we have an expression for $\theta$ with all known values, meaning we can solve for the desired turret yaw at any point.

But what about when the robot's rotation isn't 0?

In this case, we have to add an offset to our calculated target yaw to "cancel out" the robot's rotation. This is a much simpler calculation to make; for example, if the robot is rotated 90 degrees to the right from 0, we can just rotate the turret 90 degrees to the left to offset it. 

To generalize to any yaw, we can subtract off the current turret rotation, which gives us the extra amount of rotation needed from the current position.

Of course, shooting fuel into the hub requires more than just aiming in the right direction. There are two other factors we have control over; the pitch of the fuel (what angle the hood is at) and the launch speed (how fast we run the shooter motor). To make calculations easier, we'll use a fixed value for pitch (ex. 60 degrees) and solve only for launch speed.

#### Projectile Motion Mini-Lesson

<sub><sup>Mentors, explain projectile motion pls </sup></sub>

#### Determining Launch Speed

In order to simplify our calculations, we will assume the effects of air resistance on the fuel are negligible.

To solve for launch speed, we'll be looking to relate what we know (vertical and horizontal distances from the launcher to the target) with what we're trying to find (launch speed). The easiest way we can do this is by writing an equation for this relationship, so let's go through how we'll set up the calculations!

It will be much easier to solve for launch speed if we break it up into its horizontal and vertical components, v<sub>x</sub> and v<sub>y</sub>. Think of these components as the legs of a right triangle, with the combined velocity as the hypotenuse; using $\theta\ as our initial launch angle, we can write v<sub>x</sub> and v<sub>y</sub> as:
$$
v_x = v\cos\theta \\
v_y = v\sin\theta
$$

Now that we've separated v into components, we can write separate motion equations for the horizontal and vertical movement of the fuel as it is launched towards the hub. For these equations, let x and y represent the horizontal and vertical displacement of the fuel in its path.

Since we're ignoring air resistance, we can assume the fuel's horizontal velocity will remain constant. 

We want to write an equation relating the fuel's horizontal velocity to something we know, like the distance it travels. Remember that:
$$
velocity = \frac{distance}{time}
$$

In our case, we can rewrite this definition as
$$
v_x = \frac{x}{t}
$$
Where t represents the time the fuel has been in the air.

Our equation for vertical motion will be more complicated, due to gravity exerting a constant acceleration downwards on the fuel. This means our vertical velocity component, v<sub>y</sub>, will be decreasing as the fuel travels through the air.

We'll start with a well-known kinematics equation, something you might see in Honors or AP Physics. These equations are meant to model the motion of an object in terms of variables like its initial position, velocity, and acceleration. The equation we'll use looks like this:
$$
displacement = v_0t + \frac{1}{2}at^2
$$
In this equation:
displacement is how far the object has traveled from its starting point
v<sub>0</sub> is the *initial velocity* (launch speed) of the object
a is a constant *acceleration* being applied to the object
t is the time elapsed since our object's release
We want to rewrite this equation to fit our specific scenario. Our displacement will be the fuel's vertical displacement (y), our initial velocity will be the launch speed's vertical component (v<sub>y</sub>), and our acceleration will be the acceleration applied by gravity (g).

Rewriting the equation:
$$
y = v_yt + \frac{1}{2}gt^2
$$

Now we have two equations, each modeling the fuel's horizontal and vertical motion:
$$
v_x = \frac{x}{t}
y = v_yt + \frac{1}{2}gt^2
$$

You'll notice that, in both these equations, we have *two* unknown variables. This means we can't solve for launch speed using only one; we'll have to solve them as a system of equations.

If you're confident with solving systems, we highly recommend doing the calculations yourself! If you'd like to see a sample solution, it's written below:  

<details><summary> Sample Solution </summary>. 

In order to make an equation with only one unknown variable, we'll solve one of the two equations for t. Then, we can substitute that expression for t into the other equation and simplify.

Let's solve the horizontal motion equation for t:
$$
v_x = \frac{x}{t} \\
(\text{multiply both sides by t})\implies tv_x = x \\
(\text{divide both sides by }v_x)\implies t = \frac{x}{v_x}
$$

Now we can substitute this expression for t into our vertical motion equation:
$$
(\text{original equation})\implies y = v_yt + \frac{1}{2}gt^2 \\
(\text{substitute in }t = \frac{x}{v_x})\implies y = v_y(\frac{x}{v_x}) + \frac{1}{2}g(\frac{x}{v_x})^2
$$

You'll notice that we still have two unknown variables, v<sub>x</sub> and v<sub>y</sub>. Luckily, both can be written in terms of v instead:

$$
v_x = v\cos\theta \\
v_y = v\sin\theta
$$

Substituting these into our vertical motion equation:
$$
y = v_y(\frac{x}{v_x}) + \frac{1}{2}g(\frac{x}{v_x})^2 \\
(\text{substitute in }v_x \text{ and }v_y)\implies y = (v\sin\theta)(\frac{x}{v\cos\theta}) + \frac{1}{2}g(\frac{x}{v\cos\theta})^2
$$

All we have to do now is simplify and solve for v!
$$
y = (v\sin\theta)(\frac{x}{v\cos\theta}) + \frac{1}{2}g(\frac{x}{v\cos\theta})^2 \\
(\text{distribute})\implies y = \frac{x v\sin\theta}{v\cos\theta} + \frac{1}{2}g(\frac{x^2}{v^2\cos^2\theta}) \\
(\text{distribute again})\implies y = \frac{x v\sin\theta}{v\cos\theta} + \frac{g x^2}{2v^2\cos^2\theta} \\
(\text{cancel } v)\implies y = \frac{x \sin\theta}{\cos\theta} + \frac{g x^2}{2v^2\cos^2\theta} \\
(\text{apply tan}\theta \text{ identity})\implies y = x\tan\theta + \frac{g x^2}{2v^2\cos^2\theta} \\
(\text{isolate v on one side})\implies \frac{g x^2}{2v^2\cos^2\theta} = x\tan\theta - y \\
(\text{solve for v})\implies gx^2 = 2v^2\cos^2\theta(x\tan\theta - y) \\
\frac{gx^2}{x\tan\theta - y} = 2v^2\cos^2\theta \\
\frac{1}{2\cos^2\theta}(\frac{gx^2}{x\tan\theta - y}) = v^2 \\
\sqrt{\frac{gx^2}{(2\cos^2\theta)x\tan\theta - y}} = v \\
\frac{x}{\cos\theta}\sqrt{\frac{g}{2(x\tan\theta - y)}} = v \\
$$ 
\
**Solution**:
$$
v = \frac{x}{\cos\theta}\sqrt{\frac{g}{2(x\tan\theta - y)}}
$$
</details>. 


Now that you've seen the calculations for both turret position and launch speed based on hub position, try creating methods to implement them!

Here are some guidelines:
- The initial pitch of the fuel (the hood angle) should stay at a constant value no matter where you're shooting from
- Your methods should use both robot and hub positions to calculate yaw/launch speed
- Detailed field dimensions (like hub position\height) can be found [here](https://firstfrc.blob.core.windows.net/frc2026/FieldAssets/2026-field-dimension-dwgs.pdf)

#### Putting it Together

Next, we'll implement these methods in `Robot.java` to make the robot automatically aim and shoot when in teleoperated mode.

Similar to our bindings, we'll want to implement automatic targeting as a command that can be scheduled (in this case repeatedly, all the time). To put together our different aiming methods in the turret and shooter, we'll make another method in `Robot.java` to combine them and return a single command.

Create a method in `Robot.java` that returns a `Command`. 

We already know how to write a lambda expression that returns a command to call a single method. But what if we want to call multiple at the same time?

`Commands.parallel()` is a method that takes in multiple commands and returns a new command to run all of them at the same time. Since we want the turret yaw and launch speed to adjust as soon as possible, this is ideal for automatic targeting; we can call both methods repeatedly, without having one wait for the other.

We also want to use the `CommandsUtil.asDefault()` method on the commands we pass into `Commands.parallel()`. `asDefault()` makes it so the command passed in won't be run if its subsystems (requirements) are busy with something else. This allows us to implement things that might interrupt the aiming routine, like fixed shooting (launcher doesn't adjust based on robot position). 

Using both these methods, complete your method to return automatic targeting as one command.

Now that we can get this command more conveniently, let's add it to the robot. We won't be adding this to `initBindings()` (it wouldn't be convenient for the driver to be constantly spamming one button). Instead, it will go into the `robotPeriodic()` method where you added the line to run scheduled commands `CommandScheduler.getInstance().run()`.

We want to schedule our automatic aiming command so that it is run every time `robotPeriodic()` is called. Do this using the line `CommandScheduler.getInstance().schedule()` to schedule your targeting command before running all scheduled commands. 

## Temporary End
The rest of training is being actively written.
