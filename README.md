## Content
- [LAB1](#LAB1)
- [LAB2](#LAB2)
  

## LAB1
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
