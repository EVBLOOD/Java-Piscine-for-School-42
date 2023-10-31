/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/12/20 17:17:26 by sakllam           #+#    #+#             */
/*   Updated: 2022/12/20 19:45:30 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// public class Program {
//     public static void main(String args[]) {
//         Map<String, Integer> x = new HashMap<>();
//         Scanner in = new Scanner(System.in);
//         String infos;
//         Integer grade;
//         Integer weeks_check = 1;
//         String week_name;
//         String[] splited = {};
//         while (true) {
//             System.out.print("-> ");
//             week_name = in.nextLine();
//             if (week_name.equals("42") || week_name.equals("Week " + weeks_check.toString()) == false)
//                 break;
//             System.out.print("-> ");
//             infos = in.nextLine();
//             weeks_check++;
//             splited = infos.split(" ");
//             if (splited.length < 5)
//                 break;
//             grade = 9;
//             for (int i = 0; i < splited.length; i++) {
//                 if (grade > Integer.parseInt(splited[i]))
//                     grade = Integer.parseInt(splited[i]);
//             }
//             x.put(week_name, grade);
//         }
//         in.close();
//         if (week_name.equals("42") != false
//                 && (week_name.equals("Week " + weeks_check) != false || splited.length < 5)) {
//             System.out.println("IllegalArgument message");
//             System.exit(-1);
//         }
//         for (String names : x.keySet()) {
//             System.out.print(names);
//             System.out.print(" ");
//             for (int index = 0; index < x.get(names); index++) {
//                 System.out.print("=");
//             }
//             System.out.println(">");
//         }
//     }
// }

public class Program {

    static void recursive(long number, int week_number) {

        if (number == 0)
            return;
        else {
            recursive(number / 10, --week_number);
            System.out.print("week ");
            System.out.print(week_number);
            System.out.print(" ");
            for (int i = 0; i < number % 10; i++)
                System.out.print("=");
            System.out.println(">");
        }

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String week_name;
        int week_number;
        int infos;
        int min;
        int LastWeek = 0;
        long result = 0;
        while (LastWeek != 18) {
            System.out.print("-> ");
            week_name = in.next();
            if (week_name.equals("42"))
                break;
            if (week_name.equals("Week") == false) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            week_number = in.nextInt();
            if (week_number - 1 != LastWeek) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            LastWeek = week_number;
            in.nextLine();
            System.out.print("-> ");
            min = 10;
            for (int i = 0; i < 5; i++) {
                infos = in.nextInt();
                if (infos <= 0 || infos > 9) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                min = infos > min ? min : infos;
            }
            result *= 10;
            result += min;
            in.nextLine();
        }
        in.close();
        recursive(result, LastWeek + 1);
    }
}
