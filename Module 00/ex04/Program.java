/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.Java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/10/31 16:38:25 by sakllam           #+#    #+#             */
/*   Updated: 2023/11/01 22:48:19 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

public class Program {

    static int search(char[] lol, int[] array, int left, int right, int target, char xyz) {
        int midel = left + ((right - left) / 2);
        if (midel > right)
            return (-1);
        if (midel == 0 ||
                ((target < array[midel - 1] || ((target == array[midel - 1] && xyz > lol[midel - 1])))
                        && (target > array[midel] || (target == array[midel] && xyz > lol[midel])))) {
            if (midel == 0)
                return midel;
            if (target == array[midel - 1] && xyz > lol[midel - 1])
                return (midel - 1);
            return (midel);
        }
        if (target > array[midel])
            return search(lol, array, left, midel - 1, target, xyz);
        else if (target < array[midel])
            return search(lol, array, midel + 1, right, target, xyz);
        else if (xyz < lol[midel])
            return search(lol, array, midel + 1, right, target, xyz);
        return midel;
    }

    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);

        System.out.print("-> ");
        String input = x.nextLine();
        x.close();
        char[] all = input.toCharArray();
        char[] ExistingChars = new char[256];
        int[] OutStandingints = new int[10];
        char[] OutStandingChars = new char[10];
        int j = 0;
        boolean NotExits;
        int counter;
        int AllIn = 0;

        for (int i = 0; i < all.length; i++) {
            NotExits = true;
            for (int y = 0; y < j; y++) {
                if (all[i] == ExistingChars[y]) {
                    NotExits = false;
                    break;
                }
            }
            if (NotExits) {
                counter = 0;
                ExistingChars[j] = all[i];
                for (int k = 0; k < all.length; k++) {
                    if (ExistingChars[j] == all[k])
                        counter++;
                }
                int index = search(OutStandingChars, OutStandingints, 0, OutStandingints.length - 1, counter,
                        all[i]);
                if (index >= OutStandingints.length - 1 || index == -1)
                    continue;
                // System.err.println(index);
                for (int k = OutStandingints.length - 1; k != index; k--) {
                    OutStandingints[k] = OutStandingints[k - 1];
                }
                for (int k = OutStandingChars.length - 1; k != index; k--) {
                    OutStandingChars[k] = OutStandingChars[k - 1];
                }
                j++;
                OutStandingints[index] = counter;
                OutStandingChars[index] = all[i];
                AllIn += counter;
            }
        }
        System.err.println(AllIn);
        System.err.println(AllIn / 100);
        int limit = 10 < ExistingChars.length ? 10 : ExistingChars.length;
        for (int k = 10; k >= 0; k--) {
            for (int i = 0; i < limit; i++) {
                if (OutStandingints[i] / OutStandingints[0] * 10 == k) {
                    if (i != 0)
                        System.err.print(" ");
                    System.out.print(OutStandingints[i]);
                    if (i != limit - 1)
                        System.err.print(" ");
                    if (i == limit - 1)
                        System.out.println("");
                } else if (OutStandingints[i] / OutStandingints[0] * 10 > k) {
                    if (i != 0)
                        System.err.print(" ");
                    System.out.print("#");
                    if (i != limit - 1)
                        System.err.print(" ");
                    if (i == limit - 1)
                        System.out.println("");
                } else {
                    if (i != 0)
                        System.err.print(" ");
                    System.out.print(" ");
                    if (i != limit - 1)
                        System.err.print(" ");
                    if (i == limit - 1)
                        System.out.println("");
                }
            }

            // for (int i = 0; i < 10 && i < ExistingChars.length; i++) {
            // if (OutStandingints[i] / OutStandingints[0] * 10 == k) {
            // System.out.print(OutStandingints[i]);
            // if (k != 0)
            // System.err.print(" ");
            // } else if (OutStandingints[i] > k) {
            // if (i != 0 && i != 10)
            // System.err.print(" ");
            // System.out.print("#");
            // if (i != 9 || i != ExistingChars.length - 1)
            // System.err.print(" ");
            // } else
            // System.out.print(" ");
            // }
            // System.out.println();
        }

    }
}
