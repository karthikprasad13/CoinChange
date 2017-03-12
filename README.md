# CoinChange

This repository mainly has two working classes [Part1](https://github.com/karthikprasad13/CoinChange/blob/master/src/java/main/solutions/Part1.java) and [Part2](https://github.com/karthikprasad13/CoinChange/blob/master/src/java/main/solutions/Part2.java)

- Part1 has a method countWays(int n) which will count all the possible combinations of making the sum n using coins [1, 2, 5, 10, 20, 25, 50, 100, 200]

- Part2 takes an input csv file and prints the next combination of possibilities using a helper class [InputProcessor](https://github.com/karthikprasad13/CoinChange/blob/master/src/java/main/solutions/InputProcessor.java)

Time complexity of both the classes is O(mn) where n is the sum to be made and m is the total coins that can be used (8 here).
