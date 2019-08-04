# Knapsack Challenge

This is a Knapsack problem [https://en.wikipedia.org/wiki/Knapsack_problem]() that we have to determine the bigger 
packages quantity inside a bag, reaching the bigger weight and cost.

For this, I use the follow strategy: Testing all combinations packages trying to discovery the most value packages.

## Requirements

+ Java 8

```bash
java -version

openjdk version "1.8.0_92"
OpenJDK Runtime Environment (Zulu 8.15.0.1-linux64) (build 1.8.0_92-b15)
OpenJDK 64-Bit Server VM (Zulu 8.15.0.1-linux64) (build 25.92-b15, mixed mode)
```

## Build and Running

```bash
./mvnw clean package
```

```bash
java -jar target/dist/implementation.jar path/to/file.txt
```

### Sample

```bash
java -jar target/dist/implementation.jar data.txt
```

```bash
2019-08-04 15:05:54 INFO  Program:15 - Starting program...
2019-08-04 15:05:54 INFO  Packer:37 - Starting pack to : data.txt
2019-08-04 15:05:54 INFO  TestCaseReader:30 - Reading file from : data.txt
2019-08-04 15:05:54 INFO  TestCaseTransformer:30 - Transforming line : 81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
2019-08-04 15:05:54 INFO  TestCaseTransformer:30 - Transforming line : 8 : (1,15.3,€34)
2019-08-04 15:05:54 INFO  TestCaseTransformer:30 - Transforming line : 75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
2019-08-04 15:05:54 INFO  TestCaseTransformer:30 - Transforming line : 56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)
2019-08-04 15:05:54 INFO  PackageCalculator:29 - Calculating packages : TestCase{maxWeight=81, packages=[Package{index=6, weight=46.34, cost=48.0}, Package{index=4, weight=72.3, cost=76.0}, Package{index=1, weight=53.38, cost=45.0}, Package{index=3, weight=78.48, cost=3.0}, Package{index=5, weight=30.18, cost=9.0}, Package{index=2, weight=88.62, cost=98.0}]}
2019-08-04 15:05:54 INFO  PackageCalculator:29 - Calculating packages : TestCase{maxWeight=8, packages=[Package{index=1, weight=15.3, cost=34.0}]}
2019-08-04 15:05:54 INFO  PackageCalculator:29 - Calculating packages : TestCase{maxWeight=75, packages=[Package{index=2, weight=14.55, cost=74.0}, Package{index=7, weight=60.02, cost=74.0}, Package{index=4, weight=26.24, cost=55.0}, Package{index=5, weight=63.69, cost=52.0}, Package{index=1, weight=85.31, cost=29.0}, Package{index=6, weight=76.25, cost=75.0}, Package{index=8, weight=93.18, cost=35.0}, Package{index=9, weight=89.95, cost=78.0}, Package{index=3, weight=3.98, cost=16.0}]}
2019-08-04 15:05:54 INFO  PackageCalculator:29 - Calculating packages : TestCase{maxWeight=56, packages=[Package{index=4, weight=37.97, cost=16.0}, Package{index=7, weight=81.8, cost=45.0}, Package{index=9, weight=6.76, cost=64.0}, Package{index=3, weight=43.15, cost=10.0}, Package{index=1, weight=90.72, cost=13.0}, Package{index=5, weight=46.81, cost=36.0}, Package{index=2, weight=33.8, cost=40.0}, Package{index=6, weight=48.77, cost=79.0}, Package{index=8, weight=19.36, cost=79.0}]}
2019-08-04 15:05:54 INFO  PackageCalculator:29 - Calculating packages : TestCase{maxWeight=10, packages=[Package{index=4, weight=5.0, cost=40.0}, Package{index=1, weight=2.0, cost=10.0}, Package{index=5, weight=3.0, cost=50.0}, Package{index=6, weight=2.0, cost=60.0}, Package{index=3, weight=4.0, cost=30.0}, Package{index=2, weight=3.0, cost=20.0}]}
2019-08-04 15:05:54 INFO  PackageCalculator:29 - Calculating packages : TestCase{maxWeight=8, packages=[Package{index=1, weight=2.0, cost=10.0}, Package{index=3, weight=6.0, cost=30.0}, Package{index=2, weight=2.0, cost=20.0}]}
```
#### Output
```bash
2019-08-04 15:05:54 INFO  Program:25 - Output:
4
-
2,7
8,9
4,5,6
2,3
```
