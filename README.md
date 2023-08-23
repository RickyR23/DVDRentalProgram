# DVD Rental Program 

The DVD Rental Program is a simple command-line application that allows users to manage a DVD inventory, place orders for DVDs, track customer information, and perform various operations related to renting and managing DVDs.

## Features

- View a list of available commands and their descriptions using `/help`.
- List the entire inventory of DVD movies in alphabetical order using `/list`.
- Display details about a specific DVD movie's stock using `/inquire`.
- Add new DVD movie titles to the inventory using `/add`.
- Modify the stock count of a specific DVD movie using `/modify`.
- Accept, hold, or decline DVD deliveries using `/delivery` and record relevant information.
- Place orders for additional copies of DVDs using `/order` based on inventory levels.
- Record sales of DVDs and update the stock count using `/sell`.
- Handle DVD returns and update stock counts using `/return`.
- Save customer information (name and phone number) using `/customer`.
- Quit the program using `/quit`.

## How to Use

1. Compile the Java source code: `javac DVDRentalProgram.java`
2. Run the compiled program: `java DVDRentalProgram`
3. Follow the on-screen prompts and enter commands as needed.

## Notes

- The program stores data in text files like `OrderOutput.txt`, `SoldOutput.txt`, `SavedCustomers.txt`, and `DeclineReport.txt`.
- The program provides a basic interface for managing DVD rentals and inventory, but there is room for improvement in terms of input validation and user interaction.

Feel free to explore and modify the code to suit your needs and to add additional features or improvements.

This program was done for COMP 182 Class Project, Second COMP Sci Class taken. 
