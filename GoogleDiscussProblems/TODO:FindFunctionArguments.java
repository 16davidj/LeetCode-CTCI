/**
Given a number z ∈ N and a function f(x, y) ∈ N, where x ∈ N and y ∈ N.

Function f(x, y) is black box and unknown but we can pass any x and y to function and get f(x, y) value. f(x, y) is strictly increasing:
f(x, y) < f(x + 1, y)
f(x, y) < f(x, y + 1)

Find all pairs of x and y, where f(x, y) = z.

Example 1:

Input:
f(x, y) = x + y
z = 5

Output:
[[1, 4], [2, 3], [3, 2], [4, 1]]
Example 2:

Input:
f(x, y) = x^2 + y
z = 50

Output:
[[1, 49], [2, 46], [3, 41], [4, 34], [5, 25], [6, 14], [7, 1]]
**/
