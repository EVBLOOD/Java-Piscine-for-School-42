/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/10/19 18:56:34 by sakllam           #+#    #+#             */
/*   Updated: 2023/11/02 17:17:39 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;

public class Program {
    static int ft_sum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    static Boolean ft_isprime(int i) {
        for (int number = 2; number * number <= i; number++) {
            if (i % number == 0)
                return false;
        }
        return true;
    }

    public static void main() {
        Scanner in = new Scanner(System.in);

        int number;
        int total = 0;
        while (true) {
            System.out.print("-> ");
            number = in.nextInt();
            if (number <= 0) {
                System.err.println("IlegalArgument");
                in.close();
                return;
            }
            if (number == 42)
                break;
            if (ft_isprime(ft_sum(number)))
                total++;
        }
        System.out.println("Count of coffee-request - " + total);
        in.close();
    }
}