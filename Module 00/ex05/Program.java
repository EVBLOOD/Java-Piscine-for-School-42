/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/11/02 17:16:34 by sakllam           #+#    #+#             */
/*   Updated: 2023/11/04 18:13:51 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        String[] names = new String[10];
        String[] timeDay = new String[5];
        // int Weeks = 0;
        String[] listOfAttendence = new String[10 * 10 * 5];
        String var;
        String varRead;
        boolean found;
        int monthDay = 0;

        while (index < 10) {
            System.out.print("-> ");
            var = scanner.nextLine();
            if (var.equals("."))
                break;
            names[index] = var;
            index++;
        }
        String times = "";
        // while (Weeks < 5) {
        index = 0;
        while (index < 5) {
            System.out.print("-> ");
            times = scanner.next();
            if (times.equals("."))
                break;
            if (times.length() > 1 || times.toCharArray()[0] < '1' || times.toCharArray()[0] > '6') {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            String day = scanner.nextLine();
            if (!day.equals(" MO") && !day.equals(" TH") && !day.equals(" TU") && !day.equals(" WE")
                    && !day.equals(" FR")) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            found = false;
            for (int z = 0; timeDay[z] != null; z++) {
                if (timeDay[z].equals(times + day)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.err
                        .println("IllegalArgument: You've already inserted this same day and time!\nPlease try again.");
                continue;
            }
            timeDay[index] = times + day;
            index++;
        }
        index = 0;
        String[] days = { "MO", "TH", "TU", "WE", "FR" };
        while (true) {
            var = "";
            System.out.print("-> ");
            varRead = scanner.next();
            if (varRead.equals("."))
                break;
            found = false;
            for (int i = 0; names[i] != null; i++) {
                if (names[i].equals(varRead)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            var += varRead;
            varRead = scanner.next();
            if (varRead.length() != 1 || varRead.toCharArray()[0] < '1' || varRead.toCharArray()[0] > '6') {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            var = var + " " + varRead;
            monthDay = scanner.nextInt();
            if (monthDay <= 0 || monthDay >= 31) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            if (monthDay % 7 > 4) {
                System.err.println("IllegalArgument: We only work from MO to FR");
                System.exit(-1);
            }
            found = true;
            for (int i = 0; timeDay[i] != null; i++) {
                if (timeDay[i].equals(varRead + " " + days[monthDay % 7])) {
                    found = false;
                    break;
                }
            }
            if (found) {
                System.err.println("IllegalArgument: The class time/day doesn't exists on timeline");
                System.exit(-1);
            }
            var = var + " " + monthDay;
            varRead = scanner.nextLine();
            if (!varRead.equals(" HERE") && !varRead.equals(" NOT_HERE")) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            var += varRead;
            listOfAttendence[index] = var;
            System.err.println(listOfAttendence[index]);
            index++;
        }
        for (int i = 0; i < listOfAttendence.length; i++) {

        }
        // start is => number % 7 == 0, end is => 11 % 7 == 4
        // System.out.println("names");
        // for (int i = 0; names[i] != null; i++) {
        // System.out.println(names[i]);
        // }
        // System.out.println("timeDay");
        // for (int i = 0; i < Weeks; i++) {
        // for (int j = 0; null != timeDay[i][j]; j++) {
        // System.out.println(timeDay[i][j]);
        // }
        // }
        // System.err.println("listOfAttendence");
        // for (int i = 0; null != listOfAttendence[i]; i++) {
        // System.out.println(listOfAttendence[i]);
        // }
        scanner.close();
    }
}
