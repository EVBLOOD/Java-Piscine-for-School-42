/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/10/31 16:38:25 by sakllam           #+#    #+#             */
/*   Updated: 2023/11/04 21:49:56 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

public class Program {

    static int search(char[] charTable, int[] array, int target, char charTarget) {
        int index = -1;
        int finalIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= target) {
                index = i;
                break;
            }
        }
        if (index == -1 || array[index] < target)
            return index;
        finalIndex = index;
        for (int i = index; i < charTable.length && array[i] == target; i++) {
            if (charTarget > charTable[i])
                finalIndex = i + 1;
        }
        return finalIndex;
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("-> ");
        String input = x.nextLine();
        x.close();
        char[] all = input.toCharArray();
        char[] ExistingChars = new char[65536];
        int[] OutStandingints = new int[10];
        char[] OutStandingChars = new char[10];
        int j = 0;
        boolean NotExits;
        int counter;
        int CharsNumber = 0;

        for (int i = 0; i < all.length; i++) {
            NotExits = true;
            for (int y = 0; y < j; y++) {
                if (all[i] == ExistingChars[y]) {
                    NotExits = false;
                    break;
                }
            }
            if (NotExits) {
                CharsNumber++;
                counter = 0;
                ExistingChars[j] = all[i];
                for (int k = 0; k < all.length; k++) {
                    if (ExistingChars[j] == all[k])
                        counter++;
                }
                j++;
                int index = search(OutStandingChars, OutStandingints, counter, all[i]);
                if (index >= OutStandingints.length - 1 || index == -1)
                    continue;
                for (int k = OutStandingints.length - 1; k != index; k--) {
                    OutStandingints[k] = OutStandingints[k - 1];
                    OutStandingChars[k] = OutStandingChars[k - 1];
                }
                OutStandingints[index] = counter;
                OutStandingChars[index] = all[i];
            }
        }
        int limit = 10 < CharsNumber ? 10 : CharsNumber;
        for (int k = 10; k >= 0; k--) {
            for (int i = 0; i < limit; i++) {
                if ((int) ((double) OutStandingints[i] / OutStandingints[0] * 10) == k) {
                    System.out.printf("%3d", OutStandingints[i]);
                } else if ((int) ((double) OutStandingints[i] / OutStandingints[0] * 10) > k) {
                    System.out.printf("%3s", "#");
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < limit; i++) {
            System.out.printf("%3s", OutStandingChars[i]);
        }
        System.out.println("");
    }
}
