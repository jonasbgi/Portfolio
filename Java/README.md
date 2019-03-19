# Pong for Android

## How to run: 
It's not really expected for the reader to get this software running, because it requires the use of Android studio or other 
setup-intensive software. It's therefore not recommended, as it's simply not worth the time. Should you still wish to run, 
please send me an e-mail at [jonas.b.giske@gmail.com](mailto:jonas.b.giske@gmail.com). 

## Note to the reader
This, as many of the projects here, was a collaborative effort. I therefore do not wish to take the full credit. 
To see my work, use the table below. 

Note that all files are in the folder ` /core/src/com/mygdx/game/`

| Type                        | File                        |
| --------------------------- | --------------------------- |
| Abstract class              | Paddle.java                 |
| Subclass                    | AutoPaddle.java             |
| Interface                   | PaddleController.java       |
| Implementation of interface | ManualPaddleController.java |

While an Android game, this also demonstrates simple and (relatively) clean Java Code. Had this been for production, and not a two-week long homework assignment, documentation would be better. 

I wanted to highlight these files, as I feel they demonstrate some of the powers of a compiled and object-oriented langange. By using interfaces and abstract classes, dependency injection is facilitated such that the code is much more reusable. 

## What's not demonstrated 

- The use of docstrings to document the code, and general documentations. 

- The use of the Array.stream() method introduced in Java 8 onwards, which pipelines the loop process. This has a performance advantage over the classic for-loop which does not pipeline. 

``` Java
List<Integer> numberList = new ArrayList(Arrays.asList(1, 2, 3));

//For loop: 
int sum = 0;
for (int number : numberList){
    sum += number; 
}

// Equivalent stream: 
numberList.stream()
    .collect(Collectors.summingInt(i -> i));

// Note: These currently have very similar runtimes if timed. However, this mainly due to the for-loop in the Java VM is heavily optimized over decades, while .stream() is only a few years old and not optimized. 
```

- Names could be better, to indicate classes which were abstract, or which file was an interface. 

- The use of the ternary operator (if-else shorthand):

```Java
int x = 4;
int y = (x > 3) ? 2 : 8; // Selects 2 if x > 3, otherwise 8. 

// Line 2 equals: 
int y; 
if(x > 3){
    y = 2;
} else {
    y = 8; 
}
```



- Native Android code which would use Views and such due to the use of a third-party game library. 
- The use of a package manager such as Maven. 

