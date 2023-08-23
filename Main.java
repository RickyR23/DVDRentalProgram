import java.util.*;
import java.io.*;
class DVDRentalApplication{


    public static void main(String[] args) throws FileNotFoundException, IOException{

        File file = new File("OrderOutput.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        File newFile = new File("SoldOutput.txt");
        FileWriter flwr = new FileWriter(newFile, true);
        PrintWriter prwr = new PrintWriter(flwr);

        File fileNew = new File("SavedCustomers.txt");
        FileWriter fileWriter = new FileWriter(fileNew, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        File fl = new File("DeclineReport.txt");
        FileWriter fileWr = new FileWriter(fl, true);
        PrintWriter printWr = new PrintWriter(fileWr);

        System.out.println("Welcome to the DVD Rental Program, to beigin please enter /help for a list of commands and operations.");

        LinkedList<String> dvdList = new LinkedList<String>();
        Iterator<String> iter;
        dvdList.add("Inception (2010)");
        dvdList.add("Interstellar (2014)");
        dvdList.add("The Dark Knight (2008);");
        dvdList.add("The Dark Knight Rises (2012)");
        dvdList.add("Top Gun (1986)");
        dvdList.add("Cars (2006)");
        dvdList.add("Final Destination (2000)");
        dvdList.add("Man of Steel (2013)");
        dvdList.add("The Shawshank Redemption (1994)");
        dvdList.add("Alien (1979)");
        dvdList.add("Prometheus (2012)");
        dvdList.add("2012 (2009)");
        dvdList.add("Toy Story (1995)");
        dvdList.add("The Wizard of Oz (1939)");
        dvdList.add("Rebel Without a Cause (1955)");
        dvdList.add("Avengers: Endgame (2019)");
        dvdList.add("Parasite (2019)");
        dvdList.add("The Godfather (1972)");
        dvdList.add("Goodfellas (1990)");
        dvdList.add("Casino (1995)");
        dvdList.add("Heat (1995)");
        dvdList.add("Public Enemies (2009)");
        dvdList.add("Donnie Brasco (1997)");

        LinkedList<Integer> dvdStock = new LinkedList<Integer>();
        dvdStock.add(0, 4);
        dvdStock.add(1, 10);
        dvdStock.add(2, 3);
        dvdStock.add(3, 5);
        dvdStock.add(4, 2);
        dvdStock.add(5, 7);
        dvdStock.add(6, 4);
        dvdStock.add(7, 10);
        dvdStock.add(8, 1);
        dvdStock.add(9, 14);
        dvdStock.add(10, 3);
        dvdStock.add(11, 7);
        dvdStock.add(12, 0);
        dvdStock.add(13, 11);
        dvdStock.add(14, 14);
        dvdStock.add(15, 33);
        dvdStock.add(16, 5);
        dvdStock.add(17, 7);
        dvdStock.add(18, 0);
        dvdStock.add(19, 9);
        dvdStock.add(20, 52);
        dvdStock.add(21, 16);
        dvdStock.add(22, 1);

        LinkedList<Integer> dvdWant = new LinkedList<Integer>();


        iter = dvdList.listIterator();
        Scanner want = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);

        String help = sc.next();
        if (help.equals("/help")){
            System.out.println("/help (Obtains a full list of commands and options)");
            System.out.println("/list (Lists the entire inventory of DVD's in alphabetical order)");
            System.out.println("/inquire (Displays the inventory of a specific title)");
            System.out.println("/add (Adds a new title to the inventory.)");
            System.out.println("/modify (Modifies the want value for a specified title)");
            System.out.println("/delivery (Takes the delivery of a shipment of DVDs)");
            System.out.println("/order (Create an order for additional DVD's based on inventory value)");
            System.out.println("/return (For returning orders & decreasing the have values on the basis of want values)");
            System.out.println("/sell (Decreases the count of a specified title by 1)");
            System.out.println("/quit (Saves Inventory & waitlist in a file and terminates execution)");
            System.out.println("/customer (Retrieves customer profile creation)");
        }

        Scanner slashHelp = new Scanner(System.in);
        String command = slashHelp.next();
        if (command.equals("/customer")){      // create another text file to generate for / customer
            System.out.println("----------");   // make a layout for every customer input to add to both the linked list (which is already done in line 98)
            System.out.println("Enter full name of customer: "); // and make it print in the text file the name and customer number in the text file to save into the system

            LinkedList<String> customers = new LinkedList<String>();
            LinkedList<String> customersNum = new LinkedList<String>();

            Scanner customer = new Scanner(System.in);
            customers.add(customer.nextLine());

            System.out.println(customers);
            System.out.println("Enter Customers number (With dashes): ");

            String customerNum = customer.next();
            customersNum.add(customerNum);
            System.out.println(customersNum);

            printWriter.println("---------- Saved Customer ----------");
            printWriter.println("Name of customer: " + customers.get(0));
            printWriter.println("Phone Number of Customer: " + customersNum.get(0));
            printWriter.close();
        }
        else if (command.equals("/list")){
            System.out.println("----------");
            System.out.println("DVD movies that we have! (Note: stock differs per movie, check /inquire).");
            Collections.sort(dvdList);
            while(iter.hasNext()){
                String nextItem = iter.next();
                System.out.println(dvdList.indexOf(nextItem) + ") " + nextItem);
            }
        }
        else if(command.equals("/inquire")){
            System.out.println("-----------");
            Collections.sort(dvdList);
            System.out.println("Instructions: Obtain movie list by using /list , then obtain the desired movie's number that is shown on the far left.");
            System.out.println("Input that number ONCE to obtain the number of in-stock DVD's. Ex ('0') without ' symbol:");
            Scanner inquire = new Scanner(System.in);
            int movieStockNum = inquire.nextInt();
            System.out.println(dvdList.get(movieStockNum) + " has " + dvdStock.get(movieStockNum) + " in stock.");
        }
        else if(command.equals("/add")){
            System.out.println("----------");
            System.out.println("Add new movie title, *Movie Name* (*Year of Release*): ");
            Scanner add = new Scanner(System.in);
            String movie = add.nextLine();
            dvdList.add(new String (movie));
            Collections.sort(dvdList);
            System.out.println("New movie list in alphabetical order: ");
            Iterator it = dvdList.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }

        else if(command.equals("/modify")){
            System.out.println("----------");
            Collections.sort(dvdList);
            System.out.println("To start off, please enter the desired movies number that is shown on the /list (press enter).");
            System.out.println("Then enter the amount of dvd's in stock that will update the old stock num, ex: ('23') (press enter again). ");
            Scanner modifyMovie = new Scanner(System.in);
            Scanner modifyMovieStock = new Scanner(System.in);
            int movieNumberModify = modifyMovie.nextInt();
            dvdStock.add(movieNumberModify, modifyMovieStock.nextInt());
            System.out.println("New stock for chosen movie:");
            System.out.println(dvdList.get(movieNumberModify) + " has: " + dvdStock.get(movieNumberModify) + " in stock.");
        }

        else if(command.equals("/delivery")){
            System.out.println("-----------");
            System.out.println("Delivery System: To accept, hold or decline a delivery for whatever reason.");
            System.out.println("Please enter /accept , /hold or /decline and you will be prompted with further details on what to do.");
            Scanner deliveryInput = new Scanner(System.in);
            String delivery = deliveryInput.next();
            if (delivery.equals("/hold")){
                System.out.println("If you want to place the delivery on hold,  please enter the date you want it to be delivered in the format mm/dd/yyyy (with slashes).");
                Scanner date = new Scanner(System.in);
                LinkedList<String> holdDate = new LinkedList<String>();
                holdDate.add(date.next());
                System.out.println("Your hold date has been set to: "+ holdDate.get(0) + ".");
            }
            if (delivery.equals("/accept")){
                System.out.println("Delivery has been accepted and implemented into the inventory.");
            }
            if (delivery.equals("/decline")){
                System.out.println("Please Enter decline date: ");

                Scanner date = new Scanner(System.in);
                String dateInput = date.nextLine();

                System.out.println("Inputed date: " + dateInput);
                System.out.println("Please Enter your reason for declining the delivery and input a proper report: ");

                LinkedList<String> declineReport = new LinkedList<String>();   // add the print out to text pad with the date And with a copy of the reasoning.
                Scanner report = new Scanner(System.in);
                String reportInput = report.nextLine();

                declineReport.add(reportInput);

                System.out.println("Here is a copy of your delivery decline report: ");
                System.out.println(declineReport.get(0));
                System.out.println("A copy of the decline report has also been saved on your system.");

                printWr.println("-------- Delivery Decline Report ---------");
                printWr.println("Date of delivery decline: " + dateInput);
                printWr.println("Copy of decline reasoning: " + reportInput);
                printWr.close();
            }
        }

        else if(command.equals("/order")){
            System.out.println("-----------");
            System.out.println("Please enter movie number twice (Ex. '0 0') to place an order for more DVD's.");
            System.out.println("If the movie stock has more than 5, restock orders are not necessary. To see specific movie stock enter /inquire.");
            Scanner order = new Scanner(System.in);
            if (dvdStock.get(order.nextInt()) <= 5){
                Collections.sort(dvdList);
                int movieNumber = order.nextInt();

                System.out.println("Please Enter want value for the desired movie stock for an order to be placed: "); // user enters want value which will be placed into dvdWant linked list, under the same node number that the movie is designated to. then when /delivery works, we can recall that linked list make that replace and update the have value for the designated movie
                pw.println("------- Receipt Transaction of ordered movie -------");
                pw.println("Want value of desired movie: "  + dvdList.get(movieNumber));
                pw.println("Stock orderd: ");
                dvdWant.add(want.nextInt());
                pw.println(dvdWant.get(0));
                Random randomNum = new Random();
                int rand = randomNum.nextInt(10);
                System.out.println("Order has been placed, delivery should be successful within " + rand + " days.");
                pw.println("DVD Order has been placed, your oder should arrive within: ");
                pw.println(rand + " days.");
                pw.close();
            }
            else if (dvdStock.get(order.nextInt()) > 5){
                System.out.println("Movie Stock is greater than 5!");
            }
        }

        else if(command.equals("/sell")){
            System.out.println("-------------");
            System.out.println("To see inventory/stock of movie please use /inquire.");
            System.out.println(" ");
            System.out.println("To register a sold movie, Enter movie number once, ex. ('0')");
            Scanner movNumber = new Scanner(System.in);
            int movieNumber = movNumber.nextInt();
            if (dvdStock.get(movieNumber) > 0){
                Collections.sort(dvdList);
                dvdStock.add(movieNumber, dvdStock.get(movieNumber) - 1);
                prwr.println("------------- Reciept of movie sold ---------------");
                prwr.println("Name of movie: " + dvdList.get(movieNumber));
                prwr.println("Number of items sold from specified movie: ");
                prwr.println("1");
                System.out.println("Updated stock after selling: " + dvdList.get(movieNumber) + ": " + dvdStock.get(movieNumber));
                prwr.println("Updated Stock After selling " + dvdList.get(movieNumber) + ": " + dvdStock.get(movieNumber));
            }
            else if (dvdStock.get(movNumber.nextInt()) == 0){
                System.out.println("Movie is out of stock! Order more by using /order .");
            }
            prwr.close();
        }

        else if(command.equals("/return")){
            System.out.println("-----------");
            Collections.sort(dvdList);
            System.out.println("To accept a DVD movie return, please enter the movie's designated number found in /list once (Ex. '0'): ");
            System.out.println("After entering the designated movie number twice, enter the number of returns for that designated movie stock: ");
            Scanner movieInt = new Scanner(System.in);
            Scanner movieReturn = new Scanner(System.in);
            int movieIntInput = movieInt.nextInt();
            dvdStock.add(movieIntInput, dvdStock.get(movieIntInput) + movieReturn.nextInt());
            System.out.println("Updated Stock for requested movie after return: ");
            System.out.println(dvdList.get(movieIntInput) + " has " + dvdStock.get(movieIntInput) + " in stock.");
        }

        else if(command.equals("/quit")){
            System.exit(0);
        }
    }
}