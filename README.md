# SQLite DBHelper

⋅⋅1 a. What is the use of SQLite open helper class in SQLite?

--Ans: SQLite Open Helper class is an abstract class which contains abstract methods like onCreate/onUpgrade.These methods helps us to create and alter the specified table respectively.

⋅⋅2 b. What is the use of OnUpgrade function in SQLiteOpenHelper class?
--Ans:If we want to alter the table contents like changing/addition/deletion of the columns  we can opt for OnUpgrade function.


⋅⋅3 c. How to show SQLite database table information in Android application what is the best way to do it?
---Ans:Based on the project requirements we can show data on the android application using android widgets like textview,Listview.
The best approach would be to use DBHelper(the customized generic class) which contains view,update,delete functions.This helper class should be added to the project and can be used whenever required.This class can also be used on other projects.]
