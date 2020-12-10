# LoanApp

Task - Approval flow
The application should have 4 users with different roles(Role1, Role2, and Role3, Role4)
Login page with user id and password
Valid users should only be able to log in
There would be an input form once the user of Role1 logs-in
Input form Details - All the input fields are mandatory and should have proper client-side validation
Enquiry ID - Text box (Should be unique)
Customer Name - Textbox
Job type - Dropdown (Self Employed, Salaried)
Loan Amount - Textbox
Interest Rate - Textbox
Business Logic
All the Role1 submitted records should be visible to Role2
If the interest rate is greater than 14 then no approval is needed
If the interest rate is between 13 and 14 then and Role2 can approve
If the interest rate is between 12 and 13 then and Role2 can recommend and Role3 can only approve
If the interest rate is < 12 then and Role2 and Role3 users can only recommend and Role4 will approve
We should be able to understand the status easily by seeing the data in the database
Please follow the MVC structure if not using any framework. Try to develop using Hibernate
