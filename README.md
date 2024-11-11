## Content
- [LAB1 (Matric multiplication)](#LAB1)
- [LAB2 (Words finder)](#LAB2)
- [LAB3 (Students sorter and finder)](#LAB3)
  

## LAB1 
### Theme
Matrix Multiplication and Row Average Calculation

### Running the Program
1. Clone or Download the program file Main.java.

2. Open Terminal or Command Prompt and navigate to the directory where Main.java is located.

3. Compile the Program by running:
```sh
javac Main.java
```

5. Run the Program by executing:
```sh
java Main
```

### Usage
1. Input dimension of matrices:
   
The program prompts you to enter the number of rows and columns for matrice A.
Enter each value as an integer.

2. Input matrices:

After specifying the dimensions, the user must enter each element of the matrices. Each element is entered as a single character.
<br>The program uses ASCII values for calculation

3. Output:

If the dimensions are compatible, the program multiplies the matrices and outputs the result as matrix C.
It also displays the average ASCII value of each row in matrix C.

4. Repeat:

After completion, choose whether to run the program again by entering y (yes) or n (no).

### Example Usage
```typescript
Enter number of rows for matrix A: 2
Enter number of cols for matrix A: 2
Enter elements for matrix A: 
A[0][0]: r
A[0][1]: a
A[1][0]: r
A[1][1]: f
Your matrix A:
r a 
r f 
Enter number of rows for matrix B: 2
Enter number of cols for matrix B: 2
Enter elements for matrix B: 
A[0][0]: 1
A[0][1]: 0
A[1][0]: 0
A[1][1]: 1
Your matrix B:
1 0 
0 1 
Multiplication matrix C:
r a 
r f 
Average value (in ASCII) of elements for each row:
[57.5, 60.0]
Do you want to run the program again? (y/n)
n
```

## LAB2
### Theme
Unique Words Finder

### Running the Program
1. Clone or Download the program file Main.java.

2. Open Terminal or Command Prompt and navigate to the directory where Main.java is located.

3. Compile the Program by running:
```sh
javac Main.java
```

5. Run the Program by executing:
```sh
java Main
```

### Usage
1. Input Text:

The program prompts you to enter a text with at least one sentence. Separate sentences by periods (".").
Example input:
```sh
The cat is at a house. The dog is on a street. I love my house.
```

2. Output:

The program will display unique words from the first sentence that do not appear in subsequent sentences.

3. Repeat:

After completion, choose whether to run the program again by entering y (yes) or n (no).

### Example Usage
```typescript
Enter text (minimum 1 sentence):
The cat is at a house. The dog is on a street. I love my house.
Words that don`t repeat in sentences: [cat, at]
Do you want to run the program again? (y/n)
n
```

## LAB3
### Theme
Students sorter and finder

### Running the Program
1. Clone or Download the program file Main.java.

2. Open Terminal or Command Prompt and navigate to the directory where Main.java is located.

3. Compile the Program by running:
```sh
javac Main.java Student.java
```

5. Run the Program by executing:
```sh
java Main
```

### Usage
1. Define Sorting Fields and Order
   
The program prompts you to choose and enter fields for sorting.

2. Output
   
The program will display the sorted list of students based on the chosen fields.

3. Search for a student
   
The program will then look for a specific student and output whether the student was found.

5. Repeat:
   
After completion, choose whether to run the program again by entering y (yes) or n (no).

### Example Usage
```typescript
Choose primary sorting field (firstname, lastname, age, gender, course): 
course
Choose secondary sorting field (firstname, lastname, age, gender, course): 
age
Sorted students by course and age:
Student:	name=Charlie, lastname=Di, age=19, gender=Female, course=2
Student:	name=Alice, lastname=Maclaren, age=18, gender=Female, course=2
Student:	name=Edward, lastname=Hoggins, age=17, gender=Male, course=2
Student:	name=Bob, lastname=Cawasaki, age=20, gender=Male, course=3
Student:	name=Diana, lastname=Supre, age=22, gender=Female, course=4

Searching for Student:	name=Alice, lastname=Maclaren, age=18, gender=Female, course=2
Found: Yes
Do you want to run the program again? (y/n)
```
