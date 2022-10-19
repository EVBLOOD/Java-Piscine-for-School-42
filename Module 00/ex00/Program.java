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
    public static void main(String args[])
    {
        int i = 479598;
        int sum = 0;
        while (i != 0)
        {
            sum += i % 10;
            i = i / 10;
        }
        System.out.println(sum);
    }
}