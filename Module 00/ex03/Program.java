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

import javax.swing.plaf.synth.SynthStyle;
public class Program {
    public static void main(String args[])
    {
        Map<String, Integer> x = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String infos;
        Integer grade;
        Integer weeks_check = 1;
        String week_name;
        String[] splited = {};
        while (true)
        {
            System.out.print("-> ");
            week_name = in.nextLine();
            if (week_name.equals("42") || week_name.equals("Week " + weeks_check.toString()) == false)
                break;
            System.out.print("-> ");
            infos = in.nextLine();
            weeks_check++;
            splited = infos.split(" ");
            if (splited.length < 5)
                break;
            grade = 9;
            for (int i = 0; i < splited.length; i++)
            {
                if (grade > Integer.parseInt(splited[i]))
                    grade = Integer.parseInt(splited[i]);
            }
            x.put(week_name, grade);
        }
        in.close();
        if (week_name.equals("42") != false && (week_name.equals("Week " + weeks_check) != false || splited.length < 5))
        {
            System.out.println("IllegalArgument message");
            System.exit(-1);
        }
        for (String names : x.keySet())
        {
            System.out.print(names);
            System.out.print(" ");
            for (int index = 0; index < x.get(names); index++)
            {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}
