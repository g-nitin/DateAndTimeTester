/*
Nitin Gupta

Lab 09
Date and Time Methods
 */

import java.util.Scanner;

public class DateAndTimeTester {

    public void run()
    {
        Scanner keyboard = new Scanner(System.in);

        boolean flag = true; // flag for whether the game continues at the end

        while (flag)
        {
            System.out.println("\nEnter a date and time (MM/DD hh:mm) " +
                    "and I will determine if it is valid");
            String dateTime = keyboard.nextLine();

            if (isValid(dateTime))
            {
                System.out.println("The date and time is valid!");
            }
            else
            {
                System.out.println("The date and time is not valid!");
            }

            boolean correctInput = false; // flag for whether to user input correctly
            while (!correctInput)
            {
                System.out.println("Would you like to exit? Type \"quit\" to exit or" +
                        " type \"new\" to continue");
                String wantExit = keyboard.nextLine();

                if (wantExit.equalsIgnoreCase("quit"))
                {
                    flag = false;
                    correctInput = true;
                    System.out.println("\nGood bye");
                }
                else if (wantExit.equalsIgnoreCase("new"))
                {
                    correctInput = true;
                }
                else // invalid input
                {
                    System.out.println("Invalid input." +
                            "\nPlease try again!");
                }
            }

        }

    }

    public boolean isValid(String input)
    {
        // The String parameter should be formatted “MM/DD hh:mm”

        int indexSpace = (input.indexOf(" ")); // index for the colon separating hours and minutes
        String date = input.substring(0, indexSpace); // gives the String for date
        String time = input.substring(indexSpace+1); // gives the String for time

        return isValidDate(date) && isValidTime(time);
    }

    public boolean isValidDate(String date)
    {
        // The String parameter should be formatted “MM/DD”

        int month = getMonth(date);
        int day = getDay(date);

        if (month >= 1 && month <= 12) // if month valid
        {
            if (month == 2) // feb
            {
                return day >= 0 && day <= 28;
            }

            else // month not february
            {
                // If the month has 30 days...
                if (month == 4 || month == 6 || month == 9 || month == 11)
                {
                    // true if the date is valid
                    return day >= 0 && day <= 30;
                }

                else // all months excluding Feb and the all 30-day months
                {
                    // true if the date is valid
                    return day >= 0 && day <= 31;
                }
            }
        }

        else // month not valid
        {
            return false;
        }

    }

    public boolean isValidTime(String time)
    {
        // The String parameter should be formatted “hh:mm”

        int hour = getHour(time);
        int minutes = getMinute(time);

        // check boundaries
        return hour >= 0 && hour <= 12 && minutes >= 0 && minutes <= 60;
    }

    public int getMonth(String input)
    {
        // The String parameter is expected to be formatted “MM/DD”

        int indexSlash = (input.indexOf("/")); // index for the slash separating month and day
        String month = input.substring(0, indexSlash); // gives the String for month

        return Integer.parseInt(month); // convert String to int
    }

    public int getDay(String input)
    {
        // The String parameter is expected to be formatted “MM/DD”

        int indexSlash = (input.indexOf("/")); // index for the slash separating month and day
        String day = input.substring(indexSlash+1); // gives the String for day

        return Integer.parseInt(day); // convert String to int
    }

    public int getHour(String input)
    {
        // The String parameter is expected to be formatted “hh:mm”

        int indexColon = (input.indexOf(":")); // index for the colon separating hours and minutes
        String hours = input.substring(0, indexColon); // gives the String for hours

        return Integer.parseInt(hours); // convert String to int
    }

    public int getMinute(String input)
    {
        // The String parameter is expected to be formatted “hh:mm”

        int index = (input.indexOf(":")); // gives index for the colon separating hours and minutes
        String min = input.substring(index+1); // gives the String for minutes

        return Integer.parseInt(min);
    }



}
