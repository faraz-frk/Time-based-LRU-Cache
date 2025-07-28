LRU Cache in Java (with Time-Based Expiry)
==========================================

This project implements a custom Least Recently Used (LRU) Cache using Java,
with additional support for time-based expiration of entries. It uses a 
combination of HashMap and a Doubly Linked List to achieve O(1) time 
complexity for both get() and put() operations.

Features
--------
- O(1) access for both get and put operations
- Time-based expiry: entries expire after a fixed duration
- Efficient use of data structures (HashMap + Doubly Linked List)
- Simple CLI demo included via Main.java

Project Structure
-----------------
LRUCacheProject/
├── LRUCache.java      -> Core cache implementation
├── Main.java          -> Sample usage and test cases
└── README.txt         -> Project documentation

Technologies Used
-----------------
- Java (8 or higher)
- HashMap & Doubly Linked List
- System time (System.currentTimeMillis())

How to Run
----------
1. Open terminal in the project directory
2. Compile the code:
   javac LRUCache.java Main.java
3. Run the program:
   java Main

Sample Output
-------------
[3=Three] [2=Two] [1=One] 
[1=One] [3=Three] [2=Two] 
[4=Four] [1=One] [3=Three] 
Expired Get 3: null
[4=Four] [1=One] 

What I Learned
--------------
- How to implement caching with data structures
- Handling time-based data expiration in Java
- Improved object-oriented and algorithmic thinking

Author
------
Faraz Rahim Khan
(LinkedIn: https://www.linkedin.com/in/faraz-rahim-khan-a59216353)
