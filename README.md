Your task is to build a She Code management console application (מערכת לניהול הצעות עבודה עבור מסיימות  SHE CODE).
The application should support the following characteristics:
1.	The application deals 3 types of registers :  Students ,Mentor , Allies ,Admin
2.	Each Students has the following attributes: 
a.	Type (Students ,Mentor , Allise).
b.	Alumni ID (Format – <FirstName>.<LastName>.she-codes)
c.	Password – 8 alphanumeric characters 
d.	List of courses that alumni completed successfully .
e.	LinkedIn Page , if exist
f.	Job Search Status 
i.	Not looking for change
ii.	Not looking but open for suggestions
iii.	Looking for new challenges 
3.	Each Mentor has the following attributes: 
a.	Type (Students ,Mentor , Allise).
b.	Alumni ID (Format – <FirstName>.<LastName>.she-codes)
c.	Password – 8 alphanumeric characters 
d.	List of courses that alumni completed successfully .
e.	LinkedIn Page , if exist
f.	canMentor – true if :	
i.	graduated course 
ii.	already mentored before
4.	Each Allise has the following attributes: 
a.	Type (Students ,Mentor , Allise).
b.	Alumni ID (Format – <FirstName>.<LastName>.she-codes)
c.	Password – 8 alphanumeric characters 
d.	LinkedIn Page , if exist
e.	canMentor – true if :	
i.	Y
5.	Admin – able to create user
The user is given a list of actions he\she can perform:
1.	registerNewGrad - Signing to application by providing :
a.	Alumni ID
b.	Password
And printing details
2.	sheCodesLogin - Login 
3.	Update user details (ONLY available after first Login)
4.	ShouldOfferJob – return true once user open to job offer and user meet the requirements 
5.	printUserInformation – Print user information
6.	canMentor – if graduates specific course or Allies
