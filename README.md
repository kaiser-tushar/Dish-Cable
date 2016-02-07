# Dish-Cable
Dish Cable System provides day to day transaction support for Dish Cable Company.

In this application we have two users: Owners and Employee. 

<h2>Owner Account</h2>
•It will ask for Username and Password and Account Type. Both Username andPassword is: <b>admin</b> for owner.

•After successful Login, owner can see the menu like below:

![alt text](http://imgur.com/Vkazhax.png)

• There are several options. First if owner wants to know about transaction, then he can use <b>“Payment Information”</b>. If customer did not pay his bill regularly/monthly, then his status will be “Inactive” and will be listed in “Monthly Bill” table. Also, there are some other charges like taking a new line, change customer address which are listed in “Other” table. Here owner can search for particular information. If owner wants to see how many new lines are taken in 02-Jun-2015, then he can search like below:

![alt text](http://imgur.com/ZdOg3bb.png)

• Owner can create employee account by clicking <b>“Employee Account”</b> in menu.

• Owner can check total transaction by clicking <b>“Total Earnings”</b>.

![alt text](http://imgur.com/amHwZj0.png)

• Owner can also change his name and password by clicking <b>“Change Username/Password”</b>.

<h2>Employee Account</h2>

• Employee can be created by <b>Owner</b> only. After successful Login, employee can see the menu like below:

![alt text](http://imgur.com/zKEEYXb.png)

• Employee will create entry of paying bill of customers by clicking <b>“Pay Bill”</b>. There are several types of bills like <b>monthly bill</b> for monthly subscription, <b>New line</b> for taking new subscription, <b>Change</b> for changing the area.

• If employee wants to enter monthly subscription bill, he will use user’s <b>phone number</b> to locate the user. He can take help from <b>“Customer Information”</b>.

![alt text](http://imgur.com/Ilea2uG.png)

• From Customer information table, employee will copy his <b>mobile number</b>.

![alt text](http://imgur.com/RedpGyj.png)

• Then in the <b>Monthly Bill payment</b> option, employee will paste that copied mobile number and then all the necessary information will be given for transaction.

![alt text](http://imgur.com/JNEmK0w.png)

• Employee can also change his name and password by clicking <b>“Change Username/Password”</b>.

Note:In this project we use SQLite Database with "dishcable.sqlite" name. It's a Java Swing Project. Need JVM to run.
