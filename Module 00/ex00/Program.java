/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sakllam <sakllam@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/10/19 17:17:35 by sakllam           #+#    #+#             */
/*   Updated: 2022/10/19 18:06:22 by sakllam          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */


public class Program
{
    static int x = 0;
    static void recursive(int number, int sum)
    {

        if (x == 6)
            System.out.println(sum);
        else
        {
            sum += number % 10;
            x++;
            recursive(number / 10, sum);
        }

    }

    public static void main(String args[])
    {
        int theNumber = 479598;
        recursive(theNumber, 0);
    }
}