/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/10/19 18:09:48 by sakllam           #+#    #+#             */
/*   Updated: 2022/10/19 18:54:47 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;

public class Program {
    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        int iternb = 1;
        System.out.print("-> ");
        // try {
        int i = x.nextInt();
        if (i <= 0) {
            System.err.println("IllegalArgument");
            return;
        }
        for (int number = 2; number * number <= i; number++) {
            if (i % number == 0) {
                System.out.print("false ");
                System.out.println(iternb);
                return;
            }
            iternb++;
        }
        System.out.print("true ");
        System.out.println(iternb);
        // } catch (InputMismatchException e) {
        // System.err.println("IllegalArgument");
        // }
    }
}