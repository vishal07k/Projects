<h1>Library Management System</h1>
<div>
<h3>Languages & Tools Used </h3>
<ul>
<li>JAVA (Swing, AWT, JDBC, OOPS Concepts, Multithreading)</l1>
<li>Database : MYSQL</l1>
<li>Tool : Eclipse (WindowBuilder)</l1>
</ul>
<div>
<h3>Overview</h3>
<div>
<h3>1. Architecture Overview:</h3>
<h5>Frontend (Java Swing & AWT):</h5>
<li>Java Swing and AWT components are used to create the graphical user interface (GUI). </li>
<li>The user interacts with various forms and dialogs to manage library data, such as books and members.</li>
<br>
<h5>Backend (MySQL):</h5>
<li>A MySQL database serves as the backend to store and retrieve data like book details, user records, transactions, etc.</li>
<h5>Business Logic:<h5>
<li>Java classes handle the core functionality, including database connectivity, data processing, and interaction between the frontend and backend.</li>

<h3>2. Modules of the Library Management System:</h3>
<h5>2.1. User Module:</h5>
<h5>Admin Users:</h5>
Admins can add, update, and delete books, members, and other system users.
They also manage the issue and return process.
Library Members:
Members can view available books, check their account status, and request book issues.
Users may also renew or return books.
<h3>2.2. Book Management Module:</h3>
Add New Books:
Admin can add new books with fields such as Title, Author, and Status (available/issued).
Search Books:
Allow users to search books by title, author, ISBN, etc.
<h3>2.3. Transaction (Issue/Return) Module:</h3>
Book Issue:
Admin issues books to members. The system updates book status to "issued" and stores the issue date, due date, and member information.
Book Return:
Admin processes book returns, calculates late fees (if any), and updates the book status to "available."
Renewal of Books:
Users can renew books if there are no pending requests for that book.
<h3>2.4. Member Management Module:</h3>
Add New Members:
Admin can add new members with fields like Name, Address, Contact Details, Membership ID, etc.
Update/Delete Members:
Admin can update or delete member details as necessary.
<h3>2.5. Database Management:</h3>
MySQL Database:
Tables such as Books, user, location, and Admins are created to manage the system's data.

<h3>3. Core Features:</h3>
<h5>3.1. Authentication & Authorization:</h5>
Admins have full access to manage books and members.
Members have restricted access to searching for books and viewing their personal transactions.
<h5>3.2. Database Connectivity:</h5>
JDBC (Java Database Connectivity) is used to connect the Java application with the MySQL database. Queries are executed to fetch, insert, update, or delete records from the database.
<h5>3.3. GUI Components (Java Swing & AWT):</h5>
JFrame: Main window to display the library interface.
JPanel: Used to organize different sections like Book Management, Member Management, and Transactions.
JButton: Buttons for actions like Add, Edit, Delete, Issue, Return, and Search.
JTextField: Input fields for entering book details, member information, etc.
JTable: Displays lists of books, members, or transactions.
JComboBox: Dropdowns for selecting options like book status or membership type.
JLabel: Labels for text instructions or descriptions in the GUI.
<h5>4. Technologies Used:</h5>
Java Swing & AWT for building the GUI.
JDBC for database connectivity.
MySQL as the backend relational database.
Java SE for handling core functionality.
Apache Maven/Gradle for project build management (optional).
<h5>5. Functional Flow:</h5>
Login Screen: Admin logs into the system.
Dashboard: Admin is presented with options to manage books, members, and transactions.
Book Management: Admin adds or updates books, or views the list of books.
Member Management: Admin adds or updates member details.
Issue/Return Books: Admin issues or returns books based on member requests.
Reports: Admin generates reports based on books issued, overdue books, and available books.
<h5>6. Error Handling and Validations:</h5>
Input validation for member registration and book entry.
Exception handling for database operations (e.g., handling SQLExceptions).
Error messages and tooltips to guide the user during invalid operations.
This system provides a full-featured platform for managing a library's day-to-day operations efficiently with a user-friendly graphical interface and strong database support.
</div>
</div>
</div>

