# Election-Board
```
/Users/subhamsanghai/Library/Java/JavaVirtualMachines/openjdk-17.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA Edu.app/Contents/lib/idea_rt.jar=49895:/Applications/IntelliJ IDEA Edu.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/subhamsanghai/IdeaProjects/Eboard/out/production/Eboard:/Users/subhamsanghai/Library/Application Support/JetBrains/IdeaIE2021.3/plugins/Kotlin/kotlinc/lib/kotlin-stdlib.jar:/Users/subhamsanghai/Library/Application Support/JetBrains/IdeaIE2021.3/plugins/Kotlin/kotlinc/lib/kotlin-reflect.jar:/Users/subhamsanghai/Library/Application Support/JetBrains/IdeaIE2021.3/plugins/Kotlin/kotlinc/lib/kotlin-test.jar ElectionDriver
Enter the citizen information of the city
=========================================
Enter the number of citizens in the city
5
Print name of Citizen 1
A
Print name of Citizen 2
B
Print name of Citizen 3
C
Print name of Citizen 4
D
Print name of Citizen 5
E
Enter the candidate details
=========================================
Enter the number of citizens who want to contest the election
2
Candidate 1
===========================================================
Enter name of Citizen who wants to contest
A
Enter Candidate Symbol
a
Enter Candidate Manifesto
Please enter the number of ideas(Max 3)
1
Please Enter Idea No: 1
IDEA-A1
Candidate 2
===========================================================
Enter name of Citizen who wants to contest
B
Enter Candidate Symbol
b
Enter Candidate Manifesto
Please enter the number of ideas(Max 3)
1
Please Enter Idea No: 1
IDEA-B1
The candidates contesting in election are:
=========================================
====================CANDIDATE: 1 =======================================
Candidate Name: A
Candidate Symbol: a
The Manifesto contains the following ideas
Idea 1
----------
The idea is: IDEA-A1
==========================================================================
====================CANDIDATE: 2 =======================================
Candidate Name: B
Candidate Symbol: b
The Manifesto contains the following ideas
Idea 1
----------
The idea is: IDEA-B1
==========================================================================
=========================================

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
1
Add Rating
=========================================
Enter the name of citizen who wants to add rating
B
Enter the name of candidate he wants to add rating for
A
Enter the idea number he wants to add rating for
1
Enter the rating he wants to give
8
Citizen B is added as a follower of A
Idea IDEA-A1
----------
B	8

Low rating count: 0
High rating count: 1
Total rating: 8
Average rating: 8.0

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
1
Add Rating
=========================================
Enter the name of citizen who wants to add rating
C
Enter the name of candidate he wants to add rating for
B
Enter the idea number he wants to add rating for
1
Enter the rating he wants to give
9
Citizen C is added as a follower of B
Idea IDEA-B1
----------
C	9

Low rating count: 0
High rating count: 1
Total rating: 9
Average rating: 9.0

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
3
Add Idea
=========================================
Enter the name of candidate who wants to add an idea
A
Enter the idea he wants to add
IDEA-A2
Sending notification to citizen: B
Sending notification to citizen: C
====================CANDIDATE: 1 =======================================
Candidate Name: A
Candidate Symbol: a
The Manifesto contains the following ideas
Idea 1
----------
The idea is: IDEA-A1
Idea 2
----------
The idea is: IDEA-A2
==========================================================================

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
1
Add Rating
=========================================
Enter the name of citizen who wants to add rating
E
Enter the name of candidate he wants to add rating for
B
Enter the idea number he wants to add rating for
1
Enter the rating he wants to give
2
Idea IDEA-B1
----------
C	9
E	2

Low rating count: 1
High rating count: 1
Total rating: 11
Average rating: 5.5

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
2
Remove Rating
=========================================
Enter the name of citizen who wants to remove his rating
C
Enter the name of candidate, he wants to remove rating for
B
Enter the idea number he wants to remove rating for
1
Idea IDEA-B1
----------
E	2

Low rating count: 1
High rating count: 0
Total rating: 2
Average rating: 2.0

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
1
Add Rating
=========================================
Enter the name of citizen who wants to add rating
D
Enter the name of candidate he wants to add rating for
B
Enter the idea number he wants to add rating for
1
Enter the rating he wants to give
2
Idea IDEA-B1
----------
D	2
E	2

Low rating count: 2
High rating count: 0
Total rating: 4
Average rating: 2.0

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
1
Add Rating
=========================================
Enter the name of citizen who wants to add rating
C
Enter the name of candidate he wants to add rating for
B
Enter the idea number he wants to add rating for
1
Enter the rating he wants to give
2
Idea IDEA-B1
----------
C	2
D	2
E	2

Low rating count: 3
High rating count: 0
Total rating: 6
Average rating: 2.0

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
1
Add Rating
=========================================
Enter the name of citizen who wants to add rating
A
Enter the name of candidate he wants to add rating for
B
Enter the idea number he wants to add rating for
1
Enter the rating he wants to give
2
Removing B from elections
Idea IDEA-B1
----------
A	2
C	2
D	2
E	2

Low rating count: 4
High rating count: 0
Total rating: 8
Average rating: 2.0

ENTER 1 FOR ADDING RATING
ENTER 2 FOR REMOVING RATING
ENTER 3 FOR ADDING IDEA
ENTER 0 TO EXIT
Please Enter your choice
0
Exiting from the Menu

The Winner is : A with total rating as 8.0

Process finished with exit code 0

```