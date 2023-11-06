/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/10/19 18:09:48 by sakllam           #+#    #+#             */
/*   Updated: 2023/11/04 21:49:56 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;

/*
 * Given an integer n, choose some integer a coprime to n and calculate an − 1 modulo n.
 * If the result is different from 1, then n is composite. If it is 1, then n may be prime.
 */
public class Program {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int iternb = 1;
        System.out.print("-> ");
        // try {
        int i = x.nextInt();
        if (i <= 0) {
            System.err.println("IllegalArgument");
            x.close();
            return;
        }
        for (int number = 2; number * number <= i; number++) {
            if (i % number == 0) {
                System.out.print("false ");
                System.out.println(iternb);
                x.close();
                return;
            }
            iternb++;
        }
        System.out.print("true ");
        System.out.println(iternb);
        x.close();
        // } catch (InputMismatchException e) {
        // System.err.println("IllegalArgument");
        // }
    }
}