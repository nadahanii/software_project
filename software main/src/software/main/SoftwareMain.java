/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Hager
 */
public class SoftwareMain {

    static interface Notification_template {

        public boolean create_message_template(template t);

        public boolean update_message_template(template t);

        public boolean delete_message_template(int id);

        public void read_message_template();

        public template get_template(int id);
    }

    public static class Notifications implements Notification_template {

        ArrayList<template> templates = new ArrayList<>();

        public boolean create_message_template(template t) {
            if (templates.indexOf(t) == -1) {
                templates.add(t);
                return true;
            } else {
                System.out.println("already exists!");
                return false;
            }
        }

        public boolean update_message_template(template t) {
            template temp;
           // System.out.println("template subject: " + t.subject); System.out.println("template content: " +t.content);
            // System.out.println("template language: " + t.language);
             // System.out.println("template id : " + t.id);
            System.out.println("enter template id , content , subject , language ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            input.nextLine();
            String content = input.nextLine();
            String subject = input.nextLine();
            System.out.println("choose language : 1- arabic  2-english");
            int choice = input.nextInt();
            if (choice == 1) {
                temp = new template(id, content, subject, langenum.Arabic);

            } else {
                temp = new template(id, content, subject, langenum.English);
            }
          /*  int tempn = templates.indexOf(t);
            System.out.println("tempn::  "+tempn);
            templates.(tempn, temp);
            templates.re*/
           for (int i = 0; i < templates.size(); i++) {
               System.out.println("i  "+i);
               if(templates.get(i).content.equalsIgnoreCase(t.content) && templates.get(i).subject.equalsIgnoreCase(t.subject) && templates.get(i).id==t.id && templates.get(i).language==t.language)
               {
                   //System.out.println("la2ethaaaaaa");
                   templates.remove(i);
                   templates.add(i, temp);
                   return true;
               }     
            }
            return false;
        }

        public boolean delete_message_template(int id) {
            for (int i = 0; i < templates.size(); i++) {
                if (templates.get(i).id == id) {
                    templates.remove(templates.get(i));
                    return true;
                }
            }
            System.out.println("not found !");
            return false;
        }

        public void read_message_template() {
            for (int i = 0; i < templates.size(); i++) {
                System.out.println("template subject: " + templates.get(i).subject);
                System.out.println("template content: " + templates.get(i).content);
                System.out.println("template id: " + templates.get(i).id);
                System.out.println("template language: " + templates.get(i).language);
            }
        }

        public template get_template(int id) {
            for (int i = 0; i < templates.size(); i++) {
                if (templates.get(i).id == id) {
                    return templates.get(i);
                }
            }
            System.out.println("template not found!");
            return null;
        }
    }

    static public class template {

        int id;
        String subject, content;
        langenum language;

        template(int idd, String c, String s, langenum l) {
            language = l;
            id = idd;
            content = c;
            subject = s;
        }

    }

    enum langenum {
        English, Arabic;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Notifications notifications = new Notifications();
        while (true) {
            System.out.println("1-create template   2-read templates  3-delete template by id  4-update template  5- get template by id");
            int choice;
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice == 1) {
                template temp;
                System.out.println("enter template id  content , subject ,  language ");
                int id = input.nextInt();
                input.nextLine();
                String content = input.nextLine();
                String subject = input.nextLine();
                System.out.println("choose language : 1- arabic  2-english");
                int choice2 = input.nextInt();
                if (choice2 == 1) {
                    temp = new template(id, content, subject, langenum.Arabic);

                } else {
                    temp = new template(id, content, subject, langenum.English);
                }
                notifications.create_message_template(temp);
            } else if (choice == 2) {
                notifications.read_message_template();
            } else if (choice == 3) {
                int id = input.nextInt();
                notifications.delete_message_template(id);
            } else if (choice == 4) {
                template temp;
                System.out.println("enter template id  content , subject ,  language ");
                int id = input.nextInt();
                input.nextLine();
                String content = input.nextLine();
                String subject = input.nextLine();
                System.out.println("choose language : 1- arabic  2-english");
                int choice2 = input.nextInt();
                if (choice2 == 1) {
                    temp = new template(id, content, subject, langenum.Arabic);

                } else {
                    temp = new template(id, content, subject, langenum.English);
                }
                notifications.update_message_template(temp);

            } else if (choice == 5) {
                int id = input.nextInt();
                notifications.get_template(id);
            } else {
                System.out.println("invalid choice");
                break;
            }
        }
    }
}
